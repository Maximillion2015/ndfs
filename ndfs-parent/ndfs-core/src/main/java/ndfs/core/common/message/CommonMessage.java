
package ndfs.core.common.message;

import java.io.Serializable;

public abstract class CommonMessage implements Serializable{
        
    protected static final long serialVersionUID = 2243859217859238868L;

    protected int msgType;

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
    
    // 所有子类都应该继承该方法
    protected abstract void initialize();
    
    public CommonMessage() {
        initialize();
    }
}

    