package com.classpractice7;

public class TriangleClassify {
	private int side1;
	private int side2;
	private int side3;

	public void setSide(int s1, int s2, int s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}

	public int getSide1() {
		return side1;
	}

	public int getSide2() {
		return side2;
	}

	public int getSide3() {
		return side3;
	}

	public boolean isTriangle() {
		if ((side1 < side2 + side3) && (side2 < side1 + side2) && (side3 < side2 + side1))// Here is a bug, The correct
																							// expression will be
																							// (side2<side1+side3)
			return true;
		else
			return false;
	}

	public String classify() {
		if (side1 < 1 || side1 > 200 || side2 < 1 || side2 > 200 || side3 < 1 || side3 > 200)
			return "OUT_OF_RANGE";
		if (!isTriangle())
			return "IsNotTriangle";
		if (side1 == side2 && side2 == side3)
			return "EQUILATERAL";
		if (side1 != side2 && side1 != side3 && side2 != side3)
			return "SCALENE";
		return "ISOSCELES";
	}
}
