

package ndfs.core.common.message;

public class ObtainReadableServerRequestMessage extends RequestMessage{
    public long getBlockId() {
    
        return blockId;
    }

    public void setBlockId(long blockId) {
    
        this.blockId = blockId;
    }

    @Override
    protected void initialize() {
        super.initialize();
        this.msgType = MsgTypeEnum.OBTAIN_READABLE_SERVER_REQUEST.getCode();
    }
    
    public long blockId;
    
    public int fileId;

    public int getFileId() {
    
        return fileId;
    }

    public void setFileId(int fileId) {
    
        this.fileId = fileId;
    }
    
}

    