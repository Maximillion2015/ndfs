

package ndfs.nameserver.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import ndfs.core.cache.ChannelCache;
import ndfs.core.cache.exception.CommonException;
import ndfs.core.common.BootLoader;
import ndfs.core.common.StatusCodeEnum;
import ndfs.core.common.model.BlockInfoInHeartBeat;
import ndfs.nameserver.core.BlockInfo;


public class BlockManager {
    private static Map<Long, BlockInfo> totalBlockInfo = new ConcurrentHashMap<Long, BlockInfo>();
    
    private static Map<Long, BlockInfo> writableBlockInfo = new ConcurrentHashMap<Long, BlockInfo>();
    private static final String keyForMinWritableBlockCount = "min.writableBlock.count";
    private static final int minWritableBlockCount = getMinWritableBlockCount();
    

    private static final int getMinWritableBlockCount() {
        return Integer.valueOf(BootLoader.getProperties(keyForMinWritableBlockCount));
    }
    public static void LoadHeartBeatInfo(List<BlockInfoInHeartBeat> blockInfoInHeartBeatList) {
        //TODO
        return;
    }
    
    public static void list() {
        System.out.println(totalBlockInfo.toString());
    }
    

    public static boolean needCreateBlock() {
        if(ServerManager.size() == 0) return false;
        return writableBlockInfo.size() < minWritableBlockCount;
    }
    

    public static void addNewBlock(long blockId, List<Integer> dataserverList) {
        BlockInfo blockInfo = BlockInfo.newBlock(blockId, dataserverList);
        //先放到total里面，再放到writable里面，防止出错
        totalBlockInfo.put(blockInfo.getId(), blockInfo);
        writableBlockInfo.put(blockInfo.getId(), blockInfo);
    }
    

    @SuppressWarnings("unused")
    public static BlockInfo findWritableBlock() {
        Set<Long> set = writableBlockInfo.keySet();
        Random random = new Random(System.currentTimeMillis());
        int index = (int) random.nextInt(set.size());
        int i=0;
        BlockInfo blockInfo = null;
        for(Long blockId : set) {
            if(i==index) {
                return writableBlockInfo.get(blockId);
            }
            i++;
        }
        if(blockInfo == null) {
            throw new CommonException(StatusCodeEnum.UN_KNOWN_ERROR);
        }
        while(tryWriteBlock(blockInfo) == false) {
            blockInfo = findWritableBlock();
        }
        return blockInfo;
    }
    
    
    public static String findReadableBlock(long blockId) {
       BlockInfo blockInfo = writableBlockInfo.get(blockId);
       if(blockInfo == null) {
           throw new CommonException(StatusCodeEnum.UN_KNOWN_ERROR, "寻找可读块时出现错误");
       }
       List<Integer> serverIdList = blockInfo.getDataserverId();
       if(serverIdList == null || serverIdList.size() == 0) {
           throw new CommonException(StatusCodeEnum.UN_KNOWN_ERROR, "寻找可读块时出现错误");
       }
       int index = new Random().nextInt(serverIdList.size());
       int serverId = serverIdList.get(index);
       return ServerManager.getServerIp(serverId);
    }

   public static boolean tryWriteBlock(BlockInfo blockInfo) {
       if(blockInfo.getWritingBlockLock().get() == false) {
           return blockInfo.getWritingBlockLock().compareAndSet(false, true);
       }
       return false;
   }
    
    
}

    