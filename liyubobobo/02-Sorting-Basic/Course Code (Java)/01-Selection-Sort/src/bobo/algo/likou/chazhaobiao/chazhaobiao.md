# 查找表

查找表主要讲了map和set的使用，hashmap和hashset都是O(1)级别的，Treemap和Treeset是O(logn)级别的

下面来看题目

# 1 两数之和，使用hashmap



![1601309565172](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200929001249-194374.png)

但是不能先一次性将所有的元素放进查找表种，因为map结构可能会覆盖相同的值，如果target是82，它是由两个41组成，就会可能出问题。

![1601309590499](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200929001312-624226.png)



# 454 四数之和使用hashmap

![1601339853760](assets/1601339853760.png)

可以使用查找表进行优化

![1601339873363](assets/1601339873363.png)



优化查找表

![1601340106657](assets/1601340106657.png)



# 447 hashmap



![1601341950466](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200929091252-638196.png)

![1601341996085](assets/1601341996085.png)



![1601342089781](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200929091450-787497.png)



![1601342316686](assets/1601342316686.png)



# 219查找表+滑动窗口



![1601350679268](assets/1601350679268.png)



![1601350712767](assets/1601350712767.png)



在K长度的窗口中，如果找到了i，j相等，那么就是满足条件的解

![1601350766679](assets/1601350766679.png)



如果l到l+k没有相同的元素，那么得l向前移动一位（滑动窗口）

![1601351055942](https://gitee.com/gu_chun_bo/picture/raw/master/image/20200929114436-259627.png)

再对比l+k+1这个元素与l+1 和l+k之前的元素有没有相同的元素。如果没有就继续滑动（滑动窗口）

![1601350859451](assets/1601350859451.png)

![1601350865317](assets/1601350865317.png)













# 待做

15 18  16  49  149