

package ndfs.nameserver.processor;

import io.netty.channel.ChannelHandlerContext;
import ndfs.core.annotation.Processor;
import ndfs.core.common.message.MsgTypeEnum;
import ndfs.core.common.message.ObtainWritableBlockRequestMessage;
import ndfs.core.common.message.ObtainWritableBlockResponseMessage;
import ndfs.nameserver.cache.BlockManager;
import ndfs.nameserver.cache.ServerManager;
import ndfs.nameserver.core.BlockInfo;


@Processor(msgType = MsgTypeEnum.OBTAIN_WRITABLE_BLOCK_REQUEST)
public class ObtainWritableBlockRequestProcessor
        extends RequestMessageProcessor<ObtainWritableBlockRequestMessage, ObtainWritableBlockResponseMessage> {

    @Override
    protected ObtainWritableBlockResponseMessage process(ChannelHandlerContext channelHandlerContext,
            ObtainWritableBlockRequestMessage requestMessage) {
        ObtainWritableBlockResponseMessage message = new ObtainWritableBlockResponseMessage();
        BlockInfo blockInfo = BlockManager.findWritableBlock();
        long blockId = blockInfo.getId();
        int serverId = blockInfo.getMasterServerId();
        message.setBlockId(blockId);
        message.setServerIp(ServerManager.getServerIp(serverId));
        message.setPath(requestMessage.getPath());
        message.setUuid(requestMessage.getUuid());
        return message;
    }

}
