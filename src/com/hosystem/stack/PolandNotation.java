package com.hosystem.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

//        /**
//         *  测试逆波兰计算器
//         *  定义逆波兰表达式
//         *  中缀表达式:(3+4)*5-6 -> 后缀表达式(逆波兰表达式)3 4 + 5 * 6 - => 29
//         */
//        //为了方便 你波兰表达式的数字和符号使用`空格`隔开
//        String suffixExpression = "3 4 + 5 * 6 -";
//
//        /**
//         *  思路:
//         *      1.先将"3 4 + 5 * 6 -" 放到ArrayList中
//         *      2.将ArrayList 传递给方法 遍历ArrayList配合栈完成计算
//         */
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList: " + rpnList);
//
//        int res = calculate(rpnList);
//        System.out.println("计算的结果是: " + res);
//
//        //测试 多位数
//        //中缀表达式:(30+4)*5-6 -> 后缀表达式(逆波兰表达式)3 4 + 5 * 6 - => 164
//        String suffixExpression2 = "30 4 + 5 * 6 -";
//        List<String> rpnList2 = getListString(suffixExpression2);
//        int res2 = calculate(rpnList2);
//        System.out.println("计算的结果是: " + res2);
//
//        //测试 多位数
//        //中缀表达式: 4 * 5 - 8 + 60 + 8 / 2 -> 后缀表达式(逆波兰表达式)4 5 * 8 - 60 + 8 2 / +
//        String suffixExpression3 = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> rpnList3 = getListString(suffixExpression3);
//        int res3 = calculate(rpnList3);
//        System.out.println("计算的结果是: " + res3);

        /**
         *  完成 中缀表达式 转 后缀表达式
         *  1. "1+((2+3)×4)-5"转  换为后缀表达式 "1 2 3 + 4 × + 5 –"
         *  2. 因为对str进行操作 先将"1+((2+3)×4)-5" 转为 中缀表达式对应的list 即 "1+((2+3)×4)-5" => ArrList[1,+,(,(,2,+,3,),×,4,),-,5]
         *  3. 将得到的中缀表达式list -> 后缀表达式list
         *      即ArrayList[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList[1,2,3,+,4,×,+,5,–]
         */
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        System.out.println("中缀表达式: " + infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式: " + suffixExpressionList);

        System.out.println("expression:"+calculate(suffixExpressionList));

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

    /**
     * 将中缀表达式 转 list
     */
    public static List<String> toInfixExpressionList(String str) {
        //定义一个List 存放中缀表达式对应的内容
        List<String> list = new ArrayList<String>();

        //指针 用于遍历 中缀表达式str
        int cur = 0;

        //用于对多位数的拼接
        String strmerge = "";

        //每遍历到字符 就存放到ch
        char ch;
        do {
            //若ch是非数字 加入到list
            if ((ch = str.charAt(cur)) < 48 || (ch = str.charAt(cur)) > 57) {
                list.add("" + ch);
                cur++;
            } else {
                //若ch为数字 则需要考虑多位数问题
                strmerge = ""; //先将strmerge 赋初值""
                while (cur < str.length() && (ch = str.charAt(cur)) >= 48 && (ch = str.charAt(cur)) <= 57) {
                    //拼接
                    strmerge += ch;
                    cur++;
                }
                list.add(strmerge);
            }
        } while (cur < str.length());

        //返回结果
        return list;
    }

    /**
     * 即ArrayList[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] => ArrayList[1,2,3,+,4,×,+,5,–]
     * 中缀表达式list -> 后缀表达式list
     *
     * @param list
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();

        //因为栈arrayList在转换过程中 没有pop操作 最后还需要逆序输出
        //因此比较麻烦,这里不用Stack  直接使用  List<String> 替代
        List<String> s2 = new ArrayList<String>();

        //遍历list
        for (String item : list) {
            //若为数 加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //1.若为右括号 ")" 则一次弹出s1栈顶的运算符 并压入s2 知道遇到有括号")"为止 此时将`()`一堆括号丢弃
                while (!s1.peek().equals("(")) {
                    //将s1的值弹栈 并压入 s2中
                    s2.add(s1.pop());
                }
                //2.将 `(` 弹出 消除(
                s1.pop();
            } else {
                //3.当item的优先级小于栈顶运算符的优先级
                //将s1栈顶的运算符弹出并压入到s2中，再次转到`1.`与s1中新的栈顶运算符相比较；
                //TODO 缺少比较优先级的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并压入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        //存放到list 因此按顺序输出对应的就是后缀表达式对应的list
        return s2;
    }

}