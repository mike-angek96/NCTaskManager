package mx.edu.j2se.liborio.tasks;

import java.util.Iterator;
import java.util.Objects;

public class LinkedTaskList extends AbstractTaskList implements Cloneable{

    private Node head;
    private int numNodes;

    public LinkedTaskList() {
        head = null;
    }

    @Override
    public void add(Task data) {
        if (head == null) {
            head = new Node(data);
            numNodes++;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
        numNodes++;
    }

    /**
     * @throws IllegalArgumentException
     */
    public boolean remove(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than 0");
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
        return true;
    }

    @Override
    public void printTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    @Override
    public int size() {
        return numNodes;
    }

    /**
     * @throws IllegalArgumentException
     */
    @Override
    public Task getTask(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than 0");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * This method return a linkedlist of tasks that are scheduled for execution at least once after the "from" time, and not later than the "to" time
     */
    public LinkedTaskList incoming(int from, int to) throws IllegalArgumentException {
        if (from <= 0 || to <= 0) {
            throw new IllegalArgumentException("Values cannot be less or equals than 0");
        }

        LinkedTaskList subList = new LinkedTaskList();

        Node temp = head;
        while (temp != null) {
            if (temp.data.isRepeated() && (temp.data.getStartTime() >= from && temp.data.getEndTime() <= to)) {
                subList.add(temp.data);
                temp = temp.next;
            }
            if (!temp.data.isRepeated() && (temp.data.getTime() >= from && temp.data.getTime() <= to)) {
                subList.add(temp.data);
                temp = temp.next;
            }
        }
        return subList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        return numNodes == that.numNodes && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, numNodes);
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                ", numNodes=" + numNodes +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new DataIterator();
    }

    @Override
    public LinkedTaskList clone() {
        try {
            LinkedTaskList clone = (LinkedTaskList) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private class Node {
        private Node next;
        private Task data;

        public Node(Task data) {
            this.data = data;
        }

        public Task getData() {
            return this.data;
        }
    }

    private class DataIterator implements Iterator {
        Node current;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object data = current.getData();
            current = current.next;
            return data;
        }
    }
}
