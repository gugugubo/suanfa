package bobo.algo.niuke.sousuo;

/**
 * @Author 古春波
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/10 8:54
 * @Version 1.0
 **/
public class timu4 {

    /**
     * 我们将矩阵逆时针旋转 45° ，并将其转化为图形式，发现其类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、
     * 右分支元素更大。因此，通过从 “根节点” 开始搜索，遇到比 target 大的元素就向左，反之向右，即可找到目标值 target 。
     *
     * “根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 标志数 ，以 matrix 中的 左下角元素 为标志数 flag ，则有:
     *
     *     若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
     *     若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        
        
        int i = matrix.length -1, j = 0;
        while(i >= 0 && j < matrix[0].length  && matrix[i][j] != target){
            System.out.println(matrix[i][j]);
            System.out.println(target);
            if (matrix[i][j] > target){
                i --;
            }else {
                j++;
            }
        }
        return (i >= 0 && j < matrix[0].length) ? true :false;
    }


    /**
     * 1,4,7,11,15
     * 2,5,8,12,19
     * 3,6,9,16,22
     * 10,13,14,17,24
     * 18,21,23,26,30
     * @param args
     */
    
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = new timu4().findNumberIn2DArray(ints, 20);
        System.out.println(numberIn2DArray);
    }
}
