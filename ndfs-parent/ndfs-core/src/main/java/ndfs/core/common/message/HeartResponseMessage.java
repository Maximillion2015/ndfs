

package ndfs.core.common.message;

public class HeartResponseMessage extends ResponseMessage{

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.HEARTBEAT_RESPONSE.getCode();
    }
    
    public OperationType getOperationType() {
        
        return operationType;
            
    }

    public void setOperationType(OperationType operationType) {
        
        this.operationType = operationType;
            
    }

    public long getBlockNumberMin() {
        
        return blockNumberMin;
            
    }

    public void setBlockNumberMin(long blockNumberMin) {
        
        this.blockNumberMin = blockNumberMin;
            
    }

    public long getBlockSize() {
        
        return blockSize;
            
    }

    public void setBlockSize(long blockSize) {
        
        this.blockSize = blockSize;
            
    }

    public Long getBlockNumberMax() {
        
        return blockNumberMax;
            
    }

    public void setBlockNumberMax(long blockNumberMax) {
        
        this.blockNumberMax = blockNumberMax;
            
    }

    private OperationType operationType;
    
    private long blockSize;
    
    private long blockNumberMin;
    
    private long blockNumberMax;
    
    
    public static enum OperationType {
        NULL,
        CREATE_BLOCK;
    }
    

}

    