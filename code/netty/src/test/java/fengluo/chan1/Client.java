package fengluo.chan1;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.EnsuresKeyFor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Author: fengluo
 * @Date: 2022/7/31 13:35
 */
@Slf4j
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));
        System.out.println("waitting");
        System.out.println("test");
    }

}
