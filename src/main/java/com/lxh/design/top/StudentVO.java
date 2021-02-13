package com.lxh.design.top;

/**
 * @Description 传输对象DTO
 * <p>
 * 当我们想要在客户端到服务器的一个传递具有多个属性的数据时，可使用传输对象模式。
 * 传输对象也称为值对象。
 * 传输对象是一个具有getter/setter方法的简单POJO类，并且是可序列化的，因此可以通过网络传输。
 * 它没有任何行为。
 * 服务器端业务类通常从数据库获取数据并填充到POJO类，并将其发送到客户端或通过值传递它。
 * 对于客户端，传输对象是只读的。
 * 客户端可以创建自己的传输对象，并将其传递给服务器，以便一次性更新数据库中的值。 以下是这种类型的设计模式的实体。
 * </p>
 * <p>
 * 业务对象 - 业务服务 使用数据填充 传输对象。
 * 传输对象 - 具有仅设置/获取属性的方法的简单POJO-VO或DTO，VO与DTO只是在工程上，我们分了太多的层的结果。
 * 一般在与数据库接近的实体起名Entity，相当于BO，在DAO及Service层都可以使用；
 *
 * 在Service层的实体，如果要与前端或其他服务相交流的时候，可以用DTO或VO来做中间的转换，
 * 其主要作用是提供一个输出的变换，如：客户端不需要那么多的属性，或者需要组合的数据结构，如列表，
 * 或者结合的A、B、C几个对象作为输出的属性结构（在报表中）。
 *
 * 另外，因为在service与DAO中都存在接口，如果每一层都是Module，为了避免跨Module的依赖关系，
 * 需要在每个接口层，都有自己的业务实体类，一般在service层就是DTO，在DAO层是Entity，在controller
 * 层可以使用DTO（Service层提供的），或VO（controller层提供的，作为入参）
 * 客户端 - 客户端请求或发送传输对象到业务对象。
 * </p>
 * @Author lxh
 * @Date 2021/2/13 16:37
 **/
public class StudentVO {
    private String name;
    private int rollNo;

    public StudentVO(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}
