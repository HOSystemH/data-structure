package com.hosystem.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        System.out.println("------------------------双向链表测试------------------------");

        //创建节点
        HeroNodeDouble heroNode1 = new HeroNodeDouble(1, "松江", "及时雨");
        HeroNodeDouble heroNode2 = new HeroNodeDouble(2, "卢俊义", "玉麒麟");
        HeroNodeDouble heroNode3 = new HeroNodeDouble(3, "吴用", "智多星");
        HeroNodeDouble heroNode4 = new HeroNodeDouble(4, "林冲", "豹子头");

        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        //修改
        HeroNodeDouble newHeroNode = new HeroNodeDouble(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("------------------------修改双向链表测试------------------------");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delNode(3);
        System.out.println("------------------------删除双向链表测试------------------------");
        doubleLinkedList.list();
    }
}
