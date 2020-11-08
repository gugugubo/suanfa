package bobo.algo.likou.shaungzhizhen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author 古春波
 * @Description 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 *
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/8 23:45
 * @Version 1.0
 **/
public class timu345 {


    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>( Arrays.asList('a','e','i','o','u','A','E','O','U','I')) ;
        int i = 0 ; int j = s.length() -1;
        char[] result = new char[s.length()];
        while (i <= j){
            char c = s.charAt(i);
            char c1 = s.charAt(j);
            if (!hashSet.contains(c)){
                result[i ++] = c;
            }else if (!hashSet.contains(c1)){
                result[j --] = c1;
            }else {
                result[i ++] = c1;
                result[j --] = c;
            }
        }
        
        return new String(result);
    }

    public static void main(String[] args) {
        String s = new timu345().reverseVowels("leetcode");
        System.out.println(s);
    }
}
