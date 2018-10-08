

package ndfs.core.common.message;

public class HeartRequestMessage extends RequestMessage{

    private static final long serialVersionUID = 1L;

    // 可分配空间
    private long FreeBlockCount;
    
    public HeartRequestMessage() {
        this.msgType = MsgTypeEnum.HEARTBEAT_REQUST.getCode();
    }

    public long getFreeBlockCount() {
        
        return FreeBlockCount;
            
    }

    public void setFreeBlockCount(long freeBlockCount) {
        
        FreeBlockCount = freeBlockCount;
            
    }
    
  

    
}

    