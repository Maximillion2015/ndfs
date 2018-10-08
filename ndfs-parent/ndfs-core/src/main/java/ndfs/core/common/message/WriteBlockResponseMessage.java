

package ndfs.core.common.message;

public class WriteBlockResponseMessage extends ResponseMessage{

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.WRITE_BLOCK_RESPONSE.getCode();
    }
    
    public String getFilePath() {
        
        return filePath;
            
    }

    public void setFilePath(String filePath) {
        
        this.filePath = filePath;
            
    }

    public String getUuid() {
        
        return uuid;
            
    }

    public void setUuid(String uuid) {
        
        this.uuid = uuid;
            
    }

    private String filePath;
    
    private String uuid;
    

}

    