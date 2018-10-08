

package ndfs.nameserver.event;

public enum EventType {
    CREATE_BLOCK(1, "创建块");
    
    private int code;
    private String desc;
    private EventType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
}

    