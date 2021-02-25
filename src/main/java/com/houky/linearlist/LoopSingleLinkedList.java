package com.houky.linearlist;

/**
 * @author HoukyShen
 * @date 2021/2/24 - 18:00
 * 循环单链表的实现，其实就是在单链表的初始化方法中把头结点的后指针指向头结点即可
 */
public class LoopSingleLinkedList {
    //头指针，若有头结点则指向头结点，若没有头结点则指向第一个节点
    Object head;
    //头节点，数据域不存放数据
    ListNode headNode;

    class ListNode {//节点定义
        //数据
        Object data;
        //指向下一个节点的变量
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoopSingleLinkedList{" +
                "head=" + head +
                ", headNode=" + headNode +
                '}';
    }

    public static void main(String[] args) {
        LoopSingleLinkedList loopSingleLinkedList = new LoopSingleLinkedList();//创建链表，为链表申请存储空间
        loopSingleLinkedList.initList1();//初始化链表，带头结点
        for (int i = 0; i < 3; i++) {
            loopSingleLinkedList.insert("第" + (i + 1) + "个节点", i + 1);
        }
        loopSingleLinkedList.insert("第2个节点，不一样了哦", 2);//链表至少要有i-1个节点，否则插入失败
        //loopSingleLinkedList.delete(3);
        loopSingleLinkedList.insertNextNode(loopSingleLinkedList.headNode, "头插法1");
        loopSingleLinkedList.insertNextNode(loopSingleLinkedList.headNode, "头插法2");
        System.out.println(loopSingleLinkedList.getListNodeByIndex(1).data);;
        for (int i = 0; i < 50; i++) {
            System.out.println(loopSingleLinkedList.getListNodeByIndex(i).data);;
        }
    }

    //初始化链表，带头结点
    private void initList1() {
        headNode = new ListNode();//创建头结点
        head = headNode;//头指针指向头结点
        headNode.data = null;
        headNode.next = headNode;//空表的头结点后指针指向自己
    }

    //不带头结点
    private void initList2(LoopSingleLinkedList LoopSingleLinkedList) {
        head = null;
    }

    //插入节点
    private boolean insert(Object value, int i) {
        if (i < 1) {
            return false;
        }
        //获取第i-1个节点，定义为p节点
        ListNode p = this.getListNodeByIndex(i-1);
        if (p == null) {//如果i值不合法
            return false;
        }
        //在p节点后面插入新节点
        insertNextNode(p, value);
        return true;
    }


    //后插法，在节点p后面插入节点
    private boolean insertNextNode(ListNode p, Object value) {
        if (p == null) return false;
        //创建插入节点
        ListNode s = new ListNode();
        //给插入节点赋值
        s.data = value;
        //把p节点的指针赋给s节点
        s.next = p.next;
        //把p节点的指针改变为指向s节点
        p.next = s;
        return true;
    }

    //前插法，在节点p前面插入节点
    private boolean insertPreviousNode(ListNode p, Object value) {
        if (p == null) {//如果i值不合法
            return false;
        }
        //创建第i个节点的存储空间
        ListNode s = new ListNode();
        //给第i个节点赋值
        s.data = value;
        //把第i-1个节点的指针赋给第i个节点
        s.next = p.next;
        //把第i-1个节点的指针改变为指向第i个节点
        p.next = s;
        Object temp;
        //把值调换
        temp = p.data;
        p.data = s.data;
        s.data = temp;
        return true;
    }

    //删除节点
    private boolean delete(int i) {
        if (i < 1) {//头结点不可删除，故i不能小于1
            return false;
        }
        //获取第i-1个节点
        ListNode p = this.getListNodeByIndex(i - 1);
        if (p == null) {//如果i值不合法
            return false;
        }
        p.next = p.next.next;
        return true;
    }

    //查找节点，按位查找
    private ListNode getListNodeByIndex(int i) {
        if (i < 0) {//0为头结点
            return null;
        }
        ListNode p = headNode;//把p定义为头结点
        //判断index是否大于链表的长度，大于的话则获取失败
        //循环遍历到第index个节点
        int j = 0;//当前p指向第几个节点
        while (p != null && j < i) {
            //找到第i个节点
            p = p.next;
            j++;
        }
        return p;
    }

    //查找节点，按值查找，找到第一个与传入值相等的节点
    private ListNode getListNodeByValue(Object value) {

        ListNode p = headNode;//把p定义为头结点
        //判断index是否大于链表的长度，大于的话则获取失败
        //循环遍历到第index个节点
        int j = 0;//当前p指向第几个节点
        if (value == null) {
            while (p != null && value != p.data) {//若value是含有多个属性的对象，则需要分开比较
                p = p.next;
                j++;
            }
            return p;
        }
        while (p != null && !value.equals(p.data)) {//若value是含有多个属性的对象，则需要分开比较
            p = p.next;
            j++;
        }
        return p;
    }

    //判断单链表是否为空
    private boolean isEmpty() {//判断头结点的后指针是否指向自己
        return headNode.next == headNode;
    }
}
