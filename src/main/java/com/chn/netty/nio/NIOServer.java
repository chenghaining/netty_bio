package com.chn.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws Exception {

//      服务端创建ServerSocketChannel得到SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

//       创建一个selector类
        Selector selector = Selector.open();

//      绑定一个端口，在服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

//      设置成非阻塞
        serverSocketChannel.configureBlocking(false);

//      将ServerSocketChannel注册到Selector中，连接事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while(true){
            //等待1秒，无连接跳过本次循环
            if (selector.select(1000)==0){
                System.out.println("服务器等待1秒，无连接");
                continue;
            }
            //有连接产生,获取相关事件的集合selectionKeys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //使用迭代器遍历集合
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发生的事件做相应的处理
                if (key.isAcceptable()){//如果是OP_ACCEPT，有新的客户端连接事件
                    //给该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将送socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector上,关注事件为OP_READ，同时给socketChannel关联一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()){//如果发生的事件是OP_READ
                    //通过key反向获取到对应的channel（因为key已经注册过，所以通过key获取到的channel不需要再注册）
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    //获取到该channel相关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    //写入channel中
                    socketChannel.read(buffer);
                    System.out.println("from 客户端"+new String(buffer.array()));
                }
                //手动从集合中移除当前的selectionkey,防止重复操作
                keyIterator.remove();
            }
        }
    }

}
