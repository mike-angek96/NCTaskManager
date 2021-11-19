package mx.edu.j2se.liborio.tasks;

import java.util.Arrays;

public class ArrayTaskList {
    private Task[] taskList;
    private int counter=0;

    public ArrayTaskList(int size){
        this.taskList= new Task[size];
    }

    public void add(Task task){
        this.taskList[counter] = task;
        counter+=1;
        System.out.println("Task added successfully");
    }

    public boolean remove(Task task){
        for(int i=0; i < this.taskList.length; i++){
            if(this.taskList[i].getTitle().equals(task.getTitle())){
                this.taskList[i]=null;
                printTask();
                return true;
            }
        }
        return false;
    }

    public void printTask(){
        System.out.println(Arrays.toString(this.taskList));
    }

    public int size(){
        return this.counter;
    }

    public Task getTask(int index){
        return this.taskList[index];
    }

    /**
     * This method returns a subset of tasks that are scheduled for execution at least once after the "from" time, and not later than the "to" time
     */
    public Task[] incoming(int from, int to){
        Task[] scheduledTasks = new Task[this.taskList.length];
        int cont=0;
        for(int i=0; i < this.taskList.length; i++){
            if(this.taskList[i].isRepeated() == true && (this.taskList[i].getStartTime() >= from && this.taskList[i].getEndTime() <= to)){
                scheduledTasks[cont]=this.taskList[i];
                cont++;
            }
            if(this.taskList[i].isRepeated() == false && (this.taskList[i].getTime() >= from && this.taskList[i].getTime() <= to)){
                scheduledTasks[cont]=this.taskList[i];
                cont++;
            }
        }
        return scheduledTasks;
    }
}
