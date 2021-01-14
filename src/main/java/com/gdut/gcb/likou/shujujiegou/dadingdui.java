package com.gdut.gcb.likou.shujujiegou;

/**
 * @Author 古春波
 * @Description 实现一个大顶堆
 * @Date 2021/1/12 19:07
 * @Version 1.0
 **/
public class dadingdui {

    /**
     * 使用数组建立一个二叉堆
     */
    int[] heap ;

    /**
     * 堆的容量大小
     */
    int capital;

    /**
     * 堆中实际的元素的个数
     */
    int count;
    
    public dadingdui(int capital){
        this.heap = new int[capital];
        this.capital = capital;
    }

    /**
     * 像最大堆中插入一个新的元素 item
     * @param item item
     */
    public void insert(int item){
        if (count >= capital){
            return;
        }
        heap[++count] = item;
        shipUp(count);
    }

    /**
     *  从最大堆中取出堆顶元素, 即堆中所存储的最大数据
     * @return
     */
    public int extractMax(){
        if (count<1){
            return -1;
        }
        int result = heap[1];
        swap(1,count);
        count--;
        shipDown(1);
        return result;
    }

    public void shipUp(int index){
        while (index > 1 &&heap[index/2] < heap[index] ){
            swap(index/2, index);
            index = index / 2;
        }
    }
    
    public void shipDown(int index){
        while (2*index<=count){
            if (2*index+1>count && heap[index] < heap[2*index]){
                swap(index, 2*index);
                index = 2*index;
            }else {
                int max ;
                if (heap[2*index] > heap[2*index+1]){
                    max = 2*index;
                }else {
                    max = 2* index + 1;
                }
                if (heap[index] < heap[max]){
                    swap(index, max);
                }
                index = max;
            }
        }
    }
    
    public void swap(int i , int j){
        int a = heap[i];
        heap[i] = heap[j];
        heap[j] = a;
    }
}
