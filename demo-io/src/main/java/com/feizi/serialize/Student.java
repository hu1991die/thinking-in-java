/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/1/3 11:20
 * @Package_name com.feizi.serialize
 */
public class Student implements Serializable{
    private String stuno;
    private String stuname;
    // 被transient关键字修饰过的属性不会被JVM默认的序列化
    private transient int stuage;

    public Student() {
    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    /**
     * @Desc 自己完成序列化操作
     * @Author feizi
     * @Date 2017/1/3 15:27
     * @param
     * @return
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        //把虚拟机JVM默认可以序列化的元素进行序列化操作
        s.defaultWriteObject();
        //自己完成某个元素的序列化
        s.writeInt(stuage);
    }

    /**
     * @Desc 自己完成反序列化操作
     * @Author feizi
     * @Date 2017/1/3 15:27
     * @param
     * @return
     */
    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        //把虚拟机默认可以反序列化的元素进行反序列化操作
        s.defaultReadObject();
        //自行完成某个元素的反序列化操作
        this.stuage = s.readInt();
    }
}
