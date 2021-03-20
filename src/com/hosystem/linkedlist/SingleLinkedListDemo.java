package com.hosystem.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //测试
        //1.创建节点
        HeroNode heroNode1 = new HeroNode(1, "松江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //2.添加HeroNode到链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        /**
         *  第一种方法在添加英雄时，直接添加到链表的尾部
         *  问题：插入的HeroNode的顺序决定了取出的顺序
         *  TODO 解决插入时HeroNode直接是排好顺序的问题
         */
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        /**
         *  第二种方法 添加 按照编号顺序
         */
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);

        //3.输出链表
        singleLinkedList.list();
        System.out.println();
        System.out.println("--------------------修改后的信息--------------------");
        //测试修改节点
        HeroNode newHeroNode = new HeroNode(3,"hello","hello");
        singleLinkedList.update(newHeroNode);



        //3.输出链表
        singleLinkedList.list();
    }
}


