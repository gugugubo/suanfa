package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 
 * @Date 2021/4/4 23:13
 * @Version 1.0
 **/
public class test {


    public static void main(String[] args) {
        test test = new test();
        test.binaryToDecimal(3);
    }

    
    // 十进制转二进制
    public void binaryToDecimal(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }
    
}
