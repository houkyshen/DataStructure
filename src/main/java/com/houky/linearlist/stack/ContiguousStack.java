package com.houky.linearlist.stack;

import com.houky.linearlist.StaticList;

import java.util.Arrays;

/**
 * @author HoukyShen
 * @date 2021/2/26 - 1:03
 * 栈的顺序存储实现，栈其实是一种特殊的线性表
 */
public class ContiguousStack {

    int top;//栈顶指针，栈不需要头结点
    ListNode<String>[] list;

    static class ListNode<E> {
        E data;

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ContiguousStack{" +
                "top=" + top +
                ", list=" + Arrays.toString(list) +
                '}';
    }

    public static void main(String[] args) {
        ContiguousStack contiguousStack = new ContiguousStack();//初始化栈
        contiguousStack.initStack(10);
        for (int i = 0; i < 10; i++) {
            contiguousStack.push("我是第" + i);
        }
        for (ListNode<String> stringListNode : contiguousStack.list) {
            System.out.println(stringListNode.data);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(contiguousStack.pop().data);
        }
        System.out.println(contiguousStack.list);
    }

    private void initStack(int maxSize) {
        list = new ListNode[maxSize];
        for (int i = 0; i < maxSize; i++) {
            list[i] = new ListNode<>();
            list[i].data = null;
        }
        top = -1;//栈顶指针为-1时表明此时栈为空
    }

    //出栈
    private ListNode pop() {
        //健壮性
        if (top < 0) return null;
        ListNode p = list[top];
        list[top] = null;
        top--;
        return p;
    }

    //入栈
    private boolean push(String data) {
        //健壮性
        if (top > list.length - 1) return false;
        list[top + 1].data = data;
        top++;
        return true;
    }
}
