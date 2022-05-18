package com.daocheng.week03.work01And02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket，绑定一个8801端口
        ServerSocket serverSocket = new ServerSocket(8802);
        //多线程处理
        while (true){
            try {
                //有客户端请求，通过accept拿到 socket 然后进行处理
                final Socket socket = serverSocket.accept();
                //有请求创建一个新的线程，多线程处理
                new Thread(() ->{
                    server(socket);
                }).start();
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
