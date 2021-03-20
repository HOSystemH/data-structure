package com.hosystem.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("----------------------数组模拟循环队列----------------------");
        //创建循环队列
        //arrMaxSize:4 队列最大的有效数据最大为3 留有一个用作约定
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        //接收用户的输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //设置菜单
        while (true) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中获取数据");
            System.out.println("h(head):查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                //取出数据
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据: " + res);
                    } catch (Exception e) {
                        //TODO handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                //查看队列头数据
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据为: " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                //退出
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }
}


