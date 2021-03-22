package com.hosystem.linkedlist;

/**
 * 创建单向循环链表
 */
public class CircleSingleLinkedList {

    //创建一个first节点
    private Josepfu first = null;

    //添加节点 构建成一个环形链表
    public void addNode(int nums) {

        //nums 校验 若nums< 2 则直接返回null
        if (nums < 2) {
            System.out.println("输入的值不正确 请重新输入");
            return;
        }

        //辅助指针 帮助构建循环单向链表
        Josepfu cur = null;

        //使用for循环 创建循环单向链表
        //i 也可以从0开始 若i从0开始  则 i<=nums 修改为 i<nums  if(i==1) 修改为 if(i==0)
        for (int i = 1; i <= nums; i++) {
            //根据编号 创建节点
            Josepfu josepfuNode = new Josepfu(i);

            //若为第一个节点Node
            if (i == 1) {
                first = josepfuNode;
                first.setNext(first);   //构成环
                cur = first; //让cur指向第一个节点 用于记录节点信息
            }
            cur.setNext(josepfuNode);
            josepfuNode.setNext(first);
            //这一步非常重要 需要将cur指向下一个josefuNode 否则cur不指向最后一个节点
            cur = josepfuNode;
        }
    }

    //遍历循环单向链表
    public void showNode() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //first是不能够移动的 只能标志为头结点 使用辅助指针temp完成遍历
        Josepfu cur = first;
        while (true) {
            System.out.println("编号为:" + cur.getNo());
            //单向链表 最后节点判断的条件为:p->next == head(头结点)
            //cur.getNext() == first 说明已经遍历完毕
            if (cur.getNext() == first) {
                System.out.println("遍历完毕");
                break;
            }
            //没有遍历完毕 则移动到下一个节点
            cur = cur.getNext();
        }
    }

    /**
     * 根据用户的输入 计算节点移除的顺序
     *
     * @param startNo  表示从第几个节点开始计数
     * @param countNum 表示计数多少
     * @param nums     表示最初由几个节点还在链表中
     */
    public void countCur(int startNo, int countNum, int nums) {

        //校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入有错 请重新输入");
            return;
        }

        //创建辅助指针 用于链表节点移除
        //创建一个辅助指针(变量) helper , 事先应该指向循环链表最后的节点
        Josepfu helper = first;
        while (true) {

            //说明helper指向最后小孩节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //循环操作 直到链表只有一个节点
        while (true) {
            //helper == first 时 链表只有一个节点
            if (helper == first) {
                break;
            }
            //节点移除前 先让 first 和  helper 移动 k - 1次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("节点 `" + first.getNo() + "` 移除循环链表");
            //将first指向的节点移除
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("存在链表的节点为: " + first.getNo());
    }
}
