package mx.edu.j2se.liborio.tasks.tests;

import mx.edu.j2se.liborio.tasks.ArrayTaskList;
import mx.edu.j2se.liborio.tasks.Task;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayTaskListTest {
    @Test
    public void testCreateTaskList(){
        ArrayTaskList taskList = new ArrayTaskList(2);
        Task nonRepetitiveTask = new Task("Cena en resturante de lujo", 8);
        taskList.add(nonRepetitiveTask);

        ArrayTaskList testTaskList = new ArrayTaskList(2);
        Task testNonRepetitiveTask = new Task("Cena en resturante de lujo", 8);
        testTaskList.add(testNonRepetitiveTask);

        assertEquals(testTaskList.size(), taskList.size());
        assertEquals(testTaskList.getTask(0).getTitle(),taskList.getTask(0).getTitle());
        assertEquals(testTaskList.getTask(0).getTime(),taskList.getTask(0).getTime());
    }

    @Test
    public void testRemoveFromTaskList(){
        ArrayTaskList taskList = new ArrayTaskList(1);
        Task repetitiveTask = new Task("correr", 1,9,2);
        taskList.add(repetitiveTask);

        assertTrue(taskList.remove(repetitiveTask));
    }

    @Test
    public void testGetTask(){
        ArrayTaskList taskList = new ArrayTaskList(1);
        Task repetitiveTask = new Task("correr", 1,9,2);
        taskList.add(repetitiveTask);

        ArrayTaskList testTaskList = new ArrayTaskList(1);
        Task testRepetitiveTask = new Task("correr", 1,9,2);
        testTaskList.add(testRepetitiveTask);

        assertEquals(testTaskList.getTask(0).getTitle(), taskList.getTask(0).getTitle());
        assertEquals(testTaskList.getTask(0).getStartTime(), taskList.getTask(0).getStartTime());
        assertEquals(testTaskList.getTask(0).getEndTime(), taskList.getTask(0).getEndTime());
        assertEquals(testTaskList.getTask(0).getRepeatedInterval(), taskList.getTask(0).getRepeatedInterval());
    }
}