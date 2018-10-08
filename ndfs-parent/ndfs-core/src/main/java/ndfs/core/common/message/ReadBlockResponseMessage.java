

package ndfs.core.common.message;

import ndfs.core.utils.LogUtils;


public class ReadBlockResponseMessage extends ResponseMessage {

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.READ_BLOCK_RESPONSE.getCode();
    }
    
    public byte[] getContent() {
        
        return content;
            
    }

    public void setContent(byte[] content) {
        
        this.content = content;
            
    }

    private byte[] content;
    

    public String toString() {
        return "ReadBlockRequestMessage[msgType=" + msgType;
    }

}
