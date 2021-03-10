package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/7 15:36
 * @Version 1.0
 **/
public class timu189 {


    /**
     * nums = "----->-->"; k =3
     * result = "-->----->";
     *
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"
     * this visualization help me figure it out :)
     */
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums,int a,int b){
        //用双指针好了
        int i=a,j=b;
        while(i<j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
}
