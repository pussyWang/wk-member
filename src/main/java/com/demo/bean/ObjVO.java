package com.demo.bean;

/**
 * Created by wangkang04 on 2018/8/16
 **/
public class ObjVO {
    private int age;

    private short num;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public short getNum() {
        return num;
    }

    public void setNum(short num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "[" + age + "," + num + "," + name +"]";
//    }
    public String show(){
        return "[" + age + "," + num + "," + name +"]";
    }
}
