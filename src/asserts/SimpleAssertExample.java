package asserts;

/**
 * Created by a.talismanov on 26.07.2016.
 */
public class SimpleAssertExample {
    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(factorial(-1));
    }

    /**
     * jvm flag -ea needed
     */
    private static int factorial(int n) {
        assert (n >= 0);

        return n;
    }
}
