package com.chn.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel01 {
    public static void main(String[] args) throws Exception{

//     创建一个字符串
        String str = "hello,尚硅谷";

//     创建一个输出流——>获取通道chnnel
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file01.txt");
        //通过fileOutputStream获取对应的FileChannel
        //这个fileChannel真实类型是fileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将字符串以字节的形式放入byteBuffer中
        byteBuffer.put(str.getBytes());

        //buffer读写反转
        byteBuffer.flip();

        //将byteBuffer写入通道fileChannel中
        fileChannel.write(byteBuffer);

        fileOutputStream.close();

    }



}
