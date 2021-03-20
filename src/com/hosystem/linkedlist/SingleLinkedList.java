package com.hosystem.linkedlist;

public /**
 *  定义SingleLinkedListDemo 管理HeroNode
 */
class SingleLinkedList{
    //先初始化一个头结点 头结点不动,不存放具体的数据 否则后面可能找不到
    private HeroNode head = new HeroNode(0,"","");

    /**
     *  添加节点到单向链表
     *  思路:不考虑节点顺序时
     *  1.找到当前链表的最后节点
     *  2.将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        //因为head节点不能动 因此需要一个辅助变量temp
        HeroNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        //当退出while循环时 temp就指向了链表的最后节点
        //将最后节点的next指向新的节点
        temp.next = heroNode;
    }

    //显示链表【遍历】
    public void list(){
        //1.首先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        //头节点不能够变动,因此需要辅助变量来遍历
        HeroNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
