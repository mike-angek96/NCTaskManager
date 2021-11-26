package mx.edu.j2se.liborio.tasks.tests;

import mx.edu.j2se.liborio.tasks.LinkedTaskList;
import mx.edu.j2se.liborio.tasks.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedTaskListTest {
    @Test
    public void testLinkedList() {
        Task estudiar = new Task("leer", 5, 7, 2);
        Task correr = new Task("correr", 4, 11, 2);
        Task testEstudiar = new Task("leer", 5, 7, 2);

        LinkedTaskList linkedTaskList = new LinkedTaskList();
        linkedTaskList.add(estudiar);
        linkedTaskList.add(correr);

        assertEquals(testEstudiar.getTitle(), linkedTaskList.getTask(0).getTitle());
        assertEquals(2, linkedTaskList.size());
        assertTrue(linkedTaskList.remove(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinkedListException() {
        Task estudiar = new Task("leer", 5, 7, 2);
        LinkedTaskList linkedTaskList = new LinkedTaskList();
        linkedTaskList.add(estudiar);
        linkedTaskList.getTask(-1);
    }
}