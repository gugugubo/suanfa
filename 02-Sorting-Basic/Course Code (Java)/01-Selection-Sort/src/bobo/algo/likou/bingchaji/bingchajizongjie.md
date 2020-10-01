



# 介绍：

解决连接问题，网络中节点是否连接和数学中集合类的并集

![1601561904757](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001221827-886950.png)

## 连接问题和路径问题的区别

![1601562147984](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001223852-546677.png)

## 并查集的两个动作：

![1601562543485](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001222904-843781.png)



## 并查集的数据表示

先说一个最简单的并查集：

我们用0--9给每个元素一个id编号，对于每一个元素，并查集存储的是元素它所属于的集合的id；

如下：id为0，2，4，6，8的元素都在同一个集合

![1601562505047](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001222825-119503.png)





![1601562819012](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001223354-660534.png)



## 真正的并查集

我们用0--9给每个元素一个id编号，对于每一个元素，并查集存储的是元素它所属于的集合的父节点的id编号；

![1601566268921](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001233110-188427.png)



每一个树，代表一个集合。树的根节点只是集合中的一个元素。比如下面，5，6，7元素在同一个集合；2，3，1在同一个集合

![1601565549653](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001231910-159994.png)





![1601565427268](https://gitee.com/gu_chun_bo/picture/raw/master/image/20201001231708-648794.png)





