package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/10 20:04
 * @Version 1.0
 **/
// 解法参考：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&scene=21#wechat_redirect
public class timu297 {

    //============================= 以下是使用前序遍历进行的
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serRecur(root, buffer);
        return buffer.toString();
    }

    
    public void serRecur(TreeNode root, StringBuffer buffer){
        if (root==null){
            buffer.append("#").append(",");
            return;
        }
        buffer.append(root.val).append(",");
        serRecur(root.left, buffer);
        serRecur(root.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (int i=0; i<split.length ;i++){
            list.add(split[i]);
        }
        TreeNode treeNode = desRecur(list);
        return treeNode;
    }
    
    public TreeNode desRecur(LinkedList<String> list){
        if (list.isEmpty()){
            return null;
        }

        String s = list.removeFirst();
        if (s.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = desRecur(list);
        root.right = desRecur(list);
        return root;        
    }

    public static void main(String[] args) {
        timu297 timu297 = new timu297();
        String[] strings = new String[]{"1","2","3","null","4","null","null","null","null"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        String serialize = timu297.serialize(treeNode);
        System.out.println(serialize);
        
        
        TreeNode deserialize = timu297.deserialize(serialize);
        String serialize2 = timu297.serialize2(treeNode);
        System.out.println(serialize2);
        TreeNode treeNode1 = timu297.deserialize2(serialize2);


        String[] strings3 = new String[]{"1","2","3","null","null","4","5"};
        TreeNode treeNode3 = util.stringToTreeNode(strings3);
        String serialize3 = timu297.serialize2(treeNode3);
        System.out.println(serialize3);
        TreeNode treeNode2 = timu297.deserialize2(serialize3);

        String serialize4 = timu297.serialize3(treeNode);
        System.out.println(serialize4);
        TreeNode treeNode4 = timu297.deserialize3(serialize4);

        String serialize5 = timu297.serialize3(null);
        System.out.println(serialize5);
        TreeNode treeNode5 = timu297.deserialize3(serialize5);
    }

    //============================= 以下是使用后序遍历进行的
    public String serialize2(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serRecur2(root, buffer);
        return buffer.toString();
    }


    public void serRecur2(TreeNode root, StringBuffer buffer){
        if (root==null){
            buffer.append("#").append(",");
            return;
        }
        serRecur2(root.left, buffer);
        serRecur2(root.right, buffer);
        buffer.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (int i=0; i<split.length ;i++){
            list.add(split[i]);
        }
        TreeNode treeNode = desRecur2(list);
        return treeNode;
    }

    public TreeNode desRecur2(LinkedList<String> list){
        if (list.isEmpty()){
            return null;
        }
        String s = list.removeLast();
        if (s.equals("#")){
            return null;
        }
        // 注意，根据上图，从后往前在 nodes 列表中取元素，一定要先构造 root.right 子树，后构造 root.left 子树。
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.right = desRecur2(list);
        root.left = desRecur2(list);
        return root;
    }


    //============================= 以下是使用层序遍历进行的

    // Encodes a tree to a single string.
    public String serialize3(TreeNode root) {
        if (root==null){
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            
            if (poll==null){
                buffer.append("#").append(",");
            }else {
                buffer.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return buffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        if (data.length()==0){
            return null;
        }
        String[] split = data.split(",");
        if (split.length==0){
            return null;
        }
        Queue<TreeNode> parent = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        parent.add(root);
        for (int i=1; i<split.length; ){

            TreeNode parentNode = parent.poll();
            String left = split[i++];
            if (!left.equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                parentNode.left = leftNode;
                parent.add(leftNode);
            }

            String right = split[i++];
            if (!right.equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                parentNode.right = rightNode;
                parent.add(rightNode);
            }

        }
        return root;
    }
}
