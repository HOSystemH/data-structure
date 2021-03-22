package com.hosystem.stack;

/**
 *  栈实现综合计算器(中缀表达式) 测试
 */
public class Calculator {

    public static void main(String[] args) {
        //测试 表达式运算
        String expression = "7*2*2-5+1-5+3-4";
        //创建两个栈 数字栈、符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将扫描得到char保存到ch
        String keepNum = "";
        //开始while循环的扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            /**
             *  如果发现扫描是符号,  就分如下情况
             *  (1).如果发现当前的符号栈为 空，就直接入栈
             *  (2).如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈， 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
             */
            if (operStack.isOper(ch)) {
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //处理
                    //(2).如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，
                    // 入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果压栈
                        numStack.push(res);

                        //把当前操作符如符号栈
                        operStack.push(ch);
                    } else {
                        //如果为空 直接入栈  如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                        operStack.push(ch);
                    }
                } else {
                    //发现当前的符号栈为 空，就直接入栈
                    operStack.push(ch);
                }
            } else {
                //若为数 则直接入数栈
//                numStack.push(ch - 48);
                //1.在处理多位数时 不能够发现是一个数就立即入栈 可能这个数由多位数组成
                //2.在处理数时 需要expression的表达式的index 后再看一位 如果是数就进行扫描 如果是符号才入栈
                //3.因此需要定义一个变量 用于拼接

                //处理多位数
                keepNum += ch;

                /**
                 *  StringIndexOutOfBoundsException: String index out of range: 8
                 *  需要判断是不是最后一位 如果ch是最后一位 就直接入栈
                 */
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字 如果是数字 就继续扫描 如果是运算符 则入栈
                    //看后一位 不是index++ 若后一位为运算符 则入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //*** 将keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让 index + 1 判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true) {
            //若 符号栈为空 则计算到最后的结果 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }


        //将数栈的最后数 pop
        int res2 = numStack.pop();
        System.out.println("表达式: " + expression + "结果是:" + res2);
    }
}
