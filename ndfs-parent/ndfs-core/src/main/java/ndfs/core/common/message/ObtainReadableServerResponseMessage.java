

package ndfs.core.common.message;


public class ObtainReadableServerResponseMessage extends ResponseMessage {

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.OBTAIN_READABLE_SERVER_RESPONSE.getCode();
    }

    public String getIp() {

        return ip;

    }

    public void setIp(String ip) {

        this.ip = ip;

    }

    public int getFileId() {
        
        return fileId;
            
    }

    public void setFileId(int fileId) {
        
        this.fileId = fileId;
            
    }

    public long getBlockId() {
        
        return blockId;
            
    }

    public void setBlockId(long blockId) {
        
        this.blockId = blockId;
            
    }

    private String ip;
    
    private int fileId;
    
    private long blockId;

}
