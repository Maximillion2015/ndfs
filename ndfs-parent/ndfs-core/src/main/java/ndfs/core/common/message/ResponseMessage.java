

package ndfs.core.common.message;

public abstract class ResponseMessage extends CommonMessage{

    
    private static final ResponseMessage NULL_RESPONSE_MESSAGE = new NullResponseMessage();
    
    public static ResponseMessage nullMessage() {return NULL_RESPONSE_MESSAGE;}
    
    static class NullResponseMessage extends ResponseMessage{
        @Override
        protected void initialize() {}
    }

}

    