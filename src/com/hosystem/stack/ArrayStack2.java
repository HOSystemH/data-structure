package com.hosystem.stack;

/**
 *  栈实现综合计算器(中缀表达式)
 */
public class ArrayStack2 {


    /**
     * maxSize:栈的大小
     * stack:数组 用于模拟栈 数据存放在该数组
     * top:表示栈顶 初始化为-1
     */
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2() {
    }

    public ArrayStack2(int maxSize) {
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

    //返回运算符的优先级 优先级由程序员确定 优先级使用数字表示
    //数字越大 优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        // 用于存放计算结果
        int res = 0;

        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                //TODO 这里的顺序不能够改变 否则输出的结果为错
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                //TODO 这里的顺序不能够改变 否则输出的结果为错
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     *  返回当前栈顶的值 不是弹出pop栈查看方式
     */
    public int peek(){
        return stack[top];
    }
}