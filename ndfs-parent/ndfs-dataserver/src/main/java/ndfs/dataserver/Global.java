

package ndfs.dataserver;

import ndfs.core.common.BootLoader;


public class Global {
    private static final String keyForDataserverId = "dataserver.id";
    
    public static volatile long freeBlockCount = 0;
    public static final int PORT = Integer.valueOf(BootLoader.getProperties(keyForDataserverId));
}

    