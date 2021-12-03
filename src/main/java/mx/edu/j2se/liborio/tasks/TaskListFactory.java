package mx.edu.j2se.liborio.tasks;

public class TaskListFactory {

    public static AbstractTaskList createTaskList(ListTypes.types type){
        if(type.equals(ListTypes.types.LINKED)){
            return new LinkedTaskList();
        }else if(type.equals(ListTypes.types.ARRAY)){
            return new ArrayTaskList(0);
        }
        return null;
    }
}
