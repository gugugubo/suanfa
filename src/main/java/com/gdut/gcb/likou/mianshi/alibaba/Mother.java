package com.gdut.gcb.likou.mianshi.alibaba;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/21 18:27
 * @Version 1.0
 **/
public abstract class Mother {
    public int getAge(){
        return 45;
    }
    public abstract class Son{
        public int getAge(){
            return 38;
        }
    }

    public static void main(String[] args) {
        Mother mother = new Mother(){
            @Override
            public int getAge(){
                return 22;
            }
        };
        
        Mother.Son s = mother.new Son() {
            @Override
            public int getAge() {
                return 57;
            }
        };
        System.out.println(s.getAge() +""+ mother.getAge());
    }
}
