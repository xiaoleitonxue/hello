package demo11.demo4;

import demo11.demo3.servicereader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPs {
    public static void main(String[] args) throws IOException {

        System.out.println("服务器启动了");

        ServerSocket serverSocket = new ServerSocket(8080);

        ExecutorService pool = new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                 Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了:" +  socket.getInetAddress().getHostAddress());

            pool.submit(new servicereader(socket));
        }
    }
}
