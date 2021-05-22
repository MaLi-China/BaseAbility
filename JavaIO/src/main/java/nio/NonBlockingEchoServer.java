package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 功能说明：非阻塞的Echo Server端
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/22
 */
public class NonBlockingEchoServer {
    public static void main(String[] args) {
        Selector selector = null;
        try {
            //创建ServerChannel
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            //绑定端口
            serverChannel.bind(new InetSocketAddress(8888));
            //配合为非阻塞
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            //注册ServerChannel
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                //阻塞等待连接
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                //可连接事件: 代表收到一个连接请求
                if (key.isAcceptable()) {
                    try {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("接收到客户端请求: " + client.getRemoteAddress());
                        //设置非阻塞
                        client.configureBlocking(false);
                        //注册到Selector
                        SelectionKey clientKey = client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        //分配缓存区域
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        clientKey.attach(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //可读事件
                if (key.isReadable()) {
                    try {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                        //输出接收
                        System.out.println(client.getRemoteAddress() + "-->NonBlockingEchoServer: " + output.toString());
                        //?
                        key.interestOps(SelectionKey.OP_WRITE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //可写事件
                if (key.isWritable()) {
                    try {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output);
                        System.out.println(client.getRemoteAddress() + "-->NonBlockingEchoServer: " + output.toString());
                        output.compact();
                        key.interestOps(SelectionKey.OP_READ);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
