package com.hosystem.linkedlist;

public
/**
 *  定义HeroNode 每个HerNode对象就是一个节点
 */
class HeroNode{
    /**
     *  no:编号
     *  name:名字
     *  nickname:外号
     *  next:指向下一个节点
     */
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //无参构造器
    public HeroNode(){}

    //有参构造器
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
