package com.daocheng.week03.work01And02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
        //创建一个ServerSocket，绑定一个8801端口
        ServerSocket serverSocket = new ServerSocket(8803);
        //创建线程池多线程运行
        while (true){
            try {
                //有客户端请求，通过accept拿到 socket 然后进行处理
                final Socket socket = serverSocket.accept();
                //提交给之前创建的线程池来处理
                executorService.execute(() -> server(socket));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void server(Socket socket){
        //模拟输出 HTTP 报文头和 hello
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,noi1";
            printWriter.println("Content-Length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            //关闭 socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
