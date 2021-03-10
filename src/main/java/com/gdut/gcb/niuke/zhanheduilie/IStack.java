package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/1/26 15:51
 * @Version 1.0
 **/
interface IStack {
    void push(int data);//向栈中压数据
    int pop();//从栈顶取数据
    int min(); //获取栈中所有数据的最小值
    int max();//获取栈中所有数据的最大值

}

