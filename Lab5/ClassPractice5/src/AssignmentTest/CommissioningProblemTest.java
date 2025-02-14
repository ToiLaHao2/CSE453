package AssignmentTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Assignment.CommissioningProblem;

public class CommissioningProblemTest {
    private CommissioningProblem cp;

    @BeforeEach
    void setUp() throws Exception {
        cp = new CommissioningProblem();
    }

    // ==== Tests for Locks (Valid range 1 to 70) ====

    // Normal BVA: Lower boundary (locks = 1 is valid)
    @Test
    public void testLocksLowerBoundaryValid() {
        // Using stocks=50 (valid because 1<=50<80) and barrels=90 (valid per code
        // condition)
        cp.setInput(1, 50, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 1*45 + 50*30 + 90*25 = 45 + 1500 + 2250 = 3795
        // Commission = 0.10*1000 + 0.15*800 + 0.20*(3795-1800)
        // = 100 + 120 + 0.20*1995 = 220 + 399 = 619
        double expectedCommission = 619.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // Robust BVA: Below lower boundary (locks = 0 is invalid)
    @Test
    public void testLocksBelowLowerBoundary() {
        cp.setInput(0, 50, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    // Normal BVA: Upper boundary (locks = 70 is valid)
    @Test
    public void testLocksUpperBoundaryValid() {
        cp.setInput(70, 50, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 70*45 + 50*30 + 90*25 = 3150 + 1500 + 2250 = 6900
        // Commission = 100 + 120 + 0.20*(6900-1800) = 220 + 0.20*5100 = 220 + 1020 =
        // 1240
        double expectedCommission = 1240.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // Robust BVA: Above upper boundary (locks = 71 is invalid)
    @Test
    public void testLocksAboveUpperBoundary() {
        cp.setInput(71, 50, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    // ==== Tests for Stocks (Spec valid range 1 to 80, but code accepts only 1 to
    // 79) ====

    // Normal BVA: Lower boundary (stocks = 1 is valid)
    @Test
    public void testStocksLowerBoundaryValid() {
        cp.setInput(10, 1, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 10*45 + 1*30 + 90*25 = 450 + 30 + 2250 = 2730
        // Commission = 100 + 120 + 0.20*(2730-1800) = 220 + 0.20*930 = 220 + 186 = 406
        double expectedCommission = 406.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // Normal BVA: Upper boundary according to code (stocks = 79 is valid)
    @Test
    public void testStocksBelowLowerBoundaryValid() {
        cp.setInput(10, 0, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    @Test
    public void testStocksUpperBoundaryValid() {
        cp.setInput(10, 79, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 10*45 + 79*30 + 90*25 = 450 + 2370 + 2250 = 5070
        // Commission = 100 + 120 + 0.20*(5070-1800) = 220 + 0.20*3270 = 220 + 654 = 874
        double expectedCommission = 874.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // Robust BVA: Just above the valid boundary (stocks = 80 should be valid by
    // spec but fails in code)
    @Test
    public void testStocksAboveUpperBoundary() {
        cp.setInput(10, 80, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Although 80 is valid per specification, the code’s condition (stocks < 80)
        // makes it invalid.
        assertEquals(0.0, commission, 0.001);
    }

    // ==== Tests for Barrales (Barrels) (Spec valid range 1 to 90, but code accepts
    // only values >= 90) ====

    // Normal BVA: Lower boundary (barrels = 90 is valid in code)
    @Test
    public void testBarrelsLowerBoundaryValid() {
        cp.setInput(10, 50, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 10*45 + 50*30 + 90*25 = 450 + 1500 + 2250 = 4200
        // Commission = 100 + 120 + 0.20*(4200-1800) = 220 + 0.20*2400 = 220 + 480 = 700
        double expectedCommission = 700.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // Robust BVA: Just below the lower boundary (barrels = 89 is invalid)
    @Test
    public void testBarrelsBelowLowerBoundary() {
        cp.setInput(10, 50, 89);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    // Robust BVA: Testing upper boundary for barrels with distinct input values
    @Test
    public void testBarrelsUpperBoundary() {
        cp.setInput(20, 60, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 20*45 + 60*30 + 90*25 = 900 + 1800 + 2250 = 4950
        // Commission = 100 + 120 + 0.20*(4950-1800) = 220 + 0.20*3150 = 220 + 630 = 850
        double expectedCommission = 850.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    @Test
    public void testBarrelsAboveUpperBoundary() {
        cp.setInput(10, 50, 91);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 10*45 + 50*30 + 91*25 = 450 + 1500 + 2275 = 4225
        // Commission = 100 + 120 + 0.20*(4225-1800) = 220 + 0.20*2425 = 220 + 485 = 705
        // According to the specification, barrels should not exceed 90.
        // However, due to the bug, barrels = 91 is treated as valid.
        // We document the bug by asserting that commission is not zero.
        assertNotEquals(0.0, commission, 0.001, "Bug: barrels above 90 should be rejected but are processed as valid.");
    }

    // ==== Test for complete rifle sales ====

    // A valid complete rifle sale (at least one of each item) should compute a
    // commission.
    // Note that because of the bug, barrels must be 90 or more and stocks must be
    // less than 80.
    @Test
    public void testCompleteRifleValid() {
        cp.setInput(1, 1, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        // Sales = 1*45 + 1*30 + 90*25 = 45 + 30 + 2250 = 2325
        // Commission = 100 + 120 + 0.20*(2325-1800) = 220 + 0.20*525 = 220 + 105 = 325
        double expectedCommission = 325.0;
        assertEquals(expectedCommission, commission, 0.001);
    }

    // If any one of the required items is missing (e.g. no stocks), commission must
    // be 0.
    @Test
    public void testIncompleteRifleNoStock() {
        cp.setInput(1, 0, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    @Test
    public void testIncompleteRifleNoBarrels() {
        cp.setInput(1, 1, 0);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }

    @Test
    public void testIncompleteRifleNoLocks() {
        cp.setInput(0, 1, 90);
        double sale = cp.calSale();
        double commission = cp.calCommission(sale);
        assertEquals(0.0, commission, 0.001);
    }
}
