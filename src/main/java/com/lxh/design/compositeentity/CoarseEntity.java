package com.lxh.design.compositeentity;

/**
 * @Description 组合实体
 * <p>
 *     可以包含一个或多个粗粒度的对象
 *     这个粗粒度的对象，主要用于实现持久化
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:39
 **/
public class CoarseEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }
}
