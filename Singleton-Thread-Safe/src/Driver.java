import java.lang.Thread;
import java.lang.Runnable;

public class Driver {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Andrei");
            System.out.println(singleton.getName());
        };

        Runnable runnable2 = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Test");
            System.out.println(singleton.getName());
        };

        // Notice that start order does not necessarily mean the first runnable will have the singleton.
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
