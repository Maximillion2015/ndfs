

package ndfs.core.common.message;

import ndfs.core.utils.LogUtils;


public class ReadBlockRequestMessage extends RequestMessage{
    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.READ_BLOCK_REQUEST.getCode();
    }
    
    public long getBlockId() {
        
        return blockId;
            
    }

    public void setBlockId(long blockId) {
        
        this.blockId = blockId;
            
    }

    public int getFileId() {
        
        return fileId;
            
    }

    public void setFileId(int fileId) {
        
        this.fileId = fileId;
            
    }

    
    
    private long blockId;
    
    private int fileId;
}

    