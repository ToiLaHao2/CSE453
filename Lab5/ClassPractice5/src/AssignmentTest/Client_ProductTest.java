package AssignmentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Assignment.Client_Product;

public class Client_ProductTest {

    // R1: Female, City Dweller, Age <35 → Expected: "W X and Y"
    @Test
    public void testR1_FemaleCityUnder35() {
        Client_Product cp = new Client_Product();
        // NOTE: The decision table sample uses "City_Dwellers", but the code checks for
        // "Yes".
        cp.setInput("Female", "Yes", 34);
        // Expected per decision table is "W X and Y"
        assertEquals("W X and Y", cp.assignProduct());
    }

    // R2: Female, City Dweller, Age 35–65 → Expected: "X and Y"
    @Test
    public void testR2_FemaleCityBetween35And65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "Yes", 50);
        assertEquals("X and Y", cp.assignProduct());
    }

    // R3: Female, City Dweller, Age >65 → Expected: "Only Y"
    @Test
    public void testR3_FemaleCityOver65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "Yes", 70);
        assertEquals("Only Y", cp.assignProduct());
    }

    // R4: Female, Non-City Dweller, Age <35 → Expected: "W and X"
    @Test
    public void testR4_FemaleNonCityUnder35() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 30);
        assertEquals("W and X", cp.assignProduct());
    }

    // R5: Female, Non-City Dweller, Age 35–65 → Expected: "Only X"
    @Test
    public void testR5_FemaleNonCityBetween35And65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 50);
        assertEquals("Only X", cp.assignProduct());
    }

    // R6: Female, Non-City Dweller, Age >65 → Expected: "No Product"
    @Test
    public void testR6_FemaleNonCityOver65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 70);
        assertEquals("No Product", cp.assignProduct());
    }

    // R7: Male, City Dweller, Age <35 → Expected: "Only X"
    @Test
    public void testR7_MaleCityUnder35() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 25);
        assertEquals("Only X", cp.assignProduct());
    }

    // R8: Male, City Dweller, Age 35–65 → Expected: "Only X"
    @Test
    public void testR8_MaleCityBetween35And65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 45);
        assertEquals("Only X", cp.assignProduct());
    }

    // R9: Male, City Dweller, Age >65 → Expected: "Only X"
    @Test
    public void testR9_MaleCityOver65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 75);
        assertEquals("Only X", cp.assignProduct());
    }

    // R10: Male, Non-City Dweller, Age <35 → Expected: "Only X"
    @Test
    public void testR10_MaleNonCityUnder35() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 25);
        assertEquals("Only X", cp.assignProduct());
    }

    // R11: Male, Non-City Dweller, Age 35–65 → Expected: "Only Z"
    @Test
    public void testR11_MaleNonCityBetween35And65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 45);
        // Expected per specification is "Only Z".
        // BUG: Due to the code, this test returns "W and Z" instead.
        assertEquals("Only Z", cp.assignProduct());
    }

    // R12: Male, Non-City Dweller, Age >65 → Expected: "Only X"
    @Test
    public void testR12_MaleNonCityOver65() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 75);
        assertEquals("Only X", cp.assignProduct());
    }
}
