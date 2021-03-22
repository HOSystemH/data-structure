package com.hosystem.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        /**
         *  测试逆波兰计算器
         *  定义逆波兰表达式
         *  中缀表达式:(3+4)*5-6 -> 后缀表达式(逆波兰表达式)3 4 + 5 * 6 - => 29
         */
        //为了方便 你波兰表达式的数字和符号使用`空格`隔开
        String suffixExpression = "3 4 + 5 * 6 -";

        /**
         *  思路:
         *      1.先将"3 4 + 5 * 6 -" 放到ArrayList中
         *      2.将ArrayList 传递给方法 遍历ArrayList配合栈完成计算
         */
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList: " + rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是: "+ res);

        //测试 多位数
        //中缀表达式:(30+4)*5-6 -> 后缀表达式(逆波兰表达式)3 4 + 5 * 6 - => 164
        String suffixExpression2 = "30 4 + 5 * 6 -";
        List<String> rpnList2 = getListString(suffixExpression2);
        int res2 = calculate(rpnList2);
        System.out.println("计算的结果是: "+ res2);

        //测试 多位数
        //中缀表达式: 4 * 5 - 8 + 60 + 8 / 2 -> 后缀表达式(逆波兰表达式)4 5 * 8 - 60 + 8 2 / +
        String suffixExpression3 = "4 5 * 8 - 60 + 8 2 / +";
        List<String> rpnList3 = getListString(suffixExpression3);
        int res3 = calculate(rpnList3);
        System.out.println("计算的结果是: "+ res3);
    }

    //将一个逆波兰表达式 依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");

        List<String> list = new ArrayList<String>();

        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成你波兰表达式的运算

    /**
     * (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
     * <p>
     * 1.从左至右扫描，将3和4压入堆栈；
     * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3.将5入栈；
     * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5.将6入栈；
     * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> list) {
        //创建栈 只需要一个栈
        Stack<String> stack = new Stack<String>();

        //遍历 list
        for (String item : list) {
            //使用正则表达式取出数
            if (item.matches("\\d+")) { //匹配多位数
                //入栈
                stack.push(item);
            } else {
                //pop两个数 并运算 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有错误");
                }
                //把res 入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}