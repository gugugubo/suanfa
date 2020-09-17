package bobo.algo.niuke.zifuchuan;

/**
 * @Author 古春波
 * @Description 输入一个字符串，打印出该字符串中字符的所有排列。
 * @Date 2020/9/16 22:59
 * @Version 1.0
 **/
public class timu38 {


    /**
     * 回溯法
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        
        
        return null;
    }
    
    
    
    
   /* public String[] recur (String s ,int l, int r){
        
        if ( r< l){
            return null;
        }
        
        Character start = s.charAt(l);
        String[] recur = recur(s.substring(l + 1, r + 1), l + 1, r);
        String[] result;
        for (int i = 0; i< recur.length ; i++){
            String s1 = recur[i];
            for (int j =0 ; j < s1.length(); j++){
                StringBuffer stringBuffer = new StringBuffer(s1);
                StringBuffer insert = stringBuffer.insert(j, start);
                result[];
            }
        }

    }*/
}
