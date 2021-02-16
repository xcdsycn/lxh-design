package com.lxh.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 具有下级本身的实体，相关于树节点
 * @Author lxh
 * @Date 2021/2/16 19:18
 **/
public class Employee {

    private String name;
    private String dept;
    private int salary;

    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
