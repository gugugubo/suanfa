package com.gdut.gcb.likou.zifuchuan;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/23 9:22
 * @Version 1.0
 **/
public class timu459 {


    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        boolean match ;
        int k = 0;
        // 遍历所有可能的前缀
        for(int i=1; i<=length/2 ; i++){
            if (length%i==0){
                match = true;
                // 判断某个前缀是否可能
                for(int j=i; j<length; j++){
                    char c = s.charAt(j);
                    char c1 = s.charAt(j - i);
                    if( c!= c1){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        timu459 timu459 = new timu459();
        timu459.repeatedSubstringPattern("aba");
    }
}
