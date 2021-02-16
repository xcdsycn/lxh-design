package com.lxh.design.builder;

/**
 * @Description 汉堡
 * 创建抽象类，实现接口，提供默认功能
 * <p>
 *     1. 有未实现的方法，这是一个技巧，如果只实现接口的部分功能，可以用抽象类来完成；
 *     2. 这些实现了方法，可以作为抽象类的默认方法
 *     3. 抽象类中指明的抽象方法是必须要实现的
 *     4. 抽象类未未实现的接口方法，也是必须要在具体类中的实现的
 *     5. 这是具体类的一个分类，根据包装类型返回的分类
 *     6. 不必要的接口，不用指明抽象方法，因为接口中的方法都可以作为模板使用，也必须实现
 * </p>
 * @Author lxh
 * @Date 2021/2/16 19:53
 **/
public abstract class Burger implements Item{


    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
