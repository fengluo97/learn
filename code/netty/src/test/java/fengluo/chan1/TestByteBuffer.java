package fengluo.chan1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @Author: fengluo
 * @Date: 2022/7/31 8:51
 */
@Slf4j
public class TestByteBuffer {

    public static void main(String[] args) {
        // FileChannel
        // 1.输入输出流 2.RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 从 channel 读取数据，向 buffer 写入
                int read = channel.read(buffer);
                log.debug("读取到的字节数：" + read);
                if (read == -1) {
                    break;
                }
                // 打印 buffer 的内容
                buffer.flip(); // 切换至读模式
                while (buffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte b = buffer.get();
                    log.debug("实际字节{}", (char) b);
                }
                buffer.clear();
            }
        } catch (IOException e) {

        };
    }

}
