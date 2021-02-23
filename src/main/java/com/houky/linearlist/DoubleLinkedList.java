package com.houky.linearlist;

/**
 * @author HoukyShen
 * @date 2021/2/23 - 18:35
 * 线性表中的双链表实现
 */
public class DoubleLinkedList {
    //头节点，数据域不存放数据
    ListNode headNode;

    class ListNode {
        ListNode prior;//前指针
        Object data;//数据域
        ListNode next;//后指针

        @Override
        public String toString() {
            return "ListNode{" +
                    "prior=" + prior +
                    ", data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();//创建双链表
        doubleLinkedList.initList();//初始化双链表
        //创建双链表
        for (int i = 0; i < 3; i++) {
            doubleLinkedList.insert(i + 1, "节点数为：" + (i + 1));
        }
        //删除第二节点
        doubleLinkedList.delete(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(doubleLinkedList.getListNodeByIndex(i).next);
        }
    }

    //初始化双链表
    public void initList() {
        headNode = new ListNode();//创建头结点
        headNode.data = null;
        headNode.next = null;
        headNode.prior = null;
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

    //删除节点
    private boolean delete(int i) {
        //实现算法的健壮性
        if (i < 1) return false;
        //获取第i个节点，赋值为p
        ListNode p = getListNodeByIndex(i);
        //删除p节点
        if (p.next!=null) p.next.prior = p.prior; //把p的前指针赋值给下一节点的前指针
        p.prior.next = p.next;//把p的后指针赋值给上一节点的后指针
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
