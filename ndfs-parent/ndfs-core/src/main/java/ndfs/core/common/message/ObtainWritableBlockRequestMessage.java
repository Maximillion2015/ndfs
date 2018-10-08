

package ndfs.core.common.message;


public class ObtainWritableBlockRequestMessage extends RequestMessage {

    public ObtainWritableBlockRequestMessage(String path, String uuid) {
        super();
        this.path = path;
        this.uuid = uuid;
    }

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.OBTAIN_WRITABLE_BLOCK_REQUEST.getCode();
    }

    public String getPath() {

        return path;

    }

    public void setPath(String path) {

        this.path = path;

    }

    public String getUuid() {
        
        return uuid;
            
    }

    public void setUuid(String uuid) {
        
        this.uuid = uuid;
            
    }

    private String path;
    
    private String uuid;

}
