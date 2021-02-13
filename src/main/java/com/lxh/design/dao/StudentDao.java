package com.lxh.design.dao;

import java.util.List;

/**
 * @Description DAO接口
 * @Author lxh
 * @Date 2021/2/13 22:24
 **/
public interface StudentDao {
     List<StudentEntity> getAllStudents();

     StudentEntity getByRollNo(int rollNo);

     void update(StudentEntity studentEntity);

     void delete(StudentEntity studentEntity);
}
