package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 *     如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * @Date 2020/11/9 17:42
 * @Version 1.0
 **/
public class timu744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0 ; int right = letters.length;
        
        // 我认为下面这个while循环每次跳出的时候必定是  left == right
        // 因为 进入的时候是left < right , 那么left变大只可能 mid + 1; 除非left==right, 那么left = mid + 1 是不可能大于 right 的, 但是前提条件已经约束了 left < right 
        while (left < right){
            int mid = left + (right - left) /2 ;
            
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        
        char res =left<letters.length && letters[left] > target? letters[left] :  letters[0];
        
        return res;
    }


    /**
     * 使用等于号也是可以的
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0 ; int right = letters.length -1;
        
        while (left <= right){
            int mid = left + (right - left) /2 ;
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

        char res =left<letters.length &&  letters[left] > target? letters[left] :  letters[0];
        return res;
    }
 
    public static void main(String[] args) {
        char[] ints = new char[]{'c','f','j','k'};
        char[] ints2 = new char[]{'f'};
        char c = new timu744().nextGreatestLetter(ints, 'f');
        char c2 = new timu744().nextGreatestLetter(ints2, 'f');
        System.out.println(c);
    }
}
