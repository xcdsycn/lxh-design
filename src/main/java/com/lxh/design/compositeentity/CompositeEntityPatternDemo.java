package com.lxh.design.compositeentity;

/**
 * @Description 组合实体模式
 * <p>
 *     1. 组合实体模式用于EJB持久化机制。
 *     2. 组合实体是表示对象图的EJB实体bean。
 *     3. 当组合实体更新时，内部依赖对象bean将自动更新为由EJB实体bean管理
 * </p>
 * <p>
 *     组合实体 - 它是主要的实体bean。 它可以是粗粒度的或可以包含用于持久性目的的粗粒度对象。
 *     粗粒对象 - 此对象包含依赖对象。 它有自己的生命周期，并且管理依赖对象的生命周期。
 *     依赖对象 - 是一个对象，这取决于它的持久性生命周期粗粒对象。
 *     策略 - 表示如何实现复组合实体。
 * </p>
 * <p>
 *     1. 这种设计模式：主要用来对对象进行分层，比如这个模式就分了粗粒度实体、粗粒度对象、依赖对象
 *     2. 这种方式是一层一层的定义清晰依赖关系，底层的对象为POJO，粗粒度的对象组合这些底层对象，更上层的对象再组合这一层的对象，逐层组合
 *     形成一棵树
 *     3. 这种模式侧重于依赖的类有多个的时候，如何来组织这些类之间的关系
 *
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:43
 **/
public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        Client client = new Client();

        client.setData("test", "data");
        client.printData();
        client.setData("second test", "data2");
        client.printData();
    }
}
