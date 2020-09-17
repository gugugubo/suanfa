package bobo.algo.niuke.zifuchuan;

/**
 * @Author 古春波
 * @Description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/16 19:29
 * @Version 1.0
 **/
public class timu20 {
    
    int index = 0;

    /**
     * 使用迭代解决问题  看了思路之后自己敲的
     * 整数部分必须为一个符号位和若干个数字位
     * 小数部分为若干个数字为
     * e/E后为一个符号位和若干个数字位
     * 有了整数位可以没有小数位，有了小数位可以没有整数位
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0){
            return false;
        }
        boolean result  = isSignInt(s);
        
        if (index < s.length() && s.charAt(index) == '.'){
            index  ++;
            boolean anInt = isInt(s);
            result  = anInt || result;
        }
        
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')){
            index  ++;
            boolean anInt = isSignInt(s);
            result =  result && anInt;
        }
        return result && index == s.length();
    }

    public boolean isSignInt(String s) {
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            index++;
        }
        return isInt(s);
    }

    public boolean isInt(String s) {
        int val = index;
        while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            index ++;
        }
        if (index > val){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String testString = "e";
        timu20 test = new timu20();
        test.isNumber(testString);
    }
}
