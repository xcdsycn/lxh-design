package com.lxh.jdk.collections;

import java.util.*;

/**
 * @Description TreeMap用法
 * @Author lxh
 * @Date 2021/8/5 19:46
 **/
public class TreeMapExample {

    public static void main(String[] args) {
        //创建TreeMap对象：
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        System.out.println("初始化后,TreeMap元素个数为：" + treeMap.size());

        //新增元素:
        treeMap.put("hello",1);
        treeMap.put("world",2);
        treeMap.put("my",3);
        treeMap.put("name",4);
        treeMap.put("is",5);
        treeMap.put("huangqiuping",6);
        treeMap.put("i",6);
        treeMap.put("am",6);
        treeMap.put("a",6);
        treeMap.put("a",1);
        treeMap.put("a",3);
        treeMap.put("developer",6);
        System.out.println("添加元素后,TreeMap元素个数为：" + treeMap.size());

        //遍历元素：
        Set<Map.Entry<String,Integer>> entrySet = treeMap.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("TreeMap元素的key:"+key+",value:"+value);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        //获取所有的key：
        Set<String> keySet = treeMap.keySet();
        for(String strKey:keySet){
            System.out.println("TreeMap集合中的key, 是经过排序的:"+strKey);
        }

        //获取所有的value:
        Collection<Integer> valueList = treeMap.values();
        for(Integer intValue:valueList){
            System.out.println("TreeMap集合中的value,按KEY排序，value：" + intValue );
        }

        //获取元素：
        //获取集合内元素key为"huangqiuping"的值
        Integer getValue = treeMap.get("huangqiuping");
        //获取集合内第一个元素
        String firstKey = treeMap.firstKey();
        //获取集合内最后一个元素
        String lastKey =treeMap.lastKey();
        //获取集合内的key小于"huangqiuping"的key
        String lowerKey =treeMap.lowerKey("huangqiuping");
        //获取集合内的key大于等于"huangqiuping"的key
        String ceilingKey =treeMap.ceilingKey("huangqiuping");
        //获取集合的key从"a"到"huangqiuping"的元素
        SortedMap<String,Integer> sortedMap =treeMap.subMap("a","my");

        //删除元素：
        //删除集合中key为"huangqiuping"的元素
        Integer removeValue = treeMap.remove("huangqiuping");
        //清空集合元素：
        treeMap.clear();

        //判断方法：
        //判断集合是否为空
        boolean isEmpty = treeMap.isEmpty();
        //判断集合的key中是否包含"huangqiuping"
        boolean isContain = treeMap.containsKey("huangqiuping");
    }
}
