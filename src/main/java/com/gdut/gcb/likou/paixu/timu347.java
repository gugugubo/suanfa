package com.gdut.gcb.likou.paixu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 古春波
 * @Description 出现频率最多的 k 个元素
 * @Date 2020/9/2 23:40
 * @Version 1.0
 **/
public class timu347 {

    /**
     * 使用桶排序
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 统计各个元素出现的次数，使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        
        // 利用桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List[] lists = new List[nums.length + 1];
        for (Integer key: map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (lists[i] == null){
                lists[i] = new ArrayList();
            }
            lists[i].add(key);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=nums.length; i>=0 && res.size()<k;i--){
            if (lists[i] == null){
                continue;
            }
            res.addAll(lists[i]);    
        }
        System.out.println(res.toString());
        int[] ints = new int[res.size()];
        for (int i =0;i<res.size();i++){
            ints[i] = res.get(i);
        }
        System.out.println(ints);
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {
                1
        };
        List<Integer> integers = topKFrequent(ints, 2);
        System.out.println(integers);
    }
    
}
