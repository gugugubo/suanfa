package bobo.algo.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * @Date 2020/9/19 21:25
 * @Version 1.0
 * https://leetcode-cn.com/problems/word-search/
 **/
public class timu79 {
    /**
     * 控制四个方向的遍历
     */
    int[][] direction = {{0,1} , {1,0} , {0,-1} , {-1, 0}} ;
    char[][] board ;
    String word ;
    int totalx ;
    int totaly ;
    /**
     * 判断是否访问过
     */
    boolean[][] visited ;

    /**
     * 图的递归和回溯
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        totalx = board.length;
        if (totalx == 0){
            return false;
        }
        totaly = board[0].length;
        visited = new boolean[totalx][totaly];
        for (int i = 0; i< totalx; i++){
            for (int j = 0; j< totaly; j ++){
                visited[i][j] =  false;
            }
        }
        for (int i = 0; i< totalx; i++){
            for (int j = 0; j< totaly; j ++){
                if (recur(0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean recur(int index, int startx , int starty){
        
        if (index == word.length() - 1){
            if (board[startx][starty] == word.charAt(index)){
                return true;
            }
            return false;
        }
        
        
        if (board[startx][starty] == word.charAt(index)){
            visited[startx][starty] = true;
            for (int i = 0 ;i < 4 ; i++){
                int newStartx = startx + direction[i][0];
                int newStarty = starty + direction[i][1];
                if (ifregion(newStartx,newStarty) && !visited[newStartx][newStarty]){
                    if (recur(index + 1, newStartx,newStarty)){
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }
    
    private  boolean ifregion(int newStartx , int newStarty){
        if (newStartx >= totalx || newStartx < 0 || newStarty >= totaly || newStarty < 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][]  board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        boolean abcced = new timu79().exist(board, "ABCCED");
//        System.out.println(abcced);

        /**
         * ["C","A","A"]
         * ["A","A","A"]
         * ["B","C","D"]
         */
        char[][] board2 ={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        boolean abcced2 = new timu79().exist(board2, "AAB");
        System.out.println(abcced2);

    }
}
