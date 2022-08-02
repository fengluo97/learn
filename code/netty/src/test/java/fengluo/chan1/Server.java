package fengluo.chan1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: fengluo
 * @Date: 2022/7/31 13:27
 */
@Slf4j
public class Server {

    public static void main(String[] args) throws IOException {
        // 1.创建 selector, 管理多个 channel
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        // 2.建立 selector 和 channel 之间的联系（注册）
        // SelectionsKey 就是将来事件发生后，通过它可以知道事件和是哪个channel的事件
        SelectionKey sscKey = ssc.register(selector, 0, null);
        sscKey.interestOps(SelectionKey.OP_ACCEPT); // 绑定key 的事件类型
        log.debug("registerKey {}", sscKey);

        ssc.bind(new InetSocketAddress(8080));
        while (true) {
            // 3.select 方法, 没有事件发生，线程阻塞，有事件发生，线程才会恢复运行
            selector.select();
            // 4.处理事件, selectedKeys 内部包含了所有发生的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 处理完 key 的时候，要从 selectKeys集合中删除，否则下次处理就会有问题
                iterator.remove();
                log.debug("key {}", key);
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    ByteBuffer buffer = ByteBuffer.allocate(16);
                    // 将 bytebuffer 作为附件关联到 selectKey
                    SelectionKey scKey = sc.register(selector, 0, buffer);
                    scKey.interestOps(SelectionKey.OP_READ);
                    log.debug("{}", sc);
                } else if (key.isReadable()) {
                    try {
                        SocketChannel channel = (SocketChannel) key.channel(); // 拿到触发事件的 channel
                        // 获取 selectionKey 上关联的附件
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        int read = channel.read(buffer);
                        if (read == -1) {
                            key.cancel();
                        } else {
                            buffer.flip();
                            System.out.println(Charset.defaultCharset().decode(buffer));
                            //buffer.clear();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        key.cancel(); // 因为客户端断开了，key 还没有被处理
                    }
                }


            }
        }
    }

}
