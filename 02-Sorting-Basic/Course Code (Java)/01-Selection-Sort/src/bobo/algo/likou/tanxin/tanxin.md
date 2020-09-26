# 从分饼干谈起  455

![1601098940312](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926134221-468797.png)



# 435 区间不重叠



![1601120931217](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926194852-919320.png)



将问题转化为要保留的区间，再使用动态规划进行解题

![1601121346907](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926195548-866624.png)





贪心

![1601131049345](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926223731-944111.png)



![1601131201029](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926224127-317441.png)





# 贪心选择性质

在求解一个最优化的问题中，我们使用贪心的方式选择的一种内容之后，不会影响剩下的子问题的求解。

其实，一般验证是比较难的

![1601131917752](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926225203-112393.png)



比如，如下，可以举出反例，说明不成立

![1601131986187](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926225309-273054.png)



![1601132008563](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926225329-631985.png)

# 435贪心证明

使用数学的方法，数学归纳法，或者反证法； 下面使用反证法证明题目435的贪心算法是正确的

![1601132214337](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926225654-701124.png)

![1601132245897](assets/1601132245897.png)

![1601132346308](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200926225907-213504.png)



# 总结

贪心思想一般不会单独考，如果单独考的话都是很简单代码就可以实现的，一般不考证明原理

贪心一般会在某题解题过程中会被使用到









待做  392