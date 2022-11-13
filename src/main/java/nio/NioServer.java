package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author ziyou.cxf
 * @version : NioServer.java, v 0.1 2022年06月02日 10:07 ziyou.cxf Exp $
 */
public class NioServer {

    private int port;

    private Selector selector;

    /**
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue
     */
    private final ExecutorService service = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

    public NioServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new NioServer(8080).start();
    }


    private void init() {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("NioServer started");
        } catch (IOException e) {

        } finally {

        }
    }

    public void start() {
        this.init();
        while (true) {
            try {
                int events = selector.select();
                if (events > 0) {
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while (selectionKeys.hasNext()) {
                        SelectionKey key = selectionKeys.next();
                        selectionKeys.remove();
                        if (key.isAcceptable()) {
                            accept(key);
                        } else if (key.isReadable()) {
                            service.submit(new NioServerHandler(key));
                        }
                    }
                }
            } catch (IOException e) {

            }
        }
    }

    public void accept(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel accept = ssc.accept();
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_READ);
            System.out.println("accept a client : " + ssc.socket().getInetAddress().getHostName());
        } catch (IOException e) {

        }
    }

    public static class NioServerHandler implements Runnable {

        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println("收到客户端" + socketChannel.socket().getInetAddress().getHostName());
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    socketChannel.write(outBuffer);
                    selectionKey.cancel();
                }
            } catch (IOException e) {

            }
        }
    }
}
