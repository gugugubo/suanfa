package bobo.algo;

import java.util.*;

/**
 * 不用递归实现归并排序,注意第二层排序中,对于边界的控制      for (int i = 0; i < n - sz; i += sz+sz)  
 * 还有merge操作中的边界控制    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));  
 */
public class MergeSortBU{

    // 我们的算法类不允许产生任何实例
    private MergeSortBU(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
        // 第一轮排序每次只看一个元素
//        for (int sz = 1; sz < n; sz *= 2)
        //i < n - sz 即，i+sz<n 保证了i+sz是在集合区域内的.如果i+sz>=n 说明只剩下一部分了,那么这个剩下这一部分的部分已经是有序的了,就不用再进行merge操作了
//            for (int i = 0; i < n - sz; i += sz+sz)  
//                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));  
        // Merge Sort Bottom Up 优化
        // 优化一：对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i+= sz+sz  )
                // 优化二：对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }

    // 测试 MergeSort BU
    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        // 关于这部分陷阱，推荐看我的《玩转算法面试》课程，第二章：《面试中的复杂度分析》：）
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr);

        return;
    }
}