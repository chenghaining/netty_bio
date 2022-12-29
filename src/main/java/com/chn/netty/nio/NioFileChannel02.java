package com.chn.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel02 {
    public static void main(String[] args) throws Exception{

        File file = new File("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file01.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        //获取FileChannel
        FileChannel fileChannel = fileInputStream.getChannel();

//      创建一个Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

//      将通道中字节数据读到byteBuffer中
        fileChannel.read(byteBuffer);

//       将字节转字符串输出
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();




    }

}
