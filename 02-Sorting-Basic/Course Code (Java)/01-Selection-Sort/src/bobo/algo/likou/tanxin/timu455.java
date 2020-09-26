package bobo.algo.likou.tanxin;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 古春波
 * @Description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，
 * 并输出这个最大数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/26 13:38
 * @Version 1.0
 **/
public class timu455 {

    /**
     * 去最大的饼干，满足最贪心的小朋友
     * 如果最大的饼干可以满足最贪心的小朋友，那么留给下一个小朋友的饼干也是当前看来最大的饼干
     * 如果当前最大的饼干都无法满足最贪新的小朋友，那么就说明所有的饼干都无法满足最贪心的小朋友
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 使用java8 Stream流 将数组转换成 集合
        List<Integer> gList = Arrays.stream(g).boxed().collect(Collectors.toList());
        // 默认升序
        Collections.sort(gList);
        // 通过 reverse 翻转集合中的元素, 实现降序
        Collections.reverse(gList);

        // 使用java8 Stream流 将数组转换成 集合
        List<Integer> sList = Arrays.stream(s).boxed().collect(Collectors.toList());
        // 默认升序
        Collections.sort(sList);
        // 通过 reverse 翻转集合中的元素, 实现降序
        Collections.reverse(sList);
        
        int gIndex = 0 ; int sIndex = 0 ;
        int totalCount = 0;
        
        while(gIndex <g.length && sIndex< s.length){
            if (gList.get(gIndex) <= sList.get(sIndex)){
                gIndex++;
                sIndex++;
                totalCount++;
            }else {
                gIndex++;
            }
        }
        return totalCount;
    }


    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int [] numsw = {1,1};
        int contentChildren = new timu455().findContentChildren(nums, numsw);
        System.out.println(contentChildren);
    }
}
