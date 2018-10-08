

package ndfs.core.common.message;

public class LoginResponseMessage extends ResponseMessage{

    @Override
    protected void initialize() {
        this.msgType = MsgTypeEnum.LOGIN_RESPONSE.getCode();
    }
    
}

    