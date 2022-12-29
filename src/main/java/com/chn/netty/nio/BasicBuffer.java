package com.chn.netty.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {

//      buffer的简单说明

//      创建一个buffer，大小为5，可以储存5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
//          储存数据
            intBuffer.put(i * 2);
        }

        //读写转换
        intBuffer.flip();

        //读出buffer中的数据
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }

}
