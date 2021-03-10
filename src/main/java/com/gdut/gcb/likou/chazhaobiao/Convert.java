package com.gdut.gcb.likou.chazhaobiao;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/1/26 15:05
 * @Version 1.0
 **/
public class Convert {

    String str ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    StringBuilder result = null;


    public int ConvertTo10(String num){
        char[] chars = num.toCharArray();
        int number=0;
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            int index = str.indexOf((ch+"").toUpperCase());
            for(int j=0;j<chars.length-i-1;j++){
                index = index*36;
            }
            number = number+index;
        }
        return number;
    }

    public String tenTo36(int num){
        result = new StringBuilder();
        while (num >= 36) {
            char c = str.charAt(num % 36);
            result = result.insert(0, c+"");
            num /= 36;
        }
        if (num >= 0) {
            result = result.insert(0, str.charAt(num % 36));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        long r9 = convert.ConvertTo10("R9");
        String s = convert.tenTo36(52360);
        System.out.println(r9);
        System.out.println(s);
    }

    public static int bsearch(int[] M,int n) {
        int start = 0;
        int end = M.length-1;
        while(start <= end) {
            int	middle = (start + end)/2;
            if(n < M[middle]) {
                end = middle-1;
            }else if(n > M[middle]) {
                start = middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    
    
    
    
}
