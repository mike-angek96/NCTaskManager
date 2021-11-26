package mx.edu.j2se.liborio.tasks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Task irFiesta = new Task("ir a mi cumpleaños", 8);
        irFiesta.getTime();
        irFiesta.setActive(true);
        System.out.println(irFiesta);

        Task estudiar = new Task("leer", 5, 7, 2);
        estudiar.setActive(true);
        System.out.println(estudiar);

        Task correr = new Task("correr", 4, 11, 2);
        correr.setActive(true);

        System.out.println(correr.nextTimeAfter(1));
        System.out.println(correr.nextTimeAfter(4));
        System.out.println(correr.nextTimeAfter(5));
        System.out.println(correr.nextTimeAfter(10));
        System.out.println(correr.nextTimeAfter(11));
        System.out.println(correr.nextTimeAfter(12));
        System.out.println(correr);

        System.out.println("*****--------tasklist---------------------***");
        ArrayTaskList taskList = new ArrayTaskList(3);
        try {
            taskList.add(irFiesta);
            taskList.add(correr);
            taskList.add(estudiar);
            taskList.getTask(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Thw index is out of limit");
        }
        System.out.println(Arrays.toString(taskList.incoming(5, 9)));
        System.out.println(taskList.remove(estudiar));
        taskList.printTask();

        LinkedTaskList linkedTaskList = new LinkedTaskList();
        linkedTaskList.add(estudiar);
        linkedTaskList.add(irFiesta);
        System.out.println(linkedTaskList.incoming(1, 9));
        linkedTaskList.printTasks();
        System.out.println(linkedTaskList.remove(1));
        linkedTaskList.printTasks();
        System.out.println(linkedTaskList.size());
        System.out.println(linkedTaskList.getTask(0));
    }

}
