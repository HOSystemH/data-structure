package com.hosystem.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {

        //测试 栈
        ArrayStack arrayStack = new ArrayStack(4);

        String key = "";
        //控制菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("pop:  数据出栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 数据入栈");
            System.out.println("show: 数据全出栈");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println("出栈数据:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
