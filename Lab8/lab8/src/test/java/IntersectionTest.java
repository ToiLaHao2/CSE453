import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.lab8.Intersection;

public class IntersectionTest {
    Intersection intersection;

    @BeforeEach
    void setUp() throws Exception {
        intersection = new Intersection();
    }

    @ParameterizedTest
    @CsvSource({ "2, 3, -1, 1,Intersecting Point: -2.0-5.0",
            "4, 5, 4, 7,Intersecting Point: -3.0-8.0",
            "3, 5, 3, 5,Intersecting Point: -1.00.0",
            "2, 2, 3, 3,These are parallel lines. No Intersection between the lines.",
            "2, 3, 4, 4,These are coincidental lines.No Intersection between the lines" })
    void test(float m1, float m2, float c1, float c2, String result) {
        assertEquals(result, intersection.findIntersection(m1, m2, c1, c2));
    }
}
