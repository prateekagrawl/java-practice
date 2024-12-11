package io.javabrains;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MathUtilsTest {

    @Test //@Test tells JUnit engine it needs to run method with this annotation
    void test() {
//        System.out.println("This test ran");
//        fail("Not yet implemented");

        MathUtils mathUtils = new MathUtils();
        int expected = 1;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method should add two nos.");

    }
}
