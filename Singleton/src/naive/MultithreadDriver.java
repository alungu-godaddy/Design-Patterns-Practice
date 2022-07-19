package naive;

import java.lang.Runnable;
import java.lang.Thread;

/**
 * Driver code that test whether multithreading works with the singleton pattern.
 */
public class MultithreadDriver {
    public static void main(String[] args) {
        new Thread(new ThreadFirst()).start();
        new Thread(new ThreadSecond()).start();
    }

    public static class ThreadFirst implements Runnable {
        @Override
        public void run() {
            NaiveSingleton naiveSingleton = NaiveSingleton.getInstance("Andrei");
            System.out.println(naiveSingleton.getName());
        }
    }

    public static class ThreadSecond implements Runnable {
        @Override
        public void run() {
            NaiveSingleton naiveSingleton = NaiveSingleton.getInstance("Test");
            System.out.println(naiveSingleton.getName());
        }
    }
}
