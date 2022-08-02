package fengluo.netty.c1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: fengluo
 * @Date: 2022/7/31 17:36
 */
public class HelloClient {

    public static void main(String[] args) throws InterruptedException {
        // 1.启动类
        new Bootstrap()
            // 2.添加 EventLoop
            .group(new NioEventLoopGroup())
            // 3.选择客户端的 channel 实现
            .channel(NioSocketChannel.class)
            // 4.添加处理器
            .handler(new ChannelInitializer<NioSocketChannel>() {
                @Override // 5.连接建立后被调用
                protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                    nioSocketChannel.pipeline().addLast(new StringEncoder());
                }
            })
            // 5.连接到服务器
            .connect("localhost", 8080) // 异步非阻塞
            .sync()
            .channel()
            // 向服务器发送数据
            .writeAndFlush("hello, World");
    }

}
// 接口可以继承接口，多继承
// 实体类可以实现接口，多实现
