package Lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class TwoNumbersSumTest {

    @Test
    void testAddTwoNumbers_SameLengthNoCarry() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5, 7, 9));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_SameLengthWithCarry() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 1, 1));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1, 0));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_DifferentLengthNoCarry() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(3, 4, 5));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 5, 7));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_DifferentLengthWithCarry() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0, 0));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_EmptyFirstList() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_EmptySecondList() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_BothListsEmpty() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_WithCarryInTheMiddle() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(2, 7, 8));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(6, 5, 4));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(9, 3, 2));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }

    @Test
    void testAddTwoNumbers_WithMultipleCarries() {
        TwoNumbersSum tns = new TwoNumbersSum();
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(9, 9, 9));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 9, 9, 8));
        assertEquals(expected, tns.addTwoNumbers(first, second));
    }
}
