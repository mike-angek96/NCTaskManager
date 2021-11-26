package mx.edu.j2se.liborio.tasks;

public class Task {

    private String title;
    private int time = 0, start = 0, end = 0, interval = 0;
    private boolean isActive = false, isRepetitive = false;

    /**
     * Constructs an inactive non-repetitive Task
     */
    public Task(String title, int time) throws IllegalArgumentException{
        if(time <= 0){
            throw new IllegalArgumentException("Value cannot be less or equal than 0");
        }
        this.title = title;
        this.time = time;
        this.isRepetitive = false;
    }

    /**
     * Constructs an inactive repetitive Task
     */
    public Task(String title, int start, int end, int interval) throws IllegalArgumentException{
        if(start <= 0 || end <= 0 || interval  <= 0){
            throw new IllegalArgumentException("Value cannot be less or equal than 0");
        }
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.isRepetitive = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTime() {
        return !this.isRepetitive
                ? this.time
                : this.start;
    }

    /**
     * If the task was a repetitive one, it becomes non-repetitive
     */
    public void setTime(int time) throws IllegalArgumentException{
        if(time <= 0){
            throw new IllegalArgumentException("Value cannot be less or equal than 0");
        }
        this.time = time;
        this.start = 0;
        this.end = 0;
        this.interval = 0;
        this.isRepetitive = false;
    }

    public int getStartTime() {
        return this.isRepetitive ? this.start : this.time;
    }

    public int getEndTime() {
        return this.isRepetitive ? this.end : 0;
    }

    public int getRepeatedInterval() {
        return this.isRepetitive
                ? this.interval
                : 0;
    }

    /**
     * If the task is a non-repetitive one, it becomes repetitive
     */
    public void setTime(int start, int end, int interval) throws IllegalArgumentException{
        if(start <= 0 || end <= 0 || interval  <= 0){
            throw new IllegalArgumentException("Value cannot be less or equal than 0");
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.isRepetitive = true;
    }

    public boolean isRepeated() {
        return this.isRepetitive;
    }

    /**
     * returns the next start time of the task execution after the current time given.
     * If after the specified time the task is not executed anymore, the method return -1
     */
    public int nextTimeAfter(int current) throws IllegalArgumentException{
        int nextTime = 0;

        if(current <= 0){
            throw new IllegalArgumentException("Value cannot be less or equal than 0");
        }
        if(!this.isActive){
            System.out.println("The task is inactive");
            return -1;
        }
        if (!this.isRepetitive) {
            return current < this.time ? this.time : -1;
        }

        if (current >= this.start && current <= this.end) {
            for (int i = this.start; i <= this.end; i += this.interval) {
                if (current < i) {
                    nextTime = i;
                    return nextTime;
                }
            }
        }

        return current < this.start ? this.start : -1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", isActive=" + isActive +
                '}';
    }
}
