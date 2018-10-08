

package ndfs.core.common.message;


public class ObtainWritableBlockResponseMessage extends ResponseMessage {

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.OBTAIN_WRITABLE_BLOCK_RESPONSE.getCode();
    }
    
    public long getBlockId() {
        
        return blockId;
            
    }

    public void setBlockId(long blockId) {
        
        this.blockId = blockId;
            
    }

    public String getServerIp() {
        
        return serverIp;
            
    }

    public void setServerIp(String serverIp) {
        
        this.serverIp = serverIp;
            
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


    private long blockId;
    
    private String serverIp;
    
    private String path;
    
    private String uuid;

}
