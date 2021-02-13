package com.lxh.design.top;

/**
 * @Description 演示使用主类。这里是当客户端使用
 * @Author lxh
 * @Date 2021/2/13 16:49
 **/
public class TransferObjectPatternDemo {
    public static void main(String[] args) {
        StudentBO studentBO = new StudentBO();

        studentBO.getAllStudents().forEach(System.out::println);

        // update
        StudentVO studentVO = studentBO.getAllStudents().get(0);
        studentVO.setName("lxh");
        studentBO.updateStudent(studentVO);

        // get
        studentVO = studentBO.getAllStudents().get(0);
        System.out.println("Student: [RollNo : " + studentVO.getRollNo() + ", Name : " + studentVO.getName() + " ]");
    }
}
