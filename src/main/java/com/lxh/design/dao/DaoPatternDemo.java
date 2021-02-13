package com.lxh.design.dao;

/**
 * @Description DAO主类
 * <p>
 *     这个模式，不需要多讲，经常用，在Spring中已经用的快烂了
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:31
 **/
public class DaoPatternDemo {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        studentDao.getAllStudents().forEach(System.out::println);

        //update
        StudentEntity studentEntity = studentDao.getAllStudents().get(0);
        studentEntity.setName("lxh");
        studentDao.update(studentEntity);

        // get the student
        StudentEntity byRollNo = studentDao.getByRollNo(0);
        System.out.println("更新后的学生：" + byRollNo);
    }


}
