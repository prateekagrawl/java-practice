package medium;

public class Autoboxing {
    public static void main(String[] args) {

        /**
         * Integer Caching for Optimization: To optimize memory usage, Java caches Integer objects for values between -128 and 127.
         * So, when you use autoboxing with an int value within this range, Java reuses an existing Integer instance from a cache
         * instead of creating a new one every time.
         *
         * The == operator for primitive types checks for value equality,
         * meaning it checks whether the values of x and y are the same.
         *
         * Integer a = 100;  // Uses cached Integer instance
         * Integer b = 100;  // Reuses the cached Integer instance
         * System.out.println(a == b);  // true, both reference the same object
         * */

        Integer a = 100;  // Uses cached Integer instance
        Integer b = 100;  // Reuses the cached Integer instance
        System.out.println(a == b);  // true, both reference the same object


        Integer c = 200;  // Creates a new Integer instance
        Integer d = 200;  // Creates another new Integer instance
        System.out.println(c == d);  // false, they are different objects


        int x = 1;
        int y = 1;
        System.out.println(x == y);
    }
}
