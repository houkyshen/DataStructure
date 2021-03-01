package com.houky.linearlist.queue;

import com.houky.linearlist.listnode.ListNode;
/**
 * @author HoukyShen
 * @date 2021/3/1 - 21:56
 * 队列的链式存储结构实现
 */
public class LinkedQueue {
    ListNode front;//队头指针
    ListNode rear;//队尾指针
    ListNode headNode;//头结点

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.init();
        for (int i = 0; i < 5; i++) {
            linkedQueue.enQueue("我是第" + (i + 1));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(linkedQueue.deQueue());
        }
    }

    //初始化队列
    private boolean init() {
        headNode = new ListNode();
        front = headNode;
        rear = headNode;
        headNode.data = null;
        return true;
    }

    //入队
    private boolean enQueue(String data) {
        ListNode s = new ListNode();
        s.data = data;
        rear.next = s;
        rear = s;
        return true;
    }

    //出队
    private Object deQueue() {
        Object data = front.next.data;
        front.next = front.next.next;
        return data;
    }
}
