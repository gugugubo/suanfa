package bobo.algo;

import java.util.*;

/**
 * 与HeapSort1 的不同就是，这里将待排序的数组一次性加入到新建的数组中，然后再进行堆排序
 * 然后再从堆中一个个取出来
 */
public class HeapSort2 {

    // 我们的算法类不允许产生任何实例
    private HeapSort2(){}

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }

    // 测试 HeapSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.HeapSort2", arr);

        return;
    }
}
