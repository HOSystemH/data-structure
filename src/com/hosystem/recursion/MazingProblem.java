package com.hosystem.recursion;

public class MazingProblem {

    public static void main(String[] args) {
        // 创建一个二维数组 模拟迷宫
        int[][] map = new int[8][7];

        //使用1表示边界
        //上下全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;

        }

        //左右全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        //测试 如果没有通路的情况
        //map[1][3] = 1;
        //map[2][3] = 1;

        //输出
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//        System.out.println("---------------------------------------------");
//        //使用递归回溯
//        setWay(map, 1, 1);
//        //输出
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("---------------------------------------------");
        //使用递归回溯
        setWay2(map, 1, 1);
        //输出
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给节点找路
     * 说明:
     * 1.map:矩阵
     * 2.i,j 表示节点从矩阵出发的位置（1,1）
     * 3.如果能够达到map[6][5] 位置 则说明通路找到
     * 4.约定:当map[i][j] 为0表示该点没有走过 当为1表示为边界 2表示通路可以走 3表示该位置已被遍历过
     * 5.在遍历的时候 首先需要制定一个策略 下->右->上->左 若该点不同 回溯
     *
     * @param map 矩阵
     * @param i   开始遍历的位置
     * @param j
     * @return 找到通路 返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //表示该点没有被探到过
            if (map[i][j] == 0) {
                //策略 下->右->上->左
                map[i][j] = 2;  //假设该点可走通
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    //向右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    //向上走
                } else if (setWay(map, i - 1, j)) {
                    return true;
                    //向左走
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点走不通 死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //若map[i][j] != 0 可能为1 2 3
                return false;
            }
        }
    }

    /**
     * 使用递归回溯给节点找路
     * 在遍历的时候 首先需要制定一个策略 上->下->左->右若该点不同 回溯
     *
     * @param map 矩阵
     * @param i   开始遍历的位置
     * @param j
     * @return 找到通路 返回true
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //表示该点没有被探到过
            if (map[i][j] == 0) {
                //策略 上->下->左->右
                map[i][j] = 2;  //假设该点可走通
                //向下走
                if (setWay2(map, i - 1, j)) {
                    return true;
                    //向右走
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                    //向上走
                } else if (setWay2(map, i, j - 1)) {
                    return true;
                    //向左走
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else {
                    //说明该点走不通 死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //若map[i][j] != 0 可能为1 2 3
                return false;
            }
        }
    }
}
