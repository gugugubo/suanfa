package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 1095. 山脉数组中查找目标值
 * （这是一个 交互式问题 ）
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 *     A[0] < A[1] < ... A[i-1] < A[i]
 *     A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/9 10:55
 * @Version 1.0
 **/
public class timu1095 {


    // 特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环

    /**下面是答案
     *     链接：https://leetcode-cn.com/problems/find-in-mountain-array/solution/shi-yong-chao-hao-yong-de-er-fen-fa-mo-ban-python-/
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        // 步骤 1：先找到山顶元素所在的索引
        int mountaintop = findMountaintop(mountainArr, 0, size - 1);
        // 步骤 2：在前有序且升序数组中找 target 所在的索引
        int res = findFromSortedArr(mountainArr, 0, mountaintop, target);
        if (res != -1) {
            return res;
        }
        // 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return findFromInversedArr(mountainArr, mountaintop + 1, size - 1, target);
    }

    private int findMountaintop(MountainArray mountainArr, int l, int r) {
        // 返回山顶元素
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 取左中位数，因为进入循环，数组一定至少有 2 个元素
            // 因此，左中位数一定有右边元素，数组下标不会发生越界
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 如果当前的数比右边的数小，它一定不是山顶
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return l;
    }

    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在前有序且升序数组中找 target 所在的索引
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }

    private int findFromInversedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在后有序且降序数组中找 target 所在的索引
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 与 findFromSortedArr 方法不同的地方仅仅在于由原来的小于号改成大于好
            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }

 
    
    /**
     * 自己做的，不满足题意，只考虑了找到下标，没考虑找到最小的下标，
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray2(int target, MountainArray mountainArr) {
        int i =0; int j = mountainArr.length();
        while ( i< j){
            int mid = i + (j-i)/2;
            if (mountainArr.get(mid) == target){
                return mid;
            }
            else if (mountainArr.get(mid) > mountainArr.get(mid+1)){
                if (mountainArr.get(mid) > target){
                    j = mid -1;
                }else {
                    i = mid +1;
                }
            }
            else if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                if (mountainArr.get(mid) > target){
                    i = mid + 1;
                }else {
                    j = mid-1;
                }
            }
        }
        if (i==mountainArr.length()){
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        timu1095 timu1095 = new timu1095();
        int inMountainArray = timu1095.findInMountainArray(3, new MountainArray());
        System.out.println(inMountainArray);
    }


    static class MountainArray {
        int[] ints = new int[]{1,2,3,4,5,3,1};
        public int get(int index) {
            return ints[index];
        }

        public int length() {
            return 7;
        }
    }
   
}

