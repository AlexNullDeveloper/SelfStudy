package threads.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("запуск потока " + name);
        try {
            System.out.println("поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("поток " + name + " освобожает разрешение");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("запуск потока " + name);
        try {
            System.out.println("поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("поток " + name + " освобожает разрешение");
        sem.release();
    }
}