

package ndfs.dataserver;


import ndfs.core.cache.CacheBuilder;
import ndfs.core.cache.LocalCache;
import ndfs.dataserver.model.BlockInfo;


public class UsedBlockInfoCache {
    
    public static final LocalCache<Long, BlockInfo> INSTANCE = getInstance();
    
    private static LocalCache<Long, BlockInfo> getInstance() {
        return CacheBuilder.newBuilder
                (CacheBuilder.GUAVA_CACHE_BUILDER_TYPE, Long.class, BlockInfo.class)
                .initialCapacity(800).build();
    }
    
    public boolean isEmpty() {
        return INSTANCE.size() == 0;
    }
    
    public static void addBlockInfo(BlockInfo blockInfo) {
        INSTANCE.put(blockInfo.getId(), blockInfo);
    }
    
    public static BlockInfo getBlockInfo(long blockId) {
        return INSTANCE.get(blockId);
    }
    


}

    