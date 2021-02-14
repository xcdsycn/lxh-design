package com.lxh.design.iterator;

/**
 * @Description 这里用来模拟迭代器中的数据
 * <p>
 *     1. names 在实际使用中，是要提供初始化方法的
 *     2. 容器类，要提供Iterator，也就是迭代项
 *     3. 在这里看来，就像是一个抽象的模板类方法，如果要是实现多个迭代算法，那么这里需要抽象或范型化
 * </p>
 * @Author lxh
 * @Date 2021/2/14 22:07
 **/
public class NameRepository implements Container{

    public String[] names = {"Robert","John","Julie","Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
