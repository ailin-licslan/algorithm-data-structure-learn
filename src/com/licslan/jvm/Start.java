package com.licslan.jvm;

/**
 * @author LICSLAN
 * https://www.processon.com/view/link/5fbbc7dae0b34d59cf8641c7
 */
public class Start {

    public static int test = 100;
    public static void main(String[] args) {
        People p = new People();
        p.say();
    }
}

/**
 * Java一共有8种基本数据类型：
 * 1、int占4字节，取值范围为“-2147483648~2147483647”；
 * 2、short占2字节，取值范围为“-32768~32767”；
 * 3、long占8字节；
 * 4、byte占1字节，取值范围为“-128~127”；
 * 5、float是单浮点类型，占4字节；
 * 6、double是双浮点类型，占8字节；
 * 7、char占2字节；
 * 8、boolean占1字节
 */

class People {
    //基本数据类型  4 byte
    private int age;
    //引用数据类型
    private String name;
    //基本数据类型  1 byte
    private boolean sex;

    public void say() {
        Boolean test = false;
        System.out.println(test);
        if (isOk()) {
        }
    }

    public Boolean isOk() {
        Boolean ok = false;
        return ok;
    }

    static {
        System.out.println("初始化~");
    }
    public static int a = 0;
}

