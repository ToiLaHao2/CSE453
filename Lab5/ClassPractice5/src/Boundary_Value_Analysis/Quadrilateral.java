package Boundary_Value_Analysis;

public class Quadrilateral {
	private int topSide, bottomSide, leftSide, rightSide;
	private String QuadrilateralType;

	public void setSide(int s1, int s2, int s3, int s4) {
		this.topSide = s1;
		this.bottomSide = s2;
		this.leftSide = s3;
		this.rightSide = s4;
	}

	public String classify() {
		boolean c1, c2, c3, c4;

		c1 = (1 <= topSide) && (topSide <= 200);
		c2 = (1 <= bottomSide) && (bottomSide <= 200);
		c3 = (1 <= leftSide) && (leftSide <= 200);
		c4 = (1 <= rightSide) && (rightSide <= 200);

		if (!c1 || !c2 || !c3 || !c4)
			QuadrilateralType = "OUT_OF_RANGE";
		else {
			if ((topSide != bottomSide) && (topSide != leftSide) && (topSide != rightSide) && (bottomSide != leftSide)
					&& (bottomSide != rightSide) && (rightSide != leftSide))
				QuadrilateralType = "Scalene Quadrilateral";
			if ((topSide == bottomSide) && (bottomSide == leftSide) && (leftSide == rightSide))
				QuadrilateralType = "Square";
			else if ((topSide == bottomSide) && (leftSide == rightSide) && (topSide != rightSide)
					&& (topSide != leftSide) && (bottomSide != leftSide) && (bottomSide != rightSide))
				QuadrilateralType = "Rectangle";
			else if ((leftSide == rightSide) && (topSide != bottomSide))
				QuadrilateralType = "Trapezoid";
			else if ((topSide == rightSide) && (bottomSide == leftSide) && (topSide != bottomSide)
					&& (rightSide != leftSide))
				QuadrilateralType = "Kite";
			else
				QuadrilateralType = "General";

		}
		return QuadrilateralType;
	}

}
