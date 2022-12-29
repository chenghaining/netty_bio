package com.chn.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NioFileChannel04 {
    public static void main(String[] args) throws Exception{

//      创建相关流
        FileInputStream fileInputStream = new FileInputStream("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file01.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file03.txt");

//      获取对应通道FileChannel
        FileChannel sourcech = fileInputStream.getChannel();
        FileChannel destch = fileOutputStream.getChannel();

        //使用transferFrom/transferTo完成拷贝
        destch.transferFrom(sourcech,0,sourcech.size());
//        sourcech.transferTo(0,sourcech.size(),destch);

        sourcech.close();
        destch.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
