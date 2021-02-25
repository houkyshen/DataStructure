package com.houky.linearlist;

/**
 * @author HoukyShen
 * @date 2021/2/25 - 19:29
 */
public class LoopDoubleLinkedList {

    ListNode headNode;

    class ListNode{
        ListNode prior;
        Object data;
        ListNode next;
    }

    public static void main(String[] args) {

        LoopDoubleLinkedList loopDoubleLinkedList = new LoopDoubleLinkedList();//创建双链表
        loopDoubleLinkedList.initList();//初始化双链表
        //创建双链表
        for (int i = 0; i < 3; i++) {
            loopDoubleLinkedList.insert(i + 1, "节点数为：" + (i + 1));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(loopDoubleLinkedList.getListNodeByIndex(i).data);
        }
    }

    //初始化双链表
    public void initList() {
        headNode = new ListNode();//创建头结点
        headNode.data = null;
        headNode.next = headNode;
        headNode.prior = headNode;
    }

    //插入节点
    private boolean insert(int i, Object value) {
        //实现算法的健壮性
        if (i < 1) return false;
        //获取第i-1个节点，赋值为p
        ListNode p = getListNodeByIndex(i - 1);
        //在p节点后面插入节点，使用后插法
        insertNextNode(p, value);
        return true;
    }
    //后插法，在指定的节点后面插入节点
    private boolean insertNextNode(ListNode p, Object value) {
        //实现算法的健壮性
        if (p == null) return false;
        ListNode s = new ListNode();
        s.data = value;
        s.next = p.next;//1、新节点的后指针
        s.prior = p;//2、新节点的前指针
        if (p.next!=null)
            p.next.prior = s;//3、下一节点的前指针
        p.next = s;//4、上一节点的后指针
        return true;
    }
    
    
    //获取节点
    private ListNode getListNodeByIndex(int i) {
        //实现算法的健壮性
        if (i < 0) return null;//0为头结点
        ListNode p = headNode;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            j++;
        }
        return p;
    }
}
