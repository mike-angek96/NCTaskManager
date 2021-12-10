package mx.edu.j2se.liborio.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayTaskList extends AbstractTaskList implements Cloneable{
    private Task[] taskList;
    private int counter=0;

    public ArrayTaskList(int size) throws NegativeArraySizeException{
        if(size <0){
            throw new NegativeArraySizeException("The size cannot be negative");
        }
        this.taskList= new Task[size];
    }

    @Override
    public void add(Task task){
        this.taskList[counter] = task;
        counter+=1;
        System.out.println("Task added successfully");
    }

    public boolean remove(Task task){
        for(int i=0; i < this.taskList.length; i++){
            if(this.taskList[i].getTitle().equals(task.getTitle())){
                this.taskList[i]=null;
                printTasks();
                return true;
            }
        }
        return false;
    }

    @Override
    public void printTasks(){
        System.out.println(Arrays.toString(this.taskList));
    }

    @Override
    public int size(){
        return this.counter;
    }

    @Override
    public Task getTask(int index){
        return this.taskList[index];
    }

    /**
     * This method returns a subset of tasks that are scheduled for execution at least once after the "from" time, and not later than the "to" time
     */
    public Task[] incoming(int from, int to) throws IllegalArgumentException{
        Task[] scheduledTasks = new Task[this.taskList.length];
        int cont=0;

        if(from <= 0 || to <=0){
            throw new IllegalArgumentException("Values cannot be less or equals than 0");
        }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return counter == that.counter && Arrays.equals(taskList, that.taskList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(counter);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "taskList=" + Arrays.toString(taskList) +
                ", counter=" + counter +
                '}';
    }

    @Override
    public ArrayTaskList clone() {
        try {
            ArrayTaskList clone = (ArrayTaskList) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public Iterator iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator {
        private int position=0;
        @Override
        public boolean hasNext() {
            if (position < taskList.length){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return taskList[position++];
            }else{
                return null;
            }
        }
    }
}
