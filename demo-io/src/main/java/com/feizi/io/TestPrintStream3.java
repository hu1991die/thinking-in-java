/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.*;
import java.util.Date;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/16 16:36
 * @Package_name com.feizi.io
 */
public class TestPrintStream3 {
    public static void main(String[] args) {
        String s = null;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        try {
            FileWriter fw = new FileWriter("F:\\javaio\\feizi\\hello.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            while ((s = br.readLine()) != null){
                if("exit".equalsIgnoreCase(s)){
                    break;
                }
                System.out.println(s.toUpperCase());
                pw.println("-------------");
                pw.println(s.toUpperCase());
                pw.flush();
            }
            pw.println("====" + new Date() + "====");

            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
