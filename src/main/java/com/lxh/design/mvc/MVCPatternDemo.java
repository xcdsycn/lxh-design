package com.lxh.design.mvc;

/**
 * @Description MVC模式
 * <p>
 *     主要的逻辑在控制器中
 *     MVC模式表示：模型 - 视图 - 控制器模式。此模式用于分离应用程序的问题。
 * </p>
 * <p>
 *     模型（Model） - 模型表示携带数据的对象或JAVA POJO。如果其数据改变它也可以具有逻辑来更新控制器。
 *     视图（View） - 视图表示模型包含的数据的可视化层。
 *     控制器（Controller） - 控制器对模型和视图都有起作用。它控制数据流进入模型对象，并在数据更改时更新视图。
 *     它保持视图和模型分开，也是视图和模型的中间层
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
