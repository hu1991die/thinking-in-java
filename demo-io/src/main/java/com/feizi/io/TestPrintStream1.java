/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/16 16:04
 * @Package_name com.feizi.io
 */
public class TestPrintStream1 {
    public static void main(String[] args) {
        PrintStream ps = null;

        try {
            FileOutputStream fos = new FileOutputStream("F:\\javaio\\feizi\\hello.txt");
            ps = new PrintStream(fos);

            if(ps != null){
                System.setOut(ps);
            }

            int ln = 0;
            for (char c = 0; c <= 60000; c++){
                System.out.print(c + " ");
                if(ln++ >= 100){
                    System.out.println();
                    ln = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
