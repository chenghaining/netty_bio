package com.chn.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel03 {
    public static void main(String[] args) throws Exception{

//      创建一个输入流并拿到FileChannel
        FileInputStream fileInputStream = new FileInputStream("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file01.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

//      创建输出流并拿到FileChannel
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\netty\\netty_bio\\src\\main\\java\\com\\chn\\netty\\nio\\file02.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

//      创建一个读写复用的Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

//      读取文件并写入另一个文件
        while(true){
            //重置buffer的标识，防止read==0
            byteBuffer.clear();
            //读取文件中的数据
            int read = fileChannel01.read(byteBuffer);
            if (read==-1){
                break;
            }
            //注意读写反转
            byteBuffer.flip();
            //将buffer中的数据写入新文件
            fileChannel02.write(byteBuffer);
        }
        //关闭资源
        fileInputStream.close();
        fileOutputStream.close();

    }

}
