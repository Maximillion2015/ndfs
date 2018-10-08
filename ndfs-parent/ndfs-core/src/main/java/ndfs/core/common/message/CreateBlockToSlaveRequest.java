

package ndfs.core.common.message;


public class CreateBlockToSlaveRequest extends RequestMessage {
    private long blockCount;

    private long blockNumberMin;
    
    private long sessionId;

    public long getBlockCount() {
    
        return blockCount;
    }

    public void setBlockCount(long blockCount) {
    
        this.blockCount = blockCount;
    }

    public long getBlockNumberMin() {
    
        return blockNumberMin;
    }

    public void setBlockNumberMin(long blockNumberMin) {
    
        this.blockNumberMin = blockNumberMin;
    }

    public CreateBlockToSlaveRequest(long blockCount, long blockNumberMin, long sessionId) {
        super();
        this.blockCount = blockCount;
        this.blockNumberMin = blockNumberMin;
        this.sessionId = sessionId;
    }

    public long getSessionId() {
        
        return sessionId;
            
    }

    public void setSessionId(long sessionId) {
        
        this.sessionId = sessionId;
            
    }
}
