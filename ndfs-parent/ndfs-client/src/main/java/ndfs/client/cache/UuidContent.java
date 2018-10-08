

package ndfs.client.cache;

import java.util.concurrent.ConcurrentHashMap;

public class UuidContent extends ConcurrentHashMap<String, String>{
    private static final UuidContent INSTANCE = new UuidContent();
    public static UuidContent getInstance() {return INSTANCE;}
}

    