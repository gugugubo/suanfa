package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 227. 基本计算器 II给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Date 2021/4/1 17:23
 * @Version 1.0
 **/
public class timu227 {


    public static void main(String[] args) {
        timu227 timu227 = new timu227();
        timu227.calculate("5+3*4-40/8-9");
    }
    
    /**
     * 链接：https://leetcode-cn.com/problems/basic-calculator-ii/solution/dan-zhan-jian-ji-xiao-lu-by-cyingenohalt-yjh9/
     * @param s
     * @return
     * 
     * 实时计算的窗口是上一个操作符和前两个操作数
     */
    public int calculate(String s) {
        int len=s.length();
        char[] str=s.toCharArray();
        Stack<Integer> st_num=new Stack<>();
        char op='#';         //记录乘除符号
        int ans=0,sign=1;    //记录加减符号
        for(int i=0;i<len;i++){
            if(str[i]==' ') continue;
            if(str[i]>='0'&&str[i]<='9'){
                int num=str[i]-'0';
                while(i<len-1&&str[i+1]>='0'&&str[i+1]<='9')  //找完这个数
                    num=num*10+(str[++i]-'0');
                if(op!='#'){                                //如果之前有乘除符号
                    if(op=='*')num*=st_num.pop();           //则将这个数运算之后，再重新进栈
                    else num=st_num.pop()/num;
                    op='#';                                //重置乘除符号
                }
                st_num.push(num);
            }
            else if(str[i]=='*'||str[i]=='/') op=str[i];  //更新乘除符号
            else{                                         //遇到加减符号则可以直接更新ans了
                ans+=st_num.pop()*sign;
                sign=str[i]=='+'?1:-1;   //更新加减符号
            }
        }
        return ans+st_num.pop()*sign;   //sign更新后，还有一次未计算
    }


}
