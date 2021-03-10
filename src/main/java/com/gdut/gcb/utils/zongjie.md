



## 链表

1. **如果需要对链表进行翻转，可以考虑迭代中使用栈和头插法(头插法一般会使用一个头结点)或者使用递归**  从尾到头打印链表timu6  链表相加likou.timu445  反转链表timu24   反转链表指定范围likou.timu92   K个一组翻转链表likou.timu25  
2. **考虑链表元素多次迭代分析出数学等式的情况**  链表中倒数第k个结点timu22 删除链表的倒数第N个节点likou.timu19  两个链表的第一个公共节点timu52    链表中环的入口结点timu55  
3. **考虑多个指针的使用**    链表分隔成k部分likou.timu752  链表的中间结点timu876 奇偶链表likou.timu328   复杂链表的复制timu35  
4.  **递归+多指针** 合并递增链表timu25  去除重复节点likou.timu56  两两交换链表节点likou.timu24  链表是否为回文链表timu234 

## 双指针

 <span style="color:red"> 注意：双指针i和j是否可以相等，这里的双指针指的是左右指针，上面链表上的题目是快慢指针</span>

2. 有序数组合并timu88  平方数之和timu633 有序数组找目标和timu167  反转字符串timu344 反转字符串中的元音字母timu345  验证回文字符串Ⅱtimu680  匹配到字典里最长单词timu524
2. 原地修改数组likou.timu26  删除排序链表中的重复元素likou.timu83  移除元素likou.timu27    移动零likou283
2. 调整数组顺序使奇数位于偶数前面niuke.timu21



## 滑动窗口

```cpp
int left = 0, right = 0;

while (right < s.size()) {`
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        printf("window: [%d, %d)\n", left, right);
        /********************/
 
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

**其中两处 `...` 表示的更新窗口数据的地方，到时候你直接往里面填就行了**。

而且，这两个 `...` 处的操作分别是右移和左移窗口更新操作，等会你会发现它们操作是完全对称的。

1. 最小覆盖子串timu76    字符串的排列timu567   找到字符串中所有字母异位词timu438    无重复字符的最长子串timu3  滑动窗口最大值timu59_1



## 查找表

1. 两数之和likou.timu1   存在重复元素likou.timu219  三数之和timu15  四数相加ii--timu454   四数之和timu18



## 二分法

<span style="color:red"> 二分搜索的必要条件(感觉就是下面这段文字的意思)：1.通过下标可以得到关键字  2. 任取一个关键字的的值可以确定所寻找的关键字是在它前面还是后面。二分查找场景：寻找一个数、寻找左侧边界、寻找右侧边界</span>

经常有读者问我，读了之前的爆文 [二分查找框架详解](../算法思维系列/二分查找详解.md) 之后，二分查找的算法他写的很溜了，但仅仅局限于在数组中搜索元素，不知道底怎么在算法题里面运用二分查找技巧来优化效率。

**那我先说结论，你想用二分查找技巧优化算法，首先要把 for 循环形式的暴力算法写出来，如果算法中存在如下形式的 for 循环**：

```java
// func(i) 是 i 的单调函数（递增递减都可以）
int func(int i);

// 形如这种 for 循环可以用二分查找技巧优化效率
for (int i = 0; i < n; i++) {
    if (func(i) == target)
        return i;
}
```

**如果 `func(i)` 函数是在 `i` 上单调的函数，一定可以使用二分查找技巧优化 for 循环**。

「在 `i` 上单调的函数」是指 `func(i)` 的返回值随着 `i` 的增加而增加，或者随着 `i` 的增加而减小。

为什么满足这个条件就可以使用二分查找？**因为这个逻辑和「在有序数组中查找一个元素」是完全一样的呀**！

在**有序数组** `nums` 中查找某一个数 `target`，是不是最简单二分查找形式？我们看下普通的 for 循环遍历算法：

```java
// nums 是一个有序数组
int[] nums;
// target 是要搜索的元素
int target;

// 搜索 target 在 nums 中的索引
for (int i = 0; i < nums.length; i++) {
    if (nums[i] == target)
        return i;
}
```

既然 `nums` 是有序数组，你把 `nums[i]` 看做函数调用，是不是可以理解为 `nums` 在参数 `i` 上是单调的？这是不是和之前说的 `func(i)` 函数完全一样？

当然，前文 [二分查找框架详解](../算法思维系列/二分查找详解.md) 说过，二分查找算法还有搜索左侧、右侧边界的变体，怎么运用到具体算法问题中呢？

还是注意观察 for 循环形式，只是不一定是 `func(i) == target` 作为终止条件，可能是 `<=` 或者 `>=` 的关系，这个可以根据具体的题目意思来推断

1. labuladong

   1. ```
      使用 < 那么《while循环内的》取值范围是 [left, right); 如果right = nums.length， 那么《循环内》刚好全部取完； 如果nums.length-1 需要《循环外》判断最后一个
      使用 <= 那么《while循环内的》取值范围是[left, right]; 如果right = nums.length, 那么《循环内》可能存在越界； 如果是nums.length-1 刚好全部取完
      ```

