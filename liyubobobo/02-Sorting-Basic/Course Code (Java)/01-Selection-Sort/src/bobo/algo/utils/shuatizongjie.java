package bobo.algo.utils;

/**
 * @Author 古春波
 * @Description 一些算法的思想总结
 * @Date 2020/9/17 19:07
 * @Version 1.0
 **/
public class shuatizongjie {

    /** 常见算法思想
     * 回溯法    niuke.timu38  niuke.timu34   排列问题 likou.timu17  likou.timu47  组合问题
     * 
     * 动态规划  
     * 
     * 优先状态机  niuke.timu20
     * 
     * 分治法
     *
     * 贪婪法
     * 
     * dfs bfs niuke.timu13
     * 
     * 搜索：niuke.timu11  niuke.timu56_1
     * 
     */

    /** 常见技巧
     *  双指针  快排  niuke.timu58_1
     *  
     *  滑动窗口  niuke.timu59_1  likou.timu219
     *  
     *  数组下标法
     *  
     *  位运算 niuke.timu56_1
     */


    /**
     * 了解什么是beanFactory？有什么用？提供了什么接口给你用？
     * 了解什么是FactoryBean？需要重写什么方法？怎么结合beanDefinition使用？怎么结合ImportBeanDefinitionRegister或者beanFactory使用？
     * 
     * 1.mybatis中的mapper接口对象是怎么生成的？是通过jak动态代理生成的
     * 
     * 2.spring对bean对象中的属性自动赋值？那么这个bean的属性对应的对象也的是spring托管的
     * 
     * 3.bean对象和普通对象的不同，bean是由spring管理的，是有完整的生命周期的
     *
     * 4.springBean是怎么产生的？
     *      1.给出bean的生命周期的图  2.解释beanFactory（beanFactory存了beanDefinition和bean，还可以注册bean  beanFactory实现了工厂模式）和beanFactory后置处理器
*                                 2.1 用一个类实现BeanFactoryPostProcessor接口，可以获得beanFactory进行调用beanFactory的一些接口方法
     * 
     * 5.spring是怎么将mybaits的mapper接口对象变成bean的？
     * 先生成beanDefinition对象，然后根据beanDefinition生成bean
     * 那这个beanDefinition对象是根据mybatis中的mapper接口对象，还是mapper接口的动态代理生成的对象来定义的呢
     * 
     * 6.将对象放到spring容器中的几种方式：1.使用beanFactory对象提供的接口方法注册bean  2.使用@bean注解 
     *  3.FactoryBean
     *      3.1 在一个名为C的类中实现FactoryBean接口，然后实现它的两个方法，在它的接口的getObject()方法中返回一个B类对象
     *      3.2 在spring容器中根据C的类名byName获取Bean，发现获取到的是B对象，而不是C对象；当然也可以通过byType直接获取B类对象
     *      
     * 7.FactoryBean和 beanFactory的区别？
     *  1.实现FactoryBean接口的类是一个特殊的bean，参考上方3.1  3.2
     *      1.1 FactoryBean也可以看成是一个小的工厂只生成一个bean，因为可以通过getObject()方法定义一个对象的生成过程
     *  2，beanFactory是个大的工厂
     *  
     * 继续解析mybatis整合spring中，mapper接口怎么变成bean的：
     *      在一个名为C并且实现FactoryBean接口的类的getObject()中使用jdk动态代理生成代理对象，然后返回回去，这样spring容器就获得了一个名为C但是类型是动态代理对象的bean
     *      
     * 上面解释了如何利用FactoryBean实现一个mapper接口对象加入到spring容器中？那么多个mapper接口对象又如何加入到spring容器中呢？
     *      利用beanDefinition，beanDefinition定义了多个为C的实现了FactoryBean的类，然后beanDefinition再通过beanFactory生成bean
     *      
     * 如何根据自己的逻辑生成bean？
     *      用一个类C实现ImportBeanDefinitionRegister接口，然后再使用@import接口导入C类，那么就会自动导入类C中定义的beanFactory变成bean
     *      所以我们可以利用ImportBeanDefinitionRegister接口中的方法实现上一个问题beanFactory实现的功能，将beanDefinition加入到容器中，然后生成对应的mapper对象的bean
     * 
     * spring就是根据上一个问题我们说的这个逻辑进行生成mapper对象对应的bean的
     */
}
