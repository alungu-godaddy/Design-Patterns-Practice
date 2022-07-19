package naive;

public class SingleThreadDriver {
    public static void main(String[] args) {
        // Generate one instance
        NaiveSingleton naiveSingleton = NaiveSingleton.getInstance("Andrei");
        System.out.println(naiveSingleton.getName());

        // Generate another and compare names.
        naiveSingleton = NaiveSingleton.getInstance("Test");
        System.out.println(naiveSingleton.getName());
    }
}
