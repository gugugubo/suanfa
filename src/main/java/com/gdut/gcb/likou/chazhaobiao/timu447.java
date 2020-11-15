package com.gdut.gcb.likou.chazhaobiao;

import com.sun.javaws.security.AppPolicy;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/29 9:24
 * @Version 1.0
 **/
public class timu447 {

    /**
     * 使用查找表，找出其它点到点i的距离，如果到i的同一距离存在大于等于两个节点，那么存在解
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * @param points 一个二维数组
     * @return 种数
     */
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for(int i = 0; i< points.length; i++){

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0 ; j< points.length; j ++){
                if (j != i){
                    int distance1 = distance(points[i], points[j]);
                    if (map.containsKey(distance1)){
                        map.put(distance1, map.get(distance1) +1 );
                    }else {
                        map.put(distance1, 1 );
                    }
                }
            }
            
            for (Integer distance : map.keySet()){
                if (map.get(distance) >= 2){
                    result += map.get(distance) * ( map.get(distance)  -1 );
                }
            }
            
        }
        
        return result;
        
    }

    /**
     * 计算两点距离的平方
     * @param pos1 第一个点
     * @param pos2 第二个点
     * @return
     */
    public int distance(int[] pos1 , int[] pos2){
        return (pos1[0] - pos2[0]) * (pos1[0] - pos2[0]) +
                (pos1[1] - pos2[1]) * (pos1[1] - pos2[1]);
    }
}
