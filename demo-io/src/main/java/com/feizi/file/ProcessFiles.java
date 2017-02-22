/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.file;

import java.io.File;
import java.io.IOException;

/**
 * @Desc 策略模式处理文件
 * @Author feizi
 * @Date 2016/12/29 19:45
 * @Package_name com.feizi.file
 */
public class ProcessFiles {

    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext){
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){
        if(args.length == 0){

        }else{

        }
    }

    public void processDirectoryTree(File root) throws IOException{
        /*for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)){

        }*/
    }
}
