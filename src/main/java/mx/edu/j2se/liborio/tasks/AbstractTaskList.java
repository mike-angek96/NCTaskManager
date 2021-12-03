package mx.edu.j2se.liborio.tasks;

abstract class AbstractTaskList {

    abstract void add(Task data);
    abstract void printTasks();
    abstract int size();
    abstract Task getTask(int index);
}
