package bobo.algo.niuke.sousuo;

/**
 * @Author 古春波
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/17 21:36
 * @Version 1.0
 **/
public class timu11 {


    /**
     * 暴力解法
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int k = numbers[0];
        for(int i = 1 ; i< numbers.length ; i++){
            if (numbers[i] < k){
                return numbers[i];
            }else {
                k = numbers[i];
            }
        }

        return numbers[0];
    }


    /**
     * 看下面的视频
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        
        int left = 0 ;
        
        int right = numbers.length -1;
        
        
        while(left < right){
            
            int mid = (left + right) / 2;
            
            if (numbers[mid] < numbers[right]){
                right = mid;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else {
                right --;
            }
            
        }
        
        return numbers[left];
        
    }
    
    
    

    public static void main(String[] args) {
        new timu11().minArray(new int[]{2,2,2,0,1});
    }
}