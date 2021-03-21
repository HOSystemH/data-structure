package com.hosystem.linkedlist;

public class DoubleLinkedList {
    //先初始化一个头结点 头结点不动,不存放具体的数据 否则后面可能找不到
    private HeroNodeDouble head = new HeroNodeDouble(0, "", "");

    //返回头结点
    public HeroNodeDouble getHead() {
        return head;
    }

    //显示链表【遍历】
    public void list() {
        //1.首先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //头节点不能够变动,因此需要辅助变量来遍历
        HeroNodeDouble temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    /**
     * 添加节点到双向链表的末尾
     *  temp.next = newHeroNode
     *  newHeroNode.pre = temp;
     * @param heroNode
     */
    public void add(HeroNodeDouble heroNode) {
        //因为head节点不能动 因此需要一个辅助变量temp
        HeroNodeDouble temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        //当退出while循环时 temp就指向了链表的最后节点
        //将最后节点的next指向新的节点
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre  = temp;
    }

    /**
     *  修改双向链表节点信息 根据no编号修改
     *  思路:根据HeroNodeDouble的no来修改
     * @param heroNode
     */
    public void update(HeroNodeDouble heroNode){
        //判断是否空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点 根据no编号
        //使用辅助变量temp
        HeroNodeDouble temp = head.next;
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

    //删除节点
    //思路: 因为是双向链表，因此，我们可以实现自我删除某个节点
    //temp.pre.next = temp.next
    //temp.next.pre = temp.pre;
    public void delNode(int no){

        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空 不能够删除");
            return;
        }

        HeroNodeDouble temp = head.next; //辅助节点
        boolean flag = false;   //标志待删除节点
        while(true){
            //到达末尾未找到节点
            if(temp.next == null){
                break;
            }
            //找到待删除节点的前一个节点temp
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if(flag){
            //可以删除
            temp.pre.next = temp.next;
            //TODO 代码有小问题 若是该节点为最后节点，就不执行以下语句 否则会出现空指针异常
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.println("没有找到需要删除的节点");
        }
    }
}
