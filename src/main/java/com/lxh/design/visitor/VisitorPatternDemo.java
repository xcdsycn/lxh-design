package com.lxh.design.visitor;

/**
 * @Description Visitor 模式
 * <p>
 * 	 1. 在访问者模式中，使用 访问者类来 改变 元素类 的执行算法。
 * 	 2. 通过这种方式，元素的执行算法可以随访问者变化而变化。
 * 	 3. 此模式属于行为模式类别。
 * 	 4. 根据每个模式，元素对象 必须 接受 访问者对象，以便访问者对象处理对元素对象的操作。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:19
 **/
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
