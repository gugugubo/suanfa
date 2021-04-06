package com.gdut.gcb.likou.shujujiegou;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Author 古春波
 * @Description 460. LFU 缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 *     LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 *     int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 *     void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 *
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/2 19:32
 * @Version 1.0
 **/
public class timu460 {

  


    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public timu460(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    
    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }else {
            // 修改频次
            increaseFreq(key);
            return keyToVal.get(key);
        }
    }

  


    public void put(int key, int val) {
        if (this.cap <= 0 ){return;}
        // 如果key已经存在，那么修改val就行了
        if (keyToVal.containsKey(key)){
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }
        
        if (this.cap<=keyToVal.size()){
            removeMinFreqKey();
        }
        
        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
        
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> integers = freqToKeys.get(this.minFreq);

        Integer next = integers.iterator().next();
        integers.remove(next);
        
        if (freqToKeys.get(this.minFreq).isEmpty()){
            freqToKeys.remove(freqToKeys.get(this.minFreq));
        }
        /* 更新 KV 表 */
        keyToVal.remove(next);
        /* 更新 KF 表 */
        keyToFreq.remove(next);
    }


    private void increaseFreq(int key) {
        // 需要将key对应的频度提高1，同时将原来频度的列表将key取出来，将key放到原来频度加1的列表中

        int oldFre = keyToFreq.get(key);
        keyToFreq.put(key, oldFre +1);

        freqToKeys.get(oldFre).remove(key);
        freqToKeys.putIfAbsent(oldFre + 1, new LinkedHashSet<>());
        freqToKeys.get(oldFre+1).add(key);
        if (freqToKeys.get(oldFre).isEmpty()){
            freqToKeys.remove(freqToKeys.get(oldFre));
            if (this.minFreq == oldFre){
                this.minFreq ++;
            }
        }
    }   
    
}
