package com.gdut.gcb.likou.zijie.zifuchuan;

/**
 * @Author 古春波
 * @Description 36进制由0-9，a-z，共36个字符表示。
 *
 * 要求按照加法规则计算出任意两个36进制正整数的和，如1b + 2x = 48  （解释：47+105=152）
 *
 * 要求：不允许使用先将36进制数字整体转为10进制，相加后再转回为36进制的做法
 * @Date 2021/4/4 15:17
 * @Version 1.0
 **/
public class jinzhi {

    char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    int getInt(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return ch - 'a' + 10;
        }
    }

    String add36Strings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        int x, y;
        StringBuffer res = new StringBuffer();
        while (i >= 0 || j >= 0 || carry>0) {
            x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int temp = x + y + carry;
            res.append(getChar(temp % 36));
            carry = temp / 36;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        jinzhi jinzhi = new jinzhi();
        String a = "1b", b = "2x", c;
        c = jinzhi.add36Strings(a, b);
        System.out.println(c);
    }
    
 

}
