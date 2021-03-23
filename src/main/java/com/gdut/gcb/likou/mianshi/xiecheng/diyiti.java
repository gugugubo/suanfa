package com.gdut.gcb.likou.mianshi.xiecheng;

/**
 * @Author 古春波
 * @Description 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 为了寻找最佳拍档，我们定义两人名字的缘分值：两人名字左对齐后，对应位置字的拼音的缘分值之和。对于两个拼音s1、s2，通过剔除一些字符使得留下的子串一模一样，被剔除字符之和的最小值即为两个拼音的缘分值。求给定两人名字的缘分值。
 *
 *
 *
 * 输入描述
 * 输入数据有2组，每行一个名字，名字各字间用空格分隔。2<=字的拼音长度<=10，2<=名字字数<=20
 *
 * 输出描述
 * 对于每个测试实例，要求输出缘分值 ; 每个测试实例的输出占一行
 *
 *
 * 样例输入
 * Zhang San
 * Zhan Ai
 * 样例输出
 * 563
 * 
 * 字符之和是指对应的ASCII值之和。样例中，Zhang和Zhan去掉‘g’后，剩余子串相等，因此第一个字的缘分值为asc(‘g’)=103；
 * 而San和Ai则需全部删除San和Ai，其缘分值为asc(“San”)+asc(“Ai”)=290+170=460。
 * 因此Zhang San和Zhan Ai的缘分值为103+460=563。
 * 边界场景，一人名字较长者，譬如，Ali Ba Ba和Xie Cheng，那最后一个Ba需要全部剔除掉。
 * @Date 2021/3/18 19:06
 * @Version 1.0
 **/
public interface diyiti {


    static int calcSimilarity(String name1, String name2) {
        int sum = 0;
        String[] s1 = name1.split(" ");
        String[] s2 = name2.split(" ");
        
        if (s1.length > s2.length){
            for (int i=0; i< s1.length - s2.length; i++){
                sum += getSum(s1[s2.length+i]);
            }
        }else {
            for (int i=0; i< s2.length - s1.length; i++){
                sum += getSum(s2[s1.length+i]);
            }
        }
        for (int i=0; i<Math.min(s2.length, s1.length); i++){
            sum += calcSimilarity2(s1[i], s2[i]);
        }
        return sum;
        
    }
    
    public static int getSum(String s){
        int sum = 0;
        for (int i=0; i<s.length() ;i++){
            sum += s.charAt(i);
        }
        return sum;
    }

    static int calcSimilarity2(String name1, String name2) {
        // TODO 处理名字较长的一个人

        // dp[i][j] 表示的意义为name1的i..   和  name2 的 j..的缘分值
        int dp[][] = new int[name1.length()+1][name2.length()+1];
        
        // 如果name2为空
        for (int i=name1.length() -1; i>=0; i--){
            dp[i][name2.length()] = dp[i+1][name2.length() ] + name1.charAt(i);
        }

        // 如果 name1 为空
        for (int i=name2.length()-1; i>=0; i--){
            dp[name1.length()][i] =  dp[name1.length()][i+1] + name2.charAt(i);
        }
        
        for(int i=name1.length()-1; i>=0; i--){
            for (int j=name2.length()-1; j>=0  ; j--){
                if (name1.charAt(i) == name2.charAt(j)){
                    dp[i][j] =  dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j] + name1.charAt(i), dp[i][j+1] + name2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }

    
    
    
    

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = str1.substring(4);
        System.out.println(str2);
        String str3 = new String(str2);
        String str4 = new String(str2.toCharArray());
        

//        int i = diyiti.calcSimilarity("Zhang San", "Zhan Ai");
//        System.out.println(i);
    }
}
