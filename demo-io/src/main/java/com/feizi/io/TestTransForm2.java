/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Desc 读写转换流
 * @Author feizi
 * @Date 2017/2/16 13:55
 * @Package_name com.feizi.io
 */
public class TestTransForm2 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
//            s = br.readLine();
            while ((s = br.readLine()) != null){
                if("exit".equalsIgnoreCase(s)){
                    break;
                }
                System.out.println(s.toUpperCase());
//                s = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
