package bobo.algo;

import java.util.*;

/**
 * 使用大顶堆来对数组进行排序，这里需要开辟另外一个与待排序数组相同大小的数组空间来进行排序
 * 先将待排序的数组一个个插入到一个新堆中，这个构建出来的堆就是有序的
 * 然后再从堆中一个个取出来
 */
public class HeapSort1 {

    // 我们的算法类不允许产生任何实例
    private HeapSort1(){}

    // 对整个arr数组使用HeapSort1排序
    // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            maxHeap.insert(arr[i]);

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.HeapSort1", arr);

        return;
    }
}
