/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import org.w3c.dom.ls.LSException;

import java.io.*;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/16 16:24
 * @Package_name com.feizi.io
 */
public class TestPrintStream2 {
    public static void main(String[] args) {
        String filename = args[0];
        if(filename != null){
            list(filename, System.out);
        }
    }

    public static void list(String f, PrintStream ps){
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            String s = null;
            while ((s = br.readLine()) != null){
                ps.println(s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            ps.println("无法读取文件...");
        }
    }
}
