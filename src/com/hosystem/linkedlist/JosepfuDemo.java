package com.hosystem.linkedlist;


/**
 *  Josepfu测试
 */
public class JosepfuDemo {
    public static void main(String[] args) {
        //测试 构建循环单向链表 遍历循环单向链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //添加5个节点
        circleSingleLinkedList.addNode(5);
        circleSingleLinkedList.showNode();

        //测试 节点移除
        //nums 需要和 addNode中的nums 一致 若 countCur.nums > addNode.nums 则最多移除 addNodes.nums 换句话说，就是移除节点的总个数受限于addNode.nums设置的nums
        circleSingleLinkedList.countCur(1,2,5);

    }
}
