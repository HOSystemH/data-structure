package com.hosystem.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        //测试 递归
        test(4);
        int res = factorial(4);
        System.out.println("4!=" + res);
    }

    //递归输出
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
