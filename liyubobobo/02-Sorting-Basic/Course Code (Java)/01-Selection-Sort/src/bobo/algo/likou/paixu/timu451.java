package bobo.algo.likou.paixu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 古春波
 * @Description 451. 根据字符出现频率排序  
 * @Date 2020/9/3 10:27
 * @Version 1.0
 **/
public class timu451 {

    /**
     * 使用桶排序
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        HashMap<Character, Integer> maps = new HashMap<>();
        char[] chars = s.toCharArray();
        //统计各个元素出现的次数，使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        for (Character car : chars){
            if (maps.containsKey(car)){
                maps.put(car,maps.get(car) + 1);
            }else{
                maps.put(car,1);
            }
        }

        // 利用桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List[] lists = new List[s.length() + 1];
        for (Character car: maps.keySet()){
            Integer integer = maps.get(car);
            if (lists[integer] == null){
                lists[integer] = new ArrayList();
            }
            lists[integer].add(car);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length() ;i>=0;i--){
            if (lists[i] == null){
                continue;
            }else {
                ArrayList<Character> o = (ArrayList)lists[i];
                    for (Character car : o){
                        for (int j = i ;j>0;j--){
                            stringBuffer.append(car);
                        }
                    }
            }
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        String string = "cccaaa"
                ;
        String s = frequencySort(string);
        System.out.println(s);
    }
    }
