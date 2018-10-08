

package ndfs.core.common.message;

import ndfs.core.utils.LogUtils;


public class WriteBlockRequestMessage extends RequestMessage {
    private byte[] fileContent;

    private long blockId;

    public void setFileContent(byte[] fileContent) {

        this.fileContent = fileContent;
    }

    public byte[] getFileContent() {

        return fileContent;
    }

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.WRITE_BLOCK_REQUEST.getCode();
    }

    public long getBlockId() {

        return blockId;

    }


    public String toString() {
        return "WriteBlockRequestMessage[blockId=" + blockId + "]";
    }

    public void setBlockId(long blockId) {

        this.blockId = blockId;

    }
    
    public String getUuid() {
        
        return uuid;
            
    }

    public void setUuid(String uuid) {
        
        this.uuid = uuid;
            
    }

    private String uuid;
}
