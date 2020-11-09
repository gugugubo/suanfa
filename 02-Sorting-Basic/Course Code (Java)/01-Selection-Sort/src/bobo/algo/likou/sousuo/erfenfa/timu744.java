package bobo.algo.likou.sousuo.erfenfa;

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
        int left = 0 ; int right = letters.length -1 ;
        
        
        while (left < right){
            int mid = left + (right - left) /2 ;
            
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        
        char res = letters[left] > target? letters[left] :  letters[0];
        
        return res;
    }

    public static void main(String[] args) {
        char[] ints = new char[]{'c','f','j','k'};
        char c = new timu744().nextGreatestLetter(ints, 'f');
        System.out.println(c);
    }
}
