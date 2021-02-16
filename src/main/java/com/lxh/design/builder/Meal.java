package com.lxh.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 表示顿饭
 * <p>
 *     一顿饭，由各项组成
 *     每一项项有价格
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:03
 **/
public class Meal {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * 注意这里的技巧，使用Item接口实现统一的价格方法计算
     * @return
     */
    public float getCost() {
        float cost = 0.0F;

        for(Item item : itemList) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        itemList.forEach(i->{
            System.out.print("Item: " + i.name());
            System.out.print(",Packing: " + i.packing().pack());
            System.out.println(",Price: " + i.price());
        });
    }
}
