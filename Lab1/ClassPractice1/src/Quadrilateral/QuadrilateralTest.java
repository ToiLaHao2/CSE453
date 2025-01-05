package Quadrilateral;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QuadrilateralTest {
    private Quadrilateral quad;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    @Test
    public void testIsSquare() { // fix bug in here

        p1 = new Point(1, 1);
        p2 = new Point(4, 1);
        p3 = new Point(4, 4);
        p4 = new Point(1, 4);

        quad = new Quadrilateral(p1, p2, p3, p4);
        assertTrue(quad.isSquare());
    }

    @Test
    public void testIsRectangle() { // fix bug in here
        p1 = new Point(1, 1);
        p2 = new Point(5, 1);
        p3 = new Point(5, 4);
        p4 = new Point(1, 4);

        quad = new Quadrilateral(p1, p2, p3, p4);

        System.out.println(quad);
        assertTrue(quad.isRectangle());
    }

}
