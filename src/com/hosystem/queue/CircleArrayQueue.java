package com.hosystem.queue;

public class CircleArrayQueue {
    /**
     * maxSize:表示数组最大容量
     * front:队列头 front 就指向队列的第一个元素, arr[front] 是队列的第一个元素 front 的初始值 = 0。
     * rear:队列尾 rear 指向队列的最后一个元素的后一个位置. 空出一个空间做为约定。rear 的初始值 = 0。
     * arr:该数组用于存放数据 模拟队列
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部 front是指向队列头的前一个位置
        front = 0;
        //对象队列尾部 rear是指向队列尾的数据(即为队列最后一个数据)
        rear = 0;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
     * 添加数据到循环队列
     * addQueue 的处理需要有两个步骤：思路分析
     * 队列空:将尾指针往后移：rear+1 ;当 front == rear 【空】
     * 队列满:若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear 所指的数组元素中，否则无法存入数据。 rear == maxSize - 1【满】
     *
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已经满了，无法添加数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移 这里必须要考虑取模
        rear = (rear + 1) % maxSize;
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
        //这里需要分析front是指向队列的第一个元素
        //1、先把front对应的值保留到一个临时变量
        //2、将front后移 考虑取模
        //3、将临时保存的变量后移
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //显示队列的所有数据
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列空 没有数据");
            return;
        }
        /**
         *  从front开始遍历，遍历多少个元素
         *
         */
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + (i % maxSize) + "]" + " = " + arr[i % maxSize]);
        }
    }

    /**
     * 求当前队列有效数据的个数
     * rear = 1
     * front = 0
     * maxSize = 3
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
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
        return arr[front];
    }
}
