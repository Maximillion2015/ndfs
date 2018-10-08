

package ndfs.dataserver;

import ndfs.core.cache.CacheBuilder;
import ndfs.core.cache.LocalCache;
import ndfs.dataserver.model.BlockInfo;
import ndfs.dataserver.model.FileInfo;


public class FileCache {
    public static final LocalCache<String, FileInfo> INSTANCE = getInstance();

    private static LocalCache<String, FileInfo> getInstance() {
        return CacheBuilder.newBuilder(CacheBuilder.DEFAULT_CACHE_BUILDER_TYPE, String.class, FileInfo.class)
                .initialCapacity(800).build();
    }

    public static void addFileInfo(long blockId,  int fileId, long offset, long length) {
        INSTANCE.put(blockId + "|" + fileId, new FileInfo(fileId, offset, length));
    }
    
    public static FileInfo getFileInfo(long blockId,  int fileId) {
        return INSTANCE.get(blockId + "|" + fileId);
    }
}


