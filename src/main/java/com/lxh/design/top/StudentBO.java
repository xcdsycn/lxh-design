package com.lxh.design.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 业务对象
 * <p>
 *     业务对象，模拟业务操作，也就是与数据库相关的操作，这个BO里是有业务逻辑的，在这里执行CRUD操作，其实就是我们常说的Repository或DAO层
 *     那么具体执行业务逻辑调用的地方，就是demo就是相当于我们的service层+controller层
 * </p>
 * @Author lxh
 * @Date 2021/2/13 16:42
 **/
public class StudentBO {
    //List is working as a database
    List<StudentVO> students;

    public StudentBO() {
        students = new ArrayList<>();
        StudentVO studentVO1 = new StudentVO("Robert", 0);
        students.add(studentVO1);
        StudentVO studentVO2 = new StudentVO("John", 1);
        students.add(studentVO2);
    }

    public void deleteStudent(StudentVO studentVO) {
        students.remove(studentVO);
        System.out.println("Student: Roll No " + studentVO.getRollNo()
                + ", deleted from database");
    }

    public List<StudentVO> getAllStudents() {
        return students;
    }

    public StudentVO getStudent(int rollNo) {
        return students.get(rollNo);
    }

    public void updateStudent(StudentVO studentVO) {
        students.get(studentVO.getRollNo()).setName(studentVO.getName());
        System.out.println("Student Roll No " + studentVO.getRollNo()
        + ", updated in the database");
    }
}
