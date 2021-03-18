package com.cn.wrapper;

/**
 * @description:
 * @author: helisen
 * @create: 2021-03-18 18:23
 **/
public class MyClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void say(String msg) {
        System.out.println("this is say " + msg);
    }

    public String myMsg(String message) {
        return message;
    }
}
