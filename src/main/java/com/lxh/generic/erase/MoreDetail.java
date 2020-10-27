package com.lxh.generic.erase;

import java.util.*;

/**
 * 更具体的例子
 */
public class MoreDetail {

    class Table{}
    class Room {}
    class House<Q>{}
    class Particle<POSITION,MOMENTUM>{}

    public static void main(String[] args) {
        MoreDetail detail = new MoreDetail();
        detail.test();
	}

	public void test() {
        List<Table> tableList = new ArrayList<>();
        Map<Room,Table> maps = new HashMap<>();
        House<Room> house = new House<Room>();
        Particle<Long,Double> particle = new Particle<Long,Double>();
        System.out.println("Table class:");
        System.out.println(Arrays.toString(tableList.getClass().getTypeParameters()));
        System.out.println("Map class:");
        System.out.println(Arrays.toString(maps.getClass().getTypeParameters()));
        System.out.println("House class:");
        System.out.println(Arrays.toString(house.getClass().getTypeParameters()));
        System.out.println("Particle class:");
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));

    }

}
