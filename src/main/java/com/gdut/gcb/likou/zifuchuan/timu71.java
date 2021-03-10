package com.gdut.gcb.likou.zifuchuan;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 71. 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 *     始终以斜杠 '/' 开头。
 *     两个目录名之间必须只有一个斜杠 '/' 。
 *     最后一个目录名（如果存在）不能 以 '/' 结尾。
 *     此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 *
 * 返回简化后得到的 规范路径 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 15:18
 * @Version 1.0
 **/
public class timu71 {


    /**
     * 参考题解
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i=0 ;i<split.length; i++){
            String s = split[i].trim();
            if (s==null || s.length() == 0 || s.equals(".")){
                continue;
            }

            if (s.equals("..")) {
                // 必须要判断栈是否为空
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        String ans = "";
        // 巧妙的反向构建结果
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        // 最后还要判断是否为空
        return ans.length() == 0 ? "/" : ans;
    }
    
}
