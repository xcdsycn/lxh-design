package com.lxh.design.dao;

/**
 * @Description 相当于Entity
 * @Author lxh
 * @Date 2021/2/13 22:23
 **/
public class StudentEntity {
    private String name;
    private int rollNo;

    public StudentEntity(String name, int rollNo) {
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
        return "StudentEntity{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}
