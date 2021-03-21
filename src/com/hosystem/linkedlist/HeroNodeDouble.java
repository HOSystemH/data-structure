package com.hosystem.linkedlist;

public class HeroNodeDouble {

    /**
     *  no:编号
     *  name:名字
     *  nickname:外号
     *  next:指向下一个节点 默认为null
     *  pre:指向前一个节点 默认为null
     */
    public int no;
    public String name;
    public String nickname;
    public HeroNodeDouble next;
    public HeroNodeDouble pre;

    //无参构造器
    public HeroNodeDouble(){}

    //有参构造器
    public HeroNodeDouble(int no,String name,String nickname){
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
