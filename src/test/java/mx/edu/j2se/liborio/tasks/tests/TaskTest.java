package mx.edu.j2se.liborio.tasks.tests;

import org.junit.Test;

import static org.junit.Assert.*;

import mx.edu.j2se.liborio.tasks.Task;

public class TaskTest {

    @Test
    public void testNonRepetitiveTask() {
        Task todo = new Task("Ir al mecanico para revisar el carro", 8);
        assertEquals(todo.getTitle().getClass(), String.class);

        assertFalse(todo.isActive());
        todo.setActive(true);
        assertTrue(todo.isActive());

        assertEquals(8, todo.getTime());
        assertFalse(todo.isRepeated());
        assertEquals(8, todo.getStartTime());
    }


    @Test
    public void testRepetitiveTask() {
        Task todo = new Task("ir a correr en la tarde", 2, 9, 2);
        assertFalse(todo.isActive());
        todo.setActive(true);
        assertTrue(todo.isActive());

        assertEquals(2, todo.getStartTime());
        assertEquals(9, todo.getEndTime());
        assertEquals(2, todo.getRepeatedInterval());
        assertEquals(2, todo.getTime());
        assertTrue(todo.isRepeated());
    }

    @Test
    public void testRepetitiveTask_nextTimeAfter() {
        Task todo = new Task("ir a correr en la tarde", 2, 9, 2);
        assertEquals(2, todo.nextTimeAfter(1));
        assertEquals(4, todo.nextTimeAfter(3));
        assertEquals(8, todo.nextTimeAfter(6));
        assertEquals(-1, todo.nextTimeAfter(8));
        assertEquals(-1, todo.nextTimeAfter(9));
        assertEquals(-1, todo.nextTimeAfter(11));
    }

    @Test
    public void testNonRepetitiveTask_nextTimeAfter(){
        Task todo = new Task("ir a la cena de clausura", 9);
        assertEquals(9, todo.nextTimeAfter(7));
    }
}