package com.houky.linearlist;

/**
 * @author HoukyShen
 * @date 2021/2/25 - 20:24
 */
public class StaticList<E> {

    ListNode headNode;
    static ListNode<String>[] list;

    static class ListNode<E> {
        E data;
        int next;
    }


    public static void main(String[] args) {
        StaticList staticList = new StaticList();
        list = staticList.initList(4);
        list[0].data = "我是头结点";
        for (int i = 0; i < 3; i++) {
            boolean status = staticList.insert(i + 1, "我是第" + (i + 1) + "个节点");
            if (status == false) System.out.println("第" + (i + 1) + "条数据插入失败");
        }

        //删除第i个节点，0为头结点
        staticList.delete(1);
        for (ListNode<String> listNode : list) {
            //System.out.println(listNode.data);
        }
        for (int i = 0; i < list.length; i++) {
            if (i == 0) System.out.println(list[0].data);
            if (list[i].next != -1 && list[i].next != -2) {
                int index = list[i].next;
                System.out.println(list[index].data);
            }
        }
        //System.out.println(staticList.getListNodeByIndex(10).data);;
    }

    private ListNode[] initList(int size) {
        ListNode<String>[] list = new ListNode[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ListNode<>();
            if (i != 0) list[i].next = -2;//把头结点以外的所有节点的next赋值为-2，代表该节点数据域为空
        }
        list[0].data = null;//头结点赋值为空
        list[0].next = -1;//-1代表尾部
        headNode = list[0];

        return list;
    }

    //插入节点
    private boolean insert(int i, E data) {
        //实现算法的健壮性
        if (i < 1 || i > list.length - 1) return false;//0为头结点

        //获取第i-1个节点
        ListNode p = getListNodeByIndex(i - 1);

        //实现算法的健壮性
        if (p == null) return false;
        ListNode<String> s;
        for (int j = 0; j < list.length; j++) {
            if (list[j].next == -2) {
                s = list[j];//找到一片空白的区域给s赋值
                s.next = p.next;//p的后指针赋值给s的后指针
                p.next = j;//p的后指针改为指向s的下标i
                s.data = data.toString();
                return true;
            }
        }
        return false;
    }

    //删除节点
    private boolean delete(int i) {
        //实现算法的健壮性
        if (i < 1 || i > list.length - 1) return false;//0为头结点

        //获取第i-1个节点，赋值为p
        ListNode p = getListNodeByIndex(i - 1);
        //删除p节点后面的节点
        list[p.next].data = null;
        int s = p.next;
        p.next = list[p.next].next;//把p的后指针改为下一个节点的后指针
        list[s].next = -2; //设置为空
        return true;
    }


    //获取节点
    private ListNode getListNodeByIndex(int i) {
        //实现算法的健壮性
        if (i < 0 || i > list.length - 1) return null;//0为头结点
        ListNode p = headNode;
        int j = 0;
        while (p.next != -1 && j < i) {
            p = list[p.next];
            j++;
        }
        return p;
    }
}
