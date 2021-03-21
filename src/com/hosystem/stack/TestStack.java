package com.hosystem.stack;

import java.util.Stack;

/**
 * stack基本使用
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        //入栈
        /**
         *  public synchronized boolean add(E e)
         */
        stack.add("jack");
        /**
         *  public E push(E item)
         */
        stack.push("tom");
        stack.push("smith");

        //出栈
        while (stack.size() > 0) {
            //将栈顶的数据取出
            System.out.println(stack.pop());
        }
    }
}
