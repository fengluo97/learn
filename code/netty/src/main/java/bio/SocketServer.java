package bio;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: fengluo
 * @Date: 2022/7/29 19:50
 */
public class SocketServer {

    public static void connect() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                System.out.println("等待客户端连接");
                Socket clientSocket = serverSocket.accept();
                System.out.println("已拿到客户端连接");
                handle(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handle(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        int read = clientSocket.getInputStream().read(bytes);
        if (read != -1) {
            System.out.println("接收到来自客户端的数据" + new String(bytes, 0, read));
        }
    }

    public static void main(String[] args) {
        connect();
    }

}
