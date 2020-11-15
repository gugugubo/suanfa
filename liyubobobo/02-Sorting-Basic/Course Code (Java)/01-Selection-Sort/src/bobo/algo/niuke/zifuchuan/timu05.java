package bobo.algo.niuke.zifuchuan;

/**
 * @Author 古春波
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Date 2020/9/16 19:03
 * @Version 1.0
 **/
public class timu05 {


    /**
     * 直接使用暴力迭代
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c: s.toCharArray()){
            if (c == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
        
        
    }
}
