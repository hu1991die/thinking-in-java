/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.*;

/**
 * @Desc BufferedReader和PrintWriter
 * @Author feizi
 * @Date 2017/1/3 10:57
 * @Package_name com.feizi.stream
 */
public class BrAndPwDemo {

    public static void main(String[] args) throws IOException{
        String fileName1 = "F:\\javaio\\feizi\\stream.txt";
        String fileName2 = "F:\\javaio\\feizi\\stream6.txt";

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName1)));

        PrintWriter pw = new PrintWriter(fileName2);

        String line;
        while ((line = br.readLine()) != null){
            pw.println(line);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
