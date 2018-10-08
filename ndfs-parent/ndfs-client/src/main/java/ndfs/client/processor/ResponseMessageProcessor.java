
package ndfs.client.processor;

import io.netty.channel.ChannelHandlerContext;
import ndfs.core.annotation.Processor;
import ndfs.core.cache.exception.CommonException;
import ndfs.core.common.MessageProcessor;
import ndfs.core.common.StatusCodeEnum;
import ndfs.core.common.message.MsgTypeEnum;
import ndfs.core.common.message.RequestMessage;
import ndfs.core.common.message.ResponseMessage;
import ndfs.core.utils.LogUtils;
import ndfs.core.utils.Logger;

public abstract class ResponseMessageProcessor<S extends ResponseMessage, Q extends RequestMessage>
        implements MessageProcessor<S> {

    private static final Logger logger = LogUtils.getLogger(ResponseMessageProcessor.class);
    protected abstract Q process(ChannelHandlerContext channelHandlerContext, S responseMessage);

    @Override
    public void processMessage(ChannelHandlerContext channelHandlerContext, S responseMessage) {
        logger.info("收到 name server的消息，类型是[%s]，内容为[%s]", MsgTypeEnum.getMsgTypeEnumByCode(responseMessage.getMsgType()), responseMessage);
        Q requestMessage = process(channelHandlerContext, responseMessage);
        
        if(requestMessage != RequestMessage.nullObject()) {
            throw new CommonException(StatusCodeEnum.UN_KNOWN_ERROR);
        }

    }

}
