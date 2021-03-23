package com.gdut.gcb.likou.mianshi.xiecheng;

import java.io.IOException;
import java.util.*;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/18 20:10
 * @Version 1.0
 **/
public class Second {
        // query:我想春节从南京去三亚和海口潜水跟团游5天5钻携程自营
    static LinkedHashMap<String, String> map = new LinkedHashMap(50);
    static LinkedHashMap<String, List> result = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String toBeMap = "";
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String[] split = name1.split(":");
            if (split[0].equals("dict")){
                String[] split1 = split[2].split(",");
                for (int i=0; i<split1.length; i++){
                    map.put(split1[i], split[1]);
                }
            }else {
                if (!in.hasNextLine()){
                    break;
                }
                if (name1.equals("")){
                    break;
                }
                String[] split3 = name1.split(":");
                toBeMap = split3[1];
                break;
            }
        }

        String finalToBeMap = toBeMap;
        map.forEach ((key, value)->{
            if (finalToBeMap.contains(key)){
                if (result.containsKey(key)){
                    List list = result.get(key);
                    list.add(value);
                }else {
                    List list = new ArrayList();
                    list.add(value);
                    result.put(key, list);
                }
            }
        });
        result.forEach((key, value)->{
            System.out.println(key + ":" + value);
        });
    }

    /**
     * dict:停词:我想,的,得,从,去
     * dict:目的地:三亚,北京,上海
     * dict:出发地:南京,苏州
     * dict:出游类型:跟团游,自由行
     * dict:供应商:携程自营
     * dict:节假日:春节
     * query:我想春节从南京去三亚和海口潜水跟团游5天5钻携程自营
     * 样例输出
     * 我想:[停词]
     * 春节:[节假日]
     * 从:[停词]
     * 南京:[出发地]
     * 去:[停词]
     * 三亚:[目的地]
     * 跟团游:[出游类型]
     * 携程自营:[供应商]
     */
}
