package com.gdut.gcb.likou.erchashu;

/**
 * @Author 古春波
 * @Description  208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 9:31
 * @Version 1.0
 **/
public class timu208 {


    /**
     * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
     */
    class Trie {
        public TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i=0 ; i<word.length(); i++){
                if (node.get(word.charAt(i)) == null){
                    node.put(word.charAt(i), new TrieNode());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i=0; i<word.length() ;i++){
                if (node.get(word.charAt(i))==null){
                    return false;
                }
                node = node.get(word.charAt(i));
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i=0; i<prefix.length() ;i++){
                if (node.get(prefix.charAt(i))==null){
                    return false;
                }
                node = node.get(prefix.charAt(i));
            }
            return node!=null;
        }
    }
    class TrieNode{

        public TrieNode[] links;

        public final int R = 26;
        public boolean isEnd;

        public TrieNode(){
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }
        public TrieNode get(char ch){
            return links[ch-'a'];
        }
        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}


