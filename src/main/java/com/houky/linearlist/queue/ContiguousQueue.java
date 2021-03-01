package com.houky.linearlist.queue;


/**
 * @author HoukyShen
 * @date 2021/3/1 - 21:33
 * 循环队列的顺序存储实现
 */
public class ContiguousQueue {
    int front;//队头指针
    int rear;//队尾指针
    int maxSize = 10;//最大容量
    String[] queue;


    public static void main(String[] args) {
        ContiguousQueue contiguousQueue = new ContiguousQueue();
        contiguousQueue.init();
        for (int i = 0; i < 100; i++) {
            contiguousQueue.enQueue("我是" + (i+1));
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(contiguousQueue.deQueue());
        }
    }

    //初始化
    private boolean init() {
        queue = new String[maxSize];
        rear = 0;
        front = 0;
        return true;
    }

    //入队
    private boolean enQueue(String data) {
        //如果队满的话
        if ((rear+1)%maxSize==front) return false;
        queue[rear] = data;
        rear++;
        return true;
    }

    //出队
    private String deQueue() {
        //如果队空的话
        if (rear==front) return null;
        String s = queue[front];
        queue[front] = null;
        front++;
        return s;
    }
}
