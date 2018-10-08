
package ndfs.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import ndfs.core.common.BootLoader;
import ndfs.core.common.message.CommonMessage;
import ndfs.core.utils.LogUtils;
import ndfs.core.utils.Logger;


public class NettyClientHandler extends SimpleChannelInboundHandler<CommonMessage> {

    private static final Logger logger = LogUtils.getLogger(NettyClientHandler.class);

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, CommonMessage message)
            throws Exception {
        BootLoader.getProcessor(message.getMsgType()).processMessage(channelHandlerContext, message);

        ReferenceCountUtil.release(message);
        channelHandlerContext.channel().close();
    }
}
