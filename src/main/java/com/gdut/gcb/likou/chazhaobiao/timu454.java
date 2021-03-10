package com.gdut.gcb.likou.chazhaobiao;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/29 8:54
 * @Version 2.0
 **/
public class timu454 {


    /**
     * 使用查找表解决问题，将C，D各个数的和放入查找表中
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n^2)
     * 查找表重要的就是要找出将什么放入表中
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map  = new HashMap<>();

        int result = 0; 
        
        for (int i = 0 ; i < C.length; i ++){
            for (int j = 0; j< D.length ; j++){
                int num = C[i] + D[j];
                if (map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }else {
                    map.put(num, 1);
                }
            }
        }
        
        for (int i = 0 ; i< A.length ; i++){
            for (int j = 0 ;j < B.length ; j++){
                int num = A[i] + B[j];
                if (map.containsKey(0-num)){
                    result += map.get(0-num);
                }
            }
        }

        return result;
    }
    
}
