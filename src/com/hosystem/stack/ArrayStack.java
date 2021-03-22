package com.hosystem.stack;

/**
 * 定义一个数组 模拟栈
 */
public class ArrayStack {

    /**
     * maxSize:栈的大小
     * stack:数组 用于模拟栈 数据存放在该数组
     * top:表示栈顶 初始化为-1
     */
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack() {
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈-push
     *
     * @param value
     */
    public void push(int value) {

        //判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈-pop 将栈顶的数据返回
     *
     * @return
     */
    public int pop() {

        //判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 输出栈 遍历 从栈顶开始显示数据
     */
    public void list() {

        //判断栈是否空
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }

        //从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]" + "=" + stack[i]);
        }
    }
}
