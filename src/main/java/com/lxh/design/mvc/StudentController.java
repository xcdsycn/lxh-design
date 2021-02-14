package com.lxh.design.mvc;

/**
 * @Description 控制器
 * <p>
 *     1. 用来组合 模型 视图
 *     2. 设置模型数据
 *     3. 更新视图，也就是调用方法显示模型的数据
 * </p>
 * @Author lxh
 * @Date 2021/2/14 11:52
 **/
public class StudentController {

    private Student model;

    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public  void setRollNo(int rollNo) {
        model.setRollNo(rollNo);
    }

    public int getRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetail(model);
    }
}
