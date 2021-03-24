package com.hosystem.recursion;

public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;

    //定义数组array 保存皇后放置位置的结果 比如 arr={0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    //8皇后 解法数
    static int count = 0;

    //遍历的次数
    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试 8皇后问题
        Queue8 queue8 = new Queue8();

        queue8.check(0);
        System.out.println("8皇后问题总解法数:" + count);
        System.out.println("遍历的次数:"+judgeCount);
    }

    //将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    /**
     * @param n 表示第n个皇后
     * @return
     */
    //查看当放置第n个皇后 就去检测皇后是否和签名已经摆放的皇后冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //1.arr[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后在同一斜线
            // 第二个皇后为 n=1 放置第2列1 n = 1 array[1] = 1
            //Math.abs(n-i) ==> Math.abs(1-0) == 1 ---- Math.abs(array[n] - array[i]) ==> Math.abs(array[1] -array[0]) ==> Math.abs(1-0)
            //3.判断是否在同一行 n每次都在递增 所以没有必要判断行是否重复
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    private void check(int n) {
        if (n == max) { //当n = 8 win
            print();
            return;
        }

        //依次放入皇后 并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后n 放到该行的第1列 判断是否冲突
            array[n] = i;
            if (judge(n)) {//不冲突
                //接着放第n+1个皇后 即开始递归
                check(n + 1);
            }
        }
        //如果冲突 就继续执行array[n] = i 即将第n个皇后 放到本行的 后移一个位置(行不动 列往后移)
    }
}
