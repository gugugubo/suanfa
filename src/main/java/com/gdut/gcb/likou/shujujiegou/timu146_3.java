package com.gdut.gcb.likou.shujujiegou;

import java.util.LinkedHashMap;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/1/10 17:36
 * @Version 1.0
 **/
public class timu146_3 {

    public static void main(String[] args) {
        timu146_3 lruCache = new timu146_3(2);
        lruCache.put(2,6);
        lruCache.put(1,5);
        lruCache.put(1,2);
        int i = lruCache.get(2);
        System.out.println(2);
        
        lruCache.put(1,1);
        lruCache.put(2,2);
        int i1 = lruCache.get(1);
        System.out.println(i1);
        lruCache.put(3,3);
        int i2 = lruCache.get(2);
        System.out.println(i2);
        lruCache.put(4,4);
        int i3 = lruCache.get(1);
        System.out.println(i3);
        int i4 = lruCache.get(3);
        System.out.println(i4);
        int i5 = lruCache.get(3);
        System.out.println(i5);
    }

    LinkedHashMap<Integer,Integer> map ;
    int capacity ;

    public timu146_3(int capacity) {
        map  = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }else {
            Integer remove = map.remove(key);
            map.put(key,remove);
            return remove;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else {
            if (map.size() ==  this.capacity){
                // 获取链表的第一个值
                Integer first = map.keySet().iterator().next();
                map.remove(first);
            }
            map.put(key,value);
        }
    }

}

