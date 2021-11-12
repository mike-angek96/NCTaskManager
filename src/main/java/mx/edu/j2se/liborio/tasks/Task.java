package mx.edu.j2se.liborio.tasks;

public class Task {

    private String title;
    private int time = 0, start = 0, end = 0, interval = 0;
    private boolean isActive = false;

    /**
     * Constructs an inactive non-repetitive Task
     */
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    /**
     * Constructs an inactive repetitive Task
     */
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
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
        return this.start == 0
                ? this.time
                : this.start;
    }

    /**
     * If the task was a repetitive one, it becomes non-repetitive
     */
    public void setTime(int time) {
        this.time = time;
        this.start = 0;
        this.end = 0;
        this.interval = 0;
    }

    public int getStartTime() {
        return this.start;
    }

    public int getEndTime() {
        return this.end;
    }

    public int getRepeatedInterval() {
        return this.interval > 0
                ? this.interval
                : 0;
    }

    /**
     * If the task is a non-repetitive one, it becomes repetitive
     */
    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public boolean isRepeated() {
        return this.interval > 0 ? true : false;
    }

    /**
     * returns the next start time of the task execution after the current time given.
     * If after the specified time the task is not executed anymore, the method return -1
     */
    public int nextTimeAfter(int current) {
        int nextTime = 0;

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
