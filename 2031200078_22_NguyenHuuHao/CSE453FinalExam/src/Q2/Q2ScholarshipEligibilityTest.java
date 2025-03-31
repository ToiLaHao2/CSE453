package Q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Q2ScholarshipEligibilityTest {

    @Test
    void testInvalidGPA_BelowMinimum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(-0.1, 5, 100));
    }

    @Test
    void testGPA_AtMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(0.0, 5, 100));
    }

    @Test
    void testGPA_AboveMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(0.1, 5, 100));
    }

    @Test
    void testGPA_AtMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(4.0, 5, 100));
    }

    @Test
    void testGPA_BelowMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(3.9, 5, 100));
    }

    @Test
    void testInvalidGPA_AboveMaximum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(4.1, 5, 100));
    }

    @Test
    void testInvalidExtracurricular_BelowMinimum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(3.5, -1, 100));
    }

    @Test
    void testExtracurricular_AtMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 0, 100));
    }

    @Test
    void testExtracurricular_AboveMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 1, 100));
    }

    @Test
    void testExtracurricular_AtMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 10, 100));
    }

    @Test
    void testExtracurricular_BelowMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 9, 100));
    }

    @Test
    void testInvalidExtracurricular_AboveMaximum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 11, 100));
    }

    @Test
    void testInvalidVolunteerHours_BelowMinimum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, -1));
    }

    @Test
    void testVolunteerHours_AtMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, 0));
    }

    @Test
    void testVolunteerHours_AboveMinimum() {
        assertEquals("Not eligible", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, 1));
    }

    @Test
    void testVolunteerHours_AtMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, 300));
    }

    @Test
    void testVolunteerHours_BelowMaximum() {
        assertEquals("Full scholarship", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, 299));
    }

    @Test
    void testInvalidVolunteerHours_AboveMaximum() {
        assertEquals("Invalid", ScholarshipEligibility.calculateScholarshipEligibility(3.5, 5, 301));
    }
}
