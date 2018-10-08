
package ndfs.client.processor;

import io.netty.channel.ChannelHandlerContext;
import ndfs.client.netty.NettyClientBootstrap;
import ndfs.client.netty.NettyClientHandler;
import ndfs.core.annotation.Processor;
import ndfs.core.cache.exception.CommonException;
import ndfs.core.common.StatusCodeEnum;
import ndfs.core.common.message.MsgTypeEnum;
import ndfs.core.common.message.ObtainReadableServerResponseMessage;
import ndfs.core.common.message.ReadBlockRequestMessage;
import ndfs.core.common.message.RequestMessage;
import ndfs.core.common.message.WriteBlockRequestMessage;


@Processor(msgType = MsgTypeEnum.OBTAIN_READABLE_SERVER_RESPONSE)
public class ObtainReadableServerResponseProcessor
        extends ResponseMessageProcessor<ObtainReadableServerResponseMessage, RequestMessage> {

    @Override
    protected RequestMessage process(ChannelHandlerContext channelHandlerContext,
            ObtainReadableServerResponseMessage responseMessage) {

        String ip = responseMessage.getIp();
        long blockId = responseMessage.getBlockId();
        int fileId = responseMessage.getFileId();
        NettyClientBootstrap dataClient = new NettyClientBootstrap(ip, "9998", new NettyClientHandler(),
                "client 的 netty client 启动成功");

        ReadBlockRequestMessage message = new ReadBlockRequestMessage();
        message.setBlockId(blockId);
        message.setFileId(fileId);
        dataClient.getSocketChannel().writeAndFlush(message);
        try {
            dataClient.getSocketChannel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new CommonException(StatusCodeEnum.UN_KNOWN_ERROR, e.getMessage());
        }
        return RequestMessage.nullObject();

    }

}
