import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.lab8.Quadric_Equation;

public class Quadric_EquationTest {
    Quadric_Equation quadric_Equation;

    @BeforeEach
    void setUp() throws Exception {
        quadric_Equation = new Quadric_Equation();
    }

    @ParameterizedTest
    @CsvSource({ "0, 2, 3,Not a quadratic equation",
            "1, 5, 6,Real Roots",
            "1, 2, 1,Roots are equal",
            "2, 2, 2,Imaginary roots",
            "-1, 5, 6,Invalid input",
            "1, 5, 101,Invalid input", })
    void testEquivalenceClassPartition(int a, int b, int c, String result) {
        assertEquals(result, quadric_Equation.calculateroot(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({ "0, 100, 100,Not a quadratic equation",
            "1, 0, 100,Imaginary roots",
            "1, 100, 0,Real Roots",
            "1, 100, 50,Real Roots",
            "1, 50, 100,Real Roots",
            "100, 50, 50,Imaginary roots",
            "201, 100, 100,Invalid input",
            "1, -1, 100,Invalid input",
            "1, 100, 201,Invalid input", })
    void testBoundaryValueAnalysis(int a, int b, int c, String result) {
        assertEquals(result, quadric_Equation.calculateroot(a, b, c));
    }
}
