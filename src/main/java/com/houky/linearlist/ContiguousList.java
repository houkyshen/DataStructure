package com.houky.linearlist;

/**
 * @author HoukyShen
 * @date 2021/2/20 - 22:15
 * 线性表中的顺序表实现：动态分配内存
 */
public class ContiguousList {
    public static final int InitSize = 10; //初始长度为10
    int[] data; //指示动态分配数组的指针
    int MaxSize; //顺序表的最大容量
    int length;  //顺序表的当前长度

    public static void main(String[] args) {
        //创建一个顺序表对象
        ContiguousList contiguousList = new ContiguousList();
        //初始化顺序表，分配长度为10，当前长度为0；
        InitList(contiguousList);
        //往顺序表中随便插入10个元素，直到数组满了。
        for (int i = 0; i < contiguousList.MaxSize-1; i++) {
            contiguousList.data[i]=1;
            contiguousList.length++;
        }
        //增加5个元素的长度，其实是直接申请另外一片内存空间
        IncreaseSize(contiguousList, 5);
    }

    //增加动态数组的长度
    private static void IncreaseSize(ContiguousList contiguousList, int len) {
        int[] p = contiguousList.data;
        contiguousList.data=new int[InitSize+len];
        for (int i = 0; i < contiguousList.length; i++) {
            contiguousList.data[i] = p[i];
        }
        contiguousList.MaxSize= contiguousList.MaxSize+len;
        //回收p，赋值为null后，会自动被回收
        p=null;
    }

    private static void InitList(ContiguousList contiguousList) {
        //用new申请一片连续的存储空间
        contiguousList.data = new int[InitSize];
        contiguousList.length = 0;
        contiguousList.MaxSize = InitSize;
    }
}
