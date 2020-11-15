package bobo.algo.niuke.zifuchuan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 古春波
 * @Description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @Date 2020/9/16 21:57
 * @Version 1.0
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 **/
public class timu50 {


    /**
     * 使用有序的LinkedHashMap（按照加入顺序有序）  如果使用普通的HashMap那么不是有序的
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        
        for (int i =0 ;i < s.length() ; i ++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), true);
            }else {
                map.put(s.charAt(i),false);
            }
        }
        char result = ' ';
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            if (map.get(character) == true) {
                result = character;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String testString = "leetcode";
        new timu50().firstUniqChar(testString);
    }
}
