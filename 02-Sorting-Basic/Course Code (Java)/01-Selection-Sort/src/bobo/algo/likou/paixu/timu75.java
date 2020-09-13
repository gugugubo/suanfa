package bobo.algo.likou.paixu;

/**
 * @Author 古春波
 * @Description 75. 颜色分类   https://leetcode-cn.com/problems/sort-colors/
 * 解法参考快速排序的三路排序算法
 * 时间复杂度 :由于对长度 N的数组进行了一次遍历，时间复杂度为O(N) 。
 * 空间复杂度 :由于只使用了常数空间，空间复杂度为O(1) 。
 * @Date 2020/9/2 21:05
 * @Version 1.0
 **/
public class timu75 {
    // arr[0...lt] == 0
    // arr[gt...n-1] == 2
    // arr[lt+1...i) == 1

    public static void sortColors(int[] nums) {
        
        int n = nums.length;
        int lt = -1;     
        int gt = n;    
        int i = 0;    
        while( i < gt ){
            if( nums[i] == 0 ){
                swap( nums, i, lt+1);
                i ++;
                lt ++;
            }
            else if( nums[i]== 2 ){
                swap( nums, i, gt-1);
                gt --;
            }
            else{ 
                i ++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int node = arr[j];
        arr[j] = arr[i];
        arr[i] = node;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{
                2,0,2,1,1,0
        };
        sortColors(ints);      
    }

}
