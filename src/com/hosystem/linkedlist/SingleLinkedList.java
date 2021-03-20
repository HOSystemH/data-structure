package com.hosystem.linkedlist;

import org.omg.SendingContext.RunTime;

/**
 * 定义SingleLinkedListDemo 管理HeroNode
 */
public class SingleLinkedList {
    //先初始化一个头结点 头结点不动,不存放具体的数据 否则后面可能找不到
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 方法1：添加节点到单向链表
     * 思路:不考虑节点顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动 因此需要一个辅助变量temp
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        //当退出while循环时 temp就指向了链表的最后节点
        //将最后节点的next指向新的节点
        temp.next = heroNode;
    }

    //显示链表【遍历】
    public void list() {
        //1.首先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //头节点不能够变动,因此需要辅助变量来遍历
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    /**
     * 方法2：添加节点到单向链表
     * 思路:根据排名将英雄插入到指定位置 如果有这个排名，则添加失败，并给出提示
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为head节点不能动 因此需要一个辅助变量temp
        HeroNode temp = head;
        //标志添加的编号是否存在 默认为false
        boolean flag = false;

//        //TODO 该处逻辑需要修改
//        //temp是位于 添加位置为前一个节点 否则插入不了
//        while (temp.next != null) {
//            temp = temp.next;
//            //位置找到 就在temp后面 换句话说，herNode.no 需要小于temp.no
//            if (temp.no > heroNode.no) {
//                break;
//            }
//            if (temp.no == heroNode.no) {
//                flag = true;
//                break;
//            }
//        }

        while(true){
            // 若temp.next==null 说明已经到达链表尾部
            if(temp.next == null){
                break;
            }

            if(temp.next.no>heroNode.no){
                //插入的位置找到 当前这个节点 应该加入到temp后面
                break;
            }else  if(temp.next.no == heroNode.no){

                //节点已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag的值
        //若flag为true 则编号存在
        if (flag) {
            System.out.println("准备插入编码已经存在: " + heroNode.no);
        } else {
            //插入到链表中 temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }



    /**
     *  修改节点信息 根据no编号修改
     *  思路:根据HeroNode的no来修改
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        //判断是否空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点 根据no编号
        //使用辅助变量temp
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            //到达最后一个节点
            if(temp==null){
                break;
            }
            if(temp.no == heroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{
            System.out.println("没有找到该编号"+heroNode.no+"的英雄");
        }
    }
}
