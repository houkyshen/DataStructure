package com.houky.linearlist;

import java.util.Arrays;

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
        for (int i = 0; i < contiguousList.MaxSize; i++) {
            contiguousList.data[i] = 1;
            contiguousList.length++;
        }
        //增加5个元素的长度，其实是直接申请另外一片内存空间
        //IncreaseSize(contiguousList, 5);
        insert(contiguousList, 520, 1);
        delete(contiguousList,1);
        System.out.println(contiguousList);
    }

    //增加动态数组的长度
    private static void IncreaseSize(ContiguousList contiguousList, int len) {
        int[] p = contiguousList.data;
        contiguousList.data = new int[InitSize + len];
        for (int i = 0; i < contiguousList.length; i++) {
            contiguousList.data[i] = p[i];
        }
        contiguousList.MaxSize = contiguousList.MaxSize + len;
        //回收p，赋值为null后，会自动被回收
        p = null;
    }

    private static void InitList(ContiguousList contiguousList) {
        //用new申请一片连续的存储空间
        contiguousList.data = new int[InitSize];
        contiguousList.length = 0;
        contiguousList.MaxSize = InitSize;
    }

    //插入数据
    private static boolean insert(ContiguousList contiguousList, int value, int index) {
        //判断插入数据之后是否超出了最大容量，超出就进行扩容
        if (index > contiguousList.MaxSize - 1) {//1、若插入的位置大于最大容量，则进行扩容
            IncreaseSize(contiguousList, index - contiguousList.MaxSize + 1);
        }else if(contiguousList.length== contiguousList.MaxSize){//2、若容量已经满了，就进行双倍扩容
            IncreaseSize(contiguousList, contiguousList.MaxSize);//双倍扩容
        }
        //插入数据
        for (int i = contiguousList.length; i > index; i--) {
            //把已有值右挪一个位置，直到插入的位置
            contiguousList.data[i] = contiguousList.data[i - 1];
        }
        contiguousList.data[index] = value;
        return true;
    }

    //删除数据
    private static boolean delete(ContiguousList contiguousList, int index) {
        //判断index是否超出最大索引，是的话抛出异常
        if (index>= contiguousList.length){
            System.out.println("索引超出最大值了，删除失败");
            return false;
        }
        //把右边的值左挪一个位置
        for (int i = index; i < contiguousList.length; i++) {
            contiguousList.data[i] = contiguousList.data[i + 1];
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContiguousList{" +
                "data=" + Arrays.toString(data) +
                ", MaxSize=" + MaxSize +
                ", length=" + length +
                '}';
    }
}
