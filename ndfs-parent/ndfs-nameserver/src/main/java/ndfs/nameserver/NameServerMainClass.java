

package ndfs.nameserver;

import static ndfs.core.common.BootLoader.getProperties;

import ndfs.core.common.BootLoader;
import ndfs.core.common.NettyServerBootstrap;
import ndfs.core.utils.LogUtils;
import ndfs.core.utils.Logger;
import ndfs.nameserver.service.BlockScanService;


public class NameServerMainClass {
    private static final Logger logger = LogUtils.getLogger(BootLoader.class);

    private static final String keyForProcessorPackage = "processor.package";
    
    private static final String keyForNameserverPort = "nameserver.port";


    public static void main(String[] args) {
        startServer();
        BlockScanService.service();
    }
    
    private static void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NettyServerBootstrap dataServer = new NettyServerBootstrap(getProperties(keyForNameserverPort),
                        new NettyServerHandler(), "name server的 netty server启动成功");
            }
        }).start();
    }

  
}
