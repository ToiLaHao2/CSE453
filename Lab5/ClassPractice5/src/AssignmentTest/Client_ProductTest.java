package AssignmentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Assignment.Client_Product;

public class Client_ProductTest {

    // Rule 1: Female, City dweller, under 35
    @Test
    public void testFemaleCityYoung() {
        Client_Product cp = new Client_Product();
        // Note: Although the decision table sample used "City_Dwellers",
        // the code expects "Yes" to indicate a city dweller.
        cp.setInput("Female", "Yes", 34);
        // Expected: "W X and Y" (young females get W, all (except older females) get X, and city-resident females get Y)
        assertEquals("W X and Y", cp.assignProduct());
    }
    
    // Rule 2: Female, City dweller, between 35 and 65
    @Test
    public void testFemaleCityMiddleAged() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "Yes", 40);
        // Expected: "X and Y"
        assertEquals("X and Y", cp.assignProduct());
    }
    
    // Rule 3: Female, City dweller, over 65
    @Test
    public void testFemaleCityOlder() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "Yes", 70);
        // Expected: "Only Y"
        assertEquals("Only Y", cp.assignProduct());
    }
    
    // Rule 4: Female, Non-city dweller, under 35
    @Test
    public void testFemaleNonCityYoung() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 30);
        // Expected: "W and X"
        assertEquals("W and X", cp.assignProduct());
    }
    
    // Rule 5: Female, Non-city dweller, between 35 and 65
    @Test
    public void testFemaleNonCityMiddleAged() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 50);
        // Expected: "Only X"
        assertEquals("Only X", cp.assignProduct());
    }
    
    // For a Female, Non-city dweller over 65, no rule applies so default remains.
    @Test
    public void testFemaleNonCityOlder() {
        Client_Product cp = new Client_Product();
        cp.setInput("Female", "No", 70);
        // Expected: "No Product"
        assertEquals("No Product", cp.assignProduct());
    }
    
    // Rule 6: Male, City dweller (all ages should get Only X)
    @Test
    public void testMaleCityYoung() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 25);
        assertEquals("Only X", cp.assignProduct());
    }
    
    @Test
    public void testMaleCityMiddleAged() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 45);
        assertEquals("Only X", cp.assignProduct());
    }
    
    @Test
    public void testMaleCityOlder() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "Yes", 75);
        assertEquals("Only X", cp.assignProduct());
    }
    
    // Rule 7: Male, Non-city dweller, under 35
    @Test
    public void testMaleNonCityYoung() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 25);
        // Expected: "Only X" (since product Z is for middle-aged males only)
        assertEquals("Only X", cp.assignProduct());
    }
    
    // Rule 8: Male, Non-city dweller, middle-aged (35-65)
    @Test
    public void testMaleNonCityMiddleAged() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 45);
        // Expected: "Only Z" per specification.
        // BUG: Due to the bug, the method returns "W and Z".
        assertEquals("Only Z", cp.assignProduct());
    }
    
    // Rule 9: Male, Non-city dweller, over 65
    @Test
    public void testMaleNonCityOlder() {
        Client_Product cp = new Client_Product();
        cp.setInput("Male", "No", 75);
        // Expected: "Only X"
        assertEquals("Only X", cp.assignProduct());
    }
}
