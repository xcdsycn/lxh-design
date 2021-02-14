package com.lxh.design.mvc;

/**
 * @Description MVC模式
 * <p>
 *     主要的逻辑在控制器中
 * </p>
 * @Author lxh
 * @Date 2021/2/14 11:55
 **/
public class MVCPatternDemo {

    public static void main(String[] args) {
        Student model = getStudentFromDb();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model,view);
        controller.updateView();

        controller.setStudentName("LHZ");
        controller.updateView();

    }

    private static Student getStudentFromDb() {
        Student student = new Student();

        student.setName("lxh");
        student.setRollNo(10);

        return student;
    }
}
