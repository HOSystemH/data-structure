package com.hosystem.linkedlist;

import java.util.Stack;

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

//        //3.输出链表
//        singleLinkedList.list();
//
//        System.out.println();
//        System.out.println("--------------------修改后的信息--------------------");
//        //测试修改节点
//        HeroNode newHeroNode = new HeroNode(3, "hello", "hello");
//        singleLinkedList.update(newHeroNode);
//        //3.输出链表
//        singleLinkedList.list();
//
//        System.out.println();
//        System.out.println("--------------------删除后的信息--------------------");
//        singleLinkedList.delNode(1);
//        //3.输出链表
//        singleLinkedList.list();
//
//        //测试 求单链表中有效节点个数
//        System.out.println("有效节点个数: " + getLength(singleLinkedList.getHead()));
//
//        //测试 得到倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println("倒数节点信息:" + res);

//        //测试 单链表反转
//        System.out.println();
//        System.out.println("--------------------------未反转链表--------------------------");
//        singleLinkedList.list();
//        System.out.println();
//        System.out.println("--------------------------反转链表--------------------------");
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();


        System.out.println("--------------------------未反转链表--------------------------");
        singleLinkedList.list();

        //        System.out.println("--------------------------反转链表--------------------------");
        // 单链表反转输出 要求不改变链表结构
        reversePrint(singleLinkedList.getHead());
    }


    /**
     *  从尾到头打印单链表(倒序打印链表)
     *  方法:
     *      (1).反向遍历[会改变链表的结构] 不推荐使用
     *      (2).使用stack栈特性 [先进后出] 推荐使用 不改变链表结构
     */
    public static void reversePrint(HeroNode heroNode){
        if(heroNode.next == null){
            return;
        }
        //创建一个栈 将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = heroNode.next;

        //入栈
        while (cur != null) {
           stack.push(cur);
           cur = cur.next;
        }

        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }


    /**
     * 单链表反转
     */
    public static void reversetList(HeroNode head) {
        //若当前链表为空 或者只有一个节点 无需反转 直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义辅助指针(变量) 帮助遍历原来链表
        HeroNode cur = head.next;
        //指向当前节点[cur]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来链表
        //每遍历一个节点 将其取出 并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;    //暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;    //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next; //让cur后移
        }

        //将head.next 指向reverseHead.next 实现单链表反转
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中的倒数第K个节点
     * 思路:
     * 1.编写一个方法 接收head节点,同时接收一个index
     * 2.index表示 倒数第index个节点
     * 3.首先遍历链表(从头到尾) 得到链表总长度 size
     * 4. 得到size后 从链表的第一个开始遍历（size-index)个 便可得到倒数第K个节点
     * 5.找到 返回该节点。否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空 返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度(节点个数)
        int size = getLength(head);

        //第二次遍历 size-index 位置 为倒数第K个节点 即 K = size-index
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量cur 使用for循环定位到倒数index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 获取单链表节点的个数(若带头结点的链表,需要不统计头结点)
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {

        if (head.next == null) {
            return 0;
        }

        int length = 0;
        //定义一个辅助变量cur
        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}


