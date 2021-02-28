package com.houky.linearlist.stack;

import com.houky.linearlist.listnode.ListNode;

/**
 * @author HoukyShen
 * @date 2021/2/28 - 18:16
 * 链式存储实现的栈 ->  链栈
 * 在链表头部进行插入和删除操作，即把链表头部视为栈顶
 */
public class LinkedStack {
    static ListNode top;//栈顶指针
    static int maxSize;//最大容量
    static int size;//当前容量

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        initStack(linkedStack,10);
        push("第1个节点数据");
        push("第2个节点数据");
        push("第3个节点数据");
        System.out.println(size);
        System.out.println(pop());
        System.out.println(size);
        System.out.println(top);
    }

    private static void initStack(LinkedStack linkedStack, int max) {
        top = new ListNode();//定义头结点
        top.data = null;
        top.next = null;//第一个节点为空
        maxSize = max;
        size = 0;
    }

    //入栈
    private static boolean push(Object data){
        //健壮性
        if (size>=maxSize) return false;

        ListNode p = top;
        ListNode s = new ListNode();//定义新节点
        s.data = data;
        s.next=p.next;
        p.next=s;
        size++;
        return true;
    }

    //出栈
    private static Object pop(){
        //健壮性
        if (size<=0) return false;

        ListNode p = top;
        ListNode s = p.next;//定义被删除的节点
        p.next = s.next;
        size--;
        return s.data;
    }
}
