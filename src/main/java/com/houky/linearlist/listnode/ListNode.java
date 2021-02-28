package com.houky.linearlist.listnode;


/**
 * @author HoukyShen
 * @date 2021/2/28 - 18:18
 */
public class ListNode {
    //节点定义
    //数据
    public Object data;
    //指向下一个节点的变量
    public ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

