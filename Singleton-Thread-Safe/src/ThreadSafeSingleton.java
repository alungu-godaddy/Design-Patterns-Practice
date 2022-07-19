public class ThreadSafeSingleton {
    // Declare instance volatile so that the double checked lock would work.
    private static volatile ThreadSafeSingleton instance = null;

    public String name;

    private ThreadSafeSingleton(String name) {
        this.name = name;
    }

    public static ThreadSafeSingleton getInstance(String name) {
        // Double-checked locking in order to prevent race condition. By checking the
        // existence criteria before entering the synchronized block, coupled with
        // the volatile attribute, prevents creating more singleton instances.
        // Ex: Thread 1 first checks from main memory if the instance was created (!= null)
        // then proceeds to create it and write it directly back to main memory.
        // Therefore, checking before writing to memory forces the jvm to acquire the latest version of
        // the instance variable, preventing multiple instances of singleton that may arise from the delay
        // of propagating to memory.
        ThreadSafeSingleton test = instance;
        if (test != null) {
            return test;
        }
        synchronized (ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton(name);
            }
            return instance;
        }
    }

    public String getName() {
        return name;
    }
}
