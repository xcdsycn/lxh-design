package com.lxh.design.compositeentity;

/**
 * @Description 粗粒度对象
 * <p>
 *     主要包含依赖对象
 *     有自己的生命周期
 *     管理依赖对象的生命周期
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:38
 **/
public class CoarseGrainedObject {
    DependentObject1 do1 = new DependentObject1();
    DependentObject2 do2 = new DependentObject2();

    public void setData(String data1, String data2) {
        do1.setData(data1);
        do2.setData(data2);
    }

    public String[] getData() {
        return new String[] {do1.getData(), do2.getData()};
    }
}
