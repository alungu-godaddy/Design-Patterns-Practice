package naive;

/***
 * Naive Singleton Implementation.
 */
public class NaiveSingleton {
    // Singleton instance to be returned whenever static method is called.
    private static NaiveSingleton instance = null;
    private String name;

    private NaiveSingleton(String name) {
        this.name = name;
    }

    // Static method accessed by driver code.
    public static NaiveSingleton getInstance(String name) {
        if (instance == null) {
            instance = new NaiveSingleton(name);
        }
        return instance;
    }

    // getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
