package bobo.algo.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * @Date 2020/9/20 11:49
 * @Version 1.0
 * url https://leetcode-cn.com/problems/n-queens/
 **/
public class timu51 {
    
    
    List<List<String>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();
    int n ;
    /**
     * 列
     */
    boolean[] col;
    /**
     * 行
     */
    boolean[] row;
    /**
     * 储存右向左的斜对角
     */
    boolean[] diag1;
    /**
     * 储存左向右的斜对角
     */
    boolean[] diag2;

    public List<List<String>> solveNQueens(int n) {
        if (n<=0){
            return result;
        }
        this.n = n;
        col = new boolean[n];
        row = new boolean[n];
        diag1 = new boolean[2*n -1];
        diag2 = new boolean[2*n -1];
        for (int i =0 ;i< n;i++){
            col[i] = false;
            row[i] = false;
        }
        for (int j =0 ; j< 2*n -1;j++){
            diag1[j] = false;
            diag2[j] = false;
        }
        recur(0);
        return result;
    }
    
    
    private void recur(int index){
        
        if (index == n){
            result.add(generateResult(tempList));
            return;
        }
        
        for (int i = 0; i< n ; i++){
            if (!col[i] && !diag1[i + index] && !diag2[index - i + n -1] ){
                tempList.addLast(i);
                col[i] = true;
                diag1[i + index] = true;
                diag2[index - i + n -1] = true;
                recur(index + 1);
                tempList.removeLast();
                col[i] = false;
                diag1[i + index] = false;
                diag2[index - i + n -1] = false;
            }
        }
        
        
    }

    private List<String> generateResult(List<Integer> tempList) {
        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[tempList.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new timu51().solveNQueens(4);
        System.out.println(lists);
    }
}
