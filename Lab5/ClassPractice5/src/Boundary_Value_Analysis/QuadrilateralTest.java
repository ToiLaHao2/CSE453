package Boundary_Value_Analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QuadrilateralTest {
	private Quadrilateral Q;

	@BeforeEach
	void setUp() throws Exception {
		Q = new Quadrilateral();

	}

	@DisplayName("Normal Boundary Value Test")
	@ParameterizedTest(name = "topSide= {0},bottomSide= {1},leftSide= {2}," + "rightSide={3},ExpectedResult= {4}")
	@CsvSource({ "100,100,100,1,General", "100,100,100,2,General", "100,100,100,100,Square", "100,100,100,199,General",
			"100,100,100,200,General", "100,100,1,100,General", "100,100,2,100,General", "100,100,199,100,General",
			"100,100,200,100,General", "100,1,100,100,Trapezoid", "100,2,100,100,Trapezoid",
			"100,199,100,100,Trapezoid", "100,200,100,100,Trapezoid", "1,100,100,100,Trapezoid",
			"2,100,100,100,Trapezoid", "199,100,100,100,Trapezoid", "200,100,100,100,Trapezoid" })
	void testQuadrilateral1(int topSide, int bottomSide, int leftSide, int rightSide, String result) {
		Q.setSide(topSide, bottomSide, leftSide, rightSide);
		assertEquals(result, Q.classify());
	}

	@DisplayName("Robust Boundary Value Test")
	@ParameterizedTest(name = "topSide= {0},bottomSide= {1},leftSide= {2}," + "rightSide={3},ExpectedResult= {4}")
	@CsvSource({ "100,100,100,1,General", "100,100,100,0,OUT_OF_RANGE", "100,100,100,2,General",
			"100,100,100,100,Square", "100,100,100,199,General", "100,100,100,200,General",
			"100,100,100,201,OUT_OF_RANGE", "100,100,0,100,OUT_OF_RANGE", "100,100,1,100,General",
			"100,100,2,100,General", "100,100,199,100,General", "100,100,200,100,General",
			"100,100,201,100,OUT_OF_RANGE", "100,0,100,100,OUT_OF_RANGE", "100,1,100,100,Trapezoid",
			"100,2,100,100,Trapezoid", "100,199,100,100,Trapezoid", "100,200,100,100,Trapezoid",
			"100,201,100,100,OUT_OF_RANGE", "0,100,100,100,OUT_OF_RANGE", "1,100,100,100,Trapezoid",
			"2,100,100,100,Trapezoid", "199,100,100,100,Trapezoid", "200,100,100,100,Trapezoid",
			"201,100,100,100,OUT_OF_RANGE" })
	void testQuadrilateral2(int topSide, int bottomSide, int leftSide, int rightSide, String result) {
		Q.setSide(topSide, bottomSide, leftSide, rightSide);
		assertEquals(result, Q.classify());
	}

}