2. 二分法所有题目分类：[地址](https://www.liwei.party/2019/06/17/leetcode-solution-new/search-insert-position/#toc-heading-2)   这个总结中与labuladong的区别就是：在计算左侧边界或者右侧边界的时候没有舍弃符合条件的那个边界值，从而形成闭区间！   因此特别需要注意的地方是：**只要看到 `left = mid` ，它对应的取中位数的取法一定是 `int mid = left + (right - left + 1) / 2;`。**

   





## 二叉树(递归)

递归的三个步骤：1.base case ，2.递归，3.拼接递归结果

**遇到任何递归型的问题，无非就是灵魂三问**：

**1、这个函数是干嘛的**？

**2、这个函数参数中的变量是什么的是什么**？

**3、得到函数的递归结果，你应该干什么**？

<span style="color:red">    可以在树的节点是代入代码检验是否正确</span>

```java
/* 二叉树遍历框架 */
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}
```

2. 递归+迭代：二叉树的最小深度likou.timu111
2. 第一期：二叉树展开为链表likou.timu114  填充节点右侧节点指针likou.timu116（注意上面红色字）  翻转二叉树likou.timu226
3. 第二期：从前序与中序遍历序列构造二叉树likou.timu105  从中序与后序遍历序列构造二叉树likou.timu106  最大二叉树likou.timu654
4. 第三期：寻找重复的子树likou.timu652
5. bst第一期：把二叉搜索树转换为累加树likou.timu538（类变量的使用）  二叉搜索树中第K小的元素likou.timu230 （类变量的使用）    请判断一个链表是否为回文链表likou.timu234（类变量的使用）  二叉搜索树与双向链表niuke.timu93（类变量的使用，这个是offer的题）
6. bst第二期：验证二叉搜索树likou.timu98（如果当前节点会对下面的子节点有整体影响，可以通过辅助函数增长参数列表，借助参数传递信息）  删除二叉搜索树中的节点likou.timu450  二叉搜索树中的搜索likou.timu700    二叉搜索树中的插入操作likou.timu701  
8. 完全二叉树相关：二叉树最大宽度likou.timu662   判断完全二叉树likou.timu958
9. 其它题目 对称二叉树likou.timu101（注意上面红色字）



## BFS

<span style="color:red">框架如下</span>

```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```

1. 二叉树的最小深度likou.timu111   打开转盘锁likou.timu752


## 回溯

​     <span style="color:red"> 回溯法：回溯是递归的特性，递归都可以用栈模拟。回溯是暴力解法的一种手段！回溯一般是指有状态重置的！敲代码的时候想清楚回溯的树型结构！  1、路径：也就是已经做出的选择。2、选择列表：也就是你当前可以做的选择（1.注意是从0开始还是不是从0开始，如果是从0开始还要注意元素之间是否存在相互影响 2.如果每次都复制就不用进行撤销选择的操作）。3、结束条件：也就是到达决策树底层，无法再做选择的条件。</span>

```
/**
 * 排列  17   47（相比17，元素之间会相互影响）   
 * 组合  77
 * 平面范围的回溯问题  单词查找问题79  岛屿问题200  n皇后问题51
 * 
 * 
 * 待做： 排列  93  131  47  39 40  组合  216  78   90   401     floodfill 130 417   n皇后优化 52  37
 * 
 * 讲义： https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
```



## 动态规划

以后碰到那种恶心人的最值题，思路往动态规划想就对了，这就是套路

```python
# 初始化 base case
dp[0][0][...] = base
# 进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)
```

1、**确定 base case**，这个很简单，显然目标金额 `amount` 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。

2、**确定「状态」，也就是原问题和子问题中会变化的变量**。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 `amount`。

3、**确定「选择」，也就是导致「状态」产生变化的行为**。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。

4、**明确 `dp` 函数/数组的定义**。我们这里讲的是自顶向下的解法，所以会有一个递归的 `dp` 函数，一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。所以我们可以这样定义 `dp` 函数：`dp(n)` 的定义：输入一个目标金额 `n`，返回凑出目标金额 `n` 的最少硬币数量。

> 最优子结构：可以从子问题的最优结果推出更大规模问题的最优结果；想满足最优子结，子问题之间必须互相独立
>
> dp 数组的遍历方向：1、遍历的过程中，所需的状态必须是已经计算出来的。2、遍历的终点必须是存储结果的那个位置。





### 贪心

1. **一般都是需要先进行排序**：删除被覆盖区间timu1288   无重叠区间timu435   用最少的箭头射爆气球timu452   区间合并问题timiu56  区间交集问题timu986



## 数据结构

### 单调队列

1. 滑动窗口的最大值timu59_1

### 单调栈

1. 下一个更大元素I timu496    每日问题timu739   下一个更大元素ii timu503 



## 算法技巧

1. 前缀和：  和为K的子数组likou.timu560   likou.timu437路径总和 III







1. 双路快排的parition：最后需要   swap(arr,l,j);      return j;
2. 





栈的使用

1. 进行翻转的时候：查看链表专题
2. 进行匹配的时候：波兰表达式求值timu150  字符串解码timu394   删除字符串中的所有相邻重复项1047
3. 





删除相邻元素

1. 删除字符串中的所有相邻重复项timu1047 