/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.file;


import com.feizi.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Desc 目录实用工具
 * @Author feizi
 * @Date 2016/12/29 18:35
 * @Package_name com.feizi.file
 */
public final class Directory {
    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static TreeInfo walk(String start){
        return TreeInfo.walk(start);
    }

    public static TreeInfo walk(String start, String regex){
        return TreeInfo.walk(start, regex);
    }

    public static TreeInfo walk(File start){
        return TreeInfo.walk(start);
    }

    public static TreeInfo walk(File start, String regex){
        return TreeInfo.walk(start, regex);
    }

    public static File[] local(String path, final String regex){
        return local(new File(path), regex);
    }

    // A two-tuple for returning a pair of objects
    public static class TreeInfo implements Iterator<File>{

        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        //The default iterable element is the file list
        public Iterator<File> iterator(){
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles:" + PPrint.pformat(files);
        }

        public static TreeInfo walk(String start, String regex){
            return recurseDirs(new File(start), regex);
        }

        public static TreeInfo walk(File start, String regex){
            return recurseDirs(start, regex);
        }

        public static TreeInfo walk(File start){
            return recurseDirs(start, ".*");
        }

        public static TreeInfo walk(String start){
            return recurseDirs(new File(start), ".*");
        }

        static TreeInfo recurseDirs(File startDir, String regex){
            TreeInfo result = new TreeInfo();
            for (File item : startDir.listFiles()){
                if(item.isDirectory()){
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item, regex));
                }else{
                    // Regular file
                    if(item.getName().matches(regex)){
                        result.files.add(item);
                    }
                }
            }
            return result;
        }

        public boolean hasNext() {
            return false;
        }

        public File next() {
            return null;
        }

        public void remove() {

        }

        public static void main(String[] args) {
            if(args.length == 0){
                System.out.println(walk("."));
            }else{
                for (String arg : args){
                    System.out.println(walk(arg));
                }
            }
        }
    }
}
