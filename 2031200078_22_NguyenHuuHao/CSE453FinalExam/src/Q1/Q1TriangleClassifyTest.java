package Q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Q1TriangleClassifyTest {
    TriangleClassify triangle;

    @BeforeEach
    void setUp() {
        triangle = new TriangleClassify();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2, 2, EQUILATERAL", // Lower boundary
            "10, 10, 10, EQUILATERAL", // Upper boundary
            "2, 10, 10, ISOSCELES", // Extreme value at lower bound
            "10, 2, 10, ISOSCELES", // Extreme value at upper bound
            "10, 10, 2, ISOSCELES", // Edge case where one side is smallest
            "9, 6, 2, NOT_A_TRIANGLE", // Not a triangle case
            "3, 4, 5, SCALENE", // Classic scalene triangle
            "10, 10, 2, ISOSCELES", // Another isosceles case
            "10, 9, 9, ISOSCELES" // Large value scalene case
    })
    void testClassify(int s1, int s2, int s3, String expected) {
        triangle.setSide(s1, s2, s3);
        assertEquals(expected, triangle.classify());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 10, 10, OUT_OF_RANGE", // Below minimum
            "10, 0, 10, OUT_OF_RANGE",
            "10, 10, 0, OUT_OF_RANGE",
            "201, 10, 10, OUT_OF_RANGE", // Above maximum
            "10, 201, 10, OUT_OF_RANGE",
            "10, 10, 201, OUT_OF_RANGE",
            "-1, 10, 10, OUT_OF_RANGE", // Negative values
            "10, -1, 10, OUT_OF_RANGE",
            "10, 10, -1, OUT_OF_RANGE"
    })
    void testOutOfRange(int s1, int s2, int s3, String expected) {
        triangle.setSide(s1, s2, s3);
        assertEquals(expected, triangle.classify());
    }

    @Test
    void testInvalidTriangle() {
        triangle.setSide(2, 6, 9);
        assertEquals("NOT_A_TRIANGLE", triangle.classify());
    }

    @Test
    void testBugFix_isTriangleLogic() {
        triangle.setSide(3, 3, 6);
        assertEquals("NOT_A_TRIANGLE", triangle.classify(),
                "Bug: The isTriangle() method has an incorrect logic for checking triangle inequality");
    }
}