package mx.edu.j2se.liborio.tasks;

public class Main {

    public static void main(String[] args) {

        Task irFiesta = new Task("ir a mi cumpleaños", 8);
        irFiesta.getTime();
        irFiesta.setActive(true);
        System.out.println(irFiesta);

        Task estudiar = new Task("leer", 12, 7, 2);
        estudiar.setActive(true);
        System.out.println(estudiar);

        Task correr = new Task("correr", 4, 11, 2);
        System.out.println(correr.nextTimeAfter(3));
        System.out.println(correr.nextTimeAfter(4));
        System.out.println(correr.nextTimeAfter(5));
        System.out.println(correr.nextTimeAfter(10));
        System.out.println(correr.nextTimeAfter(11));
        System.out.println(correr.nextTimeAfter(12));
        System.out.println(correr);
    }

}
