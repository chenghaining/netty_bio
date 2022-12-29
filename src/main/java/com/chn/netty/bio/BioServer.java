package com.chn.netty.bio;

import java.io.IOException;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BioServer {
    public static void main(String[] args) throws Exception{


         int[] as = new int[3];
        System.out.println(as.length);



//思路:
        //1、创建一个线程池
//        2.如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）

//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        //创建连接ServerSocket
//        ServerSocket serverSocket = new ServerSocket(6666);
//        System.out.println("服务端启动连接");
//
//
//        while(true){
//            //监听、接受客户端连接
//            final Socket socket = serverSocket.accept();
//            System.out.println("连接到一个客户端");
//
//            //创建一个线程，与之通讯
//            threadPool.execute(new Runnable() {
//                public void run() {
//
//                    //与客户端进行通讯
//                    handler(socket);
//                }
//            });
//        }
//
//    }
//
//    //  与客户端通讯的方法
//    public static void handler(Socket socket){
//        System.out.println("当前线程id:"+Thread.currentThread().getId()+" | "
//                +"当前线程名："+Thread.currentThread().getName());
//        // 读取客户端信息
//        try {
//            byte[] bytes = new byte[1024];
//            // 1、通过Socket获取输入流
//            InputStream read = socket.getInputStream();
//            while (true){
//                int len ;
//                if ((len = read.read(bytes))!=-1){
//                    System.out.println("当前线程id:"+Thread.currentThread().getId()+" | "
//                            +"当前线程名："+Thread.currentThread().getName());
//                    //输出客户端信息
//                    System.out.println(new String(bytes,0,len));
//                }else {
//                    System.out.println(Thread.currentThread().getName()+"结束了");
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    }
}
