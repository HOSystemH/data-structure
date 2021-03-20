package com.hosystem.queue;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

/**
 * 使用数组模拟队列-编写Array-Queue类
 *  因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front 及 rear 分别记录队列前后端的下标，
 *  front 会随着数据输出而改变，而 rear 则是随着数据输入而改变，
 *  TODO：目前数组使用一次就不能用， 没有达到复用的效果 将这个数组使用算法，改进成一个环形的队列 取模：%
 */

class ArrayQueue {

    /**
     * maxSize:表示数组最大容量
     * front:队列头
     * rear:队列尾
     * arr:该数组用于存放数据 模拟队列
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    /**
     * 创建队列构造器
     *
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部 front是指向队列头的前一个位置
        front = -1;
        //对象队列尾部 rear是指向队列尾的数据(即为队列最后一个数据)
        rear = -1;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *  addQueue 的处理需要有两个步骤：思路分析
     *      队列空:将尾指针往后移：rear+1 ;当 front == rear 【空】
     *      队列满:若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear 所指的数组元素中，否则无法存入数据。 rear == maxSize - 1【满】
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已经满了，无法添加数据");
            return;
        }
        //rear后移一个位置
        rear++;
        arr[rear] = n;
    }

    /**
     * 数据出队列
     *
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空 不能取数据");
        }
        //front后移
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列空 没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]" + " = " + arr[i]);
        }
    }

    /**
     * 显示队列的投数据 不是取出数据 只是查看头数据
     *
     * @return
     */
    public int headQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空 没有数据 无法返回头数据");
        }
        return arr[front + 1];
    }
}
