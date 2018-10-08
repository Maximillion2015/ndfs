

package ndfs.dataserver.processor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import ndfs.core.cache.ChannelCache;
import ndfs.core.common.MessageProcessor;
import ndfs.core.common.message.MsgTypeEnum;
import ndfs.core.common.message.RequestMessage;
import ndfs.core.common.message.ResponseMessage;
import ndfs.core.utils.LogUtils;
import ndfs.core.utils.Logger;


public abstract class RequestMessageProcessor<Q extends RequestMessage, S extends ResponseMessage>
        implements MessageProcessor<Q> {
    
    private static final Logger logger = LogUtils.getLogger(RequestMessageProcessor.class);

    @Override
    public void processMessage(ChannelHandlerContext channelHandlerContext, Q message) {
        logger.info("发送给 data server的消息，类型是[%s]，内容为[%s]", MsgTypeEnum.getMsgTypeEnumByCode(message.getMsgType()), message);
        S responseMessage = process(channelHandlerContext, message);
        if(responseMessage == ResponseMessage.nullMessage()) return;
        SocketChannel socketChannel = null;
        if((socketChannel = ChannelCache.getChannel(message.getChannelId())) == null) {
            socketChannel = (SocketChannel) channelHandlerContext.channel();
        }
        socketChannel.writeAndFlush(responseMessage);
        logger.info("data server返回的消息，类型是[%s]，内容为[%s]", MsgTypeEnum.getMsgTypeEnumByCode(responseMessage.getMsgType()), responseMessage);

    }

    protected abstract S process(ChannelHandlerContext channelHandlerContext, Q requestMessage);

}
