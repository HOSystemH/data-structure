package com.hosystem.linkedlist;

public class Josepfu {

    /**
     *  no:编号
     *  next:指向下一个节点 默认为null
     */
    private int no;
    private Josepfu next;

    public Josepfu() {
    }

    public Josepfu(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Josepfu getNext() {
        return next;
    }

    public void setNext(Josepfu next) {
        this.next = next;
    }
}
