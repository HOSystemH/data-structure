package com.hosystem.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        /**
         *  创建一个原始的二维数组 11*11
         *  0:表示没有棋子 1:黑棋子 2:白棋子
         */
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //输出原始数组
        System.out.println("-------------------原始二维数组-------------------");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组
        //1.先遍历二维数组 得到非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("-------------------非0的个数: " + sum + "-------------------");

        //2.创建稀疏数组
        /**
         *  1. 遍历  原始的二维数组，得到有效数据的个数 sum
         *  2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
         *  3. 将二维数组的有效数据数据存入到 稀疏数组
         */
        int[][] sparseArr = new int[sum + 1][3];
        //2.1 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组 将非0的值存放到sparseArr中
        // count 用于记录是第几个非0数据
        int count = 0;

        //将稀疏数组赋值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("-------------------稀疏数组-------------------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }

        //3.将稀疏数组 转 二维数组
        /**
         *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         *  2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */

        // 3.1 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArray1 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //3.2 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
        for (int i = 1; i < sparseArr.length; i++) {
            chessArray1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("-------------------恢复的二维数组-------------------");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         *  TODO 通过IO保存到磁盘中
         */
    }
}
