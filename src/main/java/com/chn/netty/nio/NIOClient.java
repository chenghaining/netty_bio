package com.chn.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
@SuppressWarnings({"all"})
public class NIOClient {

    public static void main(String[] args) throws Exception{
        //   得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();

//        设置非阻塞
        socketChannel.configureBlocking(false);

        //提供服务端的IP和端口
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6666);

        //连接服务器
        if (!socketChannel.connect(socketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("客户端不不会阻塞在，在连接的过程中可以做其他工作..");
            }
        }
        //连接成功，发送数据
        String str = "hello everyone";
        //创建buffer，数据放入buffer一步到位，使用wrap（）方法
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());

        socketChannel.write(byteBuffer);
        System.in.read();


    }

}
