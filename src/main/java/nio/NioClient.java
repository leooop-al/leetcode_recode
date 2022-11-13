package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author ziyou.cxf
 * @version : NioClient.java, v 0.1 2022年06月02日 10:35 ziyou.cxf Exp $
 */
public class NioClient {

    private static final String host = "127.0.0.1";

    private static final int port = 8080;

    private Selector selector;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                NioClient nioClient = new NioClient();
                nioClient.connect(host, port);
                nioClient.listen();
            }).start();
        }
    }

    public void connect(String host, int port) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            this.selector = Selector.open();
            sc.register(selector, SelectionKey.OP_CONNECT);
            sc.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {

        }
    }

    public void listen() {
        while (true) {
            try {
                int events = selector.select();
                if (events > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if (selectionKey.isConnectable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if (socketChannel.isConnectionPending()) {
                                socketChannel.finishConnect();
                            }
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            socketChannel.write(ByteBuffer.wrap("hello".getBytes()));
                        } else if (selectionKey.isReadable()) {
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            ByteBuffer allocate = ByteBuffer.allocate(1024);
                            channel.read(allocate);
                            allocate.flip();
                            System.out.println("收到服务端的数据：" + new String(allocate.array()));
                        }
                    }
                }
            } catch (IOException e) {

            }
        }
    }
}
