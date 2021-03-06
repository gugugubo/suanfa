package bobo.algo;

import java.util.*;

/**
 * 增加了测试类生成随机数组进行测试，和打印数组工具类
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                // 使用compareTo方法比较两个Comparable对象的大小
                if( arr[j].compareTo( arr[minIndex] ) < 0 )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

  
        int rangeR = 3;
        int rangeL = 0;
        double random = Math.random();
        System.out.println(random);
        double v = random * (rangeR - rangeL + 1);
        System.out.println(v);
        System.out.println((int)v);
        Integer integer = new Integer((int) (v + rangeL));
        System.out.println(integer);

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);

        return;
    }
}
