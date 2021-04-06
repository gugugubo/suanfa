package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/4/1 10:57
 * @Version 1.0
 **/
public class timu224 {

    public static void main(String[] args) {
        timu224 timu224 = new timu224();
        int calculate3 = timu224.calculate3("1+2+(3-(4+5))");
//        int calculate = timu224.calculate("1+2+(3-(4+5))");
//        int calculate2 = calculate2("-1+2+(3-(4+5))");
//        System.out.println(calculate);
//        System.out.println(calculate2);
        System.out.println(calculate3);
    }


    //    链接：https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/
    public int calculate3(String s) {
        int ans=0;
        char[] str=s.toCharArray();
        int len=str.length;
        Stack<Integer> st_num=new Stack<>();
        Stack<Integer> st_signs=new Stack<>();
        int sign=1;//正负号,运算符号
        for(int i=0;i<len;i++){
            if(str[i]==' ') continue;
            if(str[i]=='+'||str[i]=='-') sign=str[i]=='+'? 1:-1;
            else if(str[i]>='0'&&str[i]<='9'){//数字
                int num=str[i]-'0';
                while(i<len-1&&str[i+1]>='0'&&str[i+1]<='9'){//将这个数字找完
                    num=num*10+(str[++i]-'0');
                }
                ans+=sign*num;
            }else if(str[i]=='('){//左括号，暂存结果
                st_num.push(ans);
                st_signs.push(sign);
                ans=0;
                sign=1;
            }
            else ans=st_num.pop()+ans*st_signs.pop();//右括号更新结果
        }
        return ans;
    }



//    public static int calculate2(String s) {
////        计算结果，部分计算结果，括号中计算结果
//        int res = 0;
////        当前的数字，例如：1+23中的1或者23
//        int num = 0;
////        符号，加号(+1)或者减号(-1)
//        int sign = 1;
////        当右括号时，用于存储计算结果
//        Stack<Integer> stack = new Stack<>();
//
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//
//        for (int i = 0; i < len; i++) {
//            char c = chars[i];
////            如果当前字符为' '，则直接continue
//            if (c == ' ') {
//                continue;
//            }
////            如果当前字符是一个数字，则用num进行记录
////            当前有可能是一个>9的数字，所以需要num = num * 10 + c - '0'
//            if (c >= '0' && c <= '9') {
//                num = num * 10 + c - '0';
////                判断当前数字是否已经取完
////                例如：123+4，只有当取到+时，才能确定123为当前的num
//                if (i < len-1 && '0' <= chars[i+1] && chars[i+1] <= '9') {
//                    continue;
//                }
////            如果当前字符为'+'或者'-'
//            } else if (c == '+' || c == '-') {
////                将num置为0，用来存放当前符号(+/-)之后的数字
//                num = 0;
////                如果当前符号为+，则sign为+1
////                如果当前符号为-，则sign为-1
//                sign = c=='+' ? 1 : -1;
////            如果当前符号为'('
//            } else if (c == '(') {
////                例如当前表达式为：'123+(...)'
////                则将res:123，入栈
//                stack.push(res);
////                则将sign:+，入栈
//                stack.push(sign);
////                同时res置为0，用来保存()中的计算结果
//                res = 0;
////                sign置为初始状态，为1
//                sign = 1;
////            如果当前符号为')'
//            } else if (c == ')') {
////                '('前边的符号出栈
//                sign = stack.pop();
////                将num替换为括号中的计算结果
//                num = res;
////                将res替换为括号前边的计算结果
//                res = stack.pop();
//            }
////            每遍历一次，得到一个res
//            res += sign * num;
//        }
//        return res;
//    }
//
//    /**
//     *     链接：https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
//     * @param s
//     * @return
//     */
//    public int calculate(String s) {
//        Deque<Integer> ops = new LinkedList<Integer>();
//        ops.push(1);
//        int sign = 1;
//
//        int ret = 0;
//        int n = s.length();
//        int i = 0;
//        while (i < n) {
//            if (s.charAt(i) == ' ') {
//                i++;
//            } else if (s.charAt(i) == '+') {
//                sign = ops.peek();
//                i++;
//            } else if (s.charAt(i) == '-') {
//                sign = -ops.peek();
//                i++;
//            } else if (s.charAt(i) == '(') {
//                ops.push(sign);
//                i++;
//            } else if (s.charAt(i) == ')') {
//                ops.pop();
//                i++;
//            } else {
//                long num = 0;
//                while (i < n && Character.isDigit(s.charAt(i))) {
//                    num = num * 10 + s.charAt(i) - '0';
//                    i++;
//                }
//                ret += sign * num;
//            }
//        }
//        return ret;
//    }
}
