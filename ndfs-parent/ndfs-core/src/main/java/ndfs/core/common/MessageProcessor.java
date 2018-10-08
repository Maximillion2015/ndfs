

package ndfs.core.common;

import io.netty.channel.ChannelHandlerContext;
import ndfs.core.common.message.CommonMessage;


public interface MessageProcessor<S extends CommonMessage> {
    public void processMessage(ChannelHandlerContext channelHandlerContext, S message);
}

    