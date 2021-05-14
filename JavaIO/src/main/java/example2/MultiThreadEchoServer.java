package example2;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明：使用NIO的多线程EchoServer
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/13
 */
public class MultiThreadEchoServer {
    private Selector selector;
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private static Map<Socket, Long> time_state = new HashMap<>(10240);

    private void startServer() throws Exception {
        //获取Selector对象
        selector = SelectorProvider.provider().openSelector();

        //获取表示服务端的channel对象
        ServerSocketChannel server = ServerSocketChannel.open();
        //设置为非阻塞模式
        server.configureBlocking(false);
        //对channel进行端口绑定
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8000);
        server.socket().bind(address);

        // 注册channel到selector
        SelectionKey acceptKey = server.register(selector, SelectionKey.OP_ACCEPT);

        //分发网络消息
        for (; ; ) {
            //阻塞方法
            int select = selector.select();//没有数据准备好:等待; 有数据可读: 返回已经准备就绪的SelectionKey的数量;
            // 获取准备好的SelecttionKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //移除掉SelectionKey, 否则会处理相同的SelectionKey
                iterator.remove();

                if (selectionKey.isAcceptable()) {
                    //进行客户端接收
                    doAccept(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    //channel是否已经可读
                    doRead(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isWritable()) {
                    //channel是否已经可写
                    doWrite(selectionKey);
                }
            }
        }
    }

    private void doWrite(SelectionKey selectionKey) {

    }

    private void doRead(SelectionKey selectionKey) {
    }

    private void doAccept(SelectionKey selectionKey) {
        selectionKey.channel();

    }
}
