package com.lxh.design.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lxh
 * @Date 2021/2/13 22:27
 **/
public class StudentDaoImpl implements StudentDao{

    List<StudentEntity> students;

    public StudentDaoImpl() {
        this.students = new ArrayList<>();
        students = new ArrayList<StudentEntity>();
        StudentEntity student1 = new StudentEntity("Robert",0);
        StudentEntity student2 = new StudentEntity("John",1);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return students;
    }

    @Override
    public StudentEntity getByRollNo(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void update(StudentEntity studentEntity) {
        students.get(studentEntity.getRollNo()).setName(studentEntity.getName());
        System.out.println("Student: Roll No " + studentEntity.getRollNo() + ", updated in the database");
    }

    @Override
    public void delete(StudentEntity studentEntity) {
        students.remove(studentEntity);
        System.out.println("Student: Roll No " + studentEntity.getRollNo() + ", deleted from database");
    }
}
