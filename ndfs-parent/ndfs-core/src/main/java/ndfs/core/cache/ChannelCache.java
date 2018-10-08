
package ndfs.core.cache;


import io.netty.channel.socket.SocketChannel;
import ndfs.core.utils.LogUtils;
import ndfs.core.utils.Logger;

public class ChannelCache {
    
    private static Logger logger = LogUtils.getLogger(ChannelCache.class);
    
    private static LocalCache<Integer, SocketChannel> channelCache;
    
    static {
        channelCache = CacheBuilder.newBuilder(CacheBuilder.GUAVA_CACHE_BUILDER_TYPE, Integer.class, SocketChannel.class)
                .build();
    }
    
    public static void addChannel(Integer channelId, SocketChannel socketChannel) {
        channelCache.put(channelId, socketChannel);
        logger.info("添加channelId [%s] 完成", channelId);
    }
    
    public static SocketChannel getChannel(Integer channelId) {
        return channelCache.get(channelId);
    }
    
    public static boolean removeSocketChannel(SocketChannel socketChannel) {
       if( channelCache.removeValue(socketChannel) == true ) {
           logger.info("移除channel 成功");
           return true;
       }
       return false;
    }

}
    