package test;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.Set;

public class SetTest {

    @Test
    public void testInsertAndMember() {
        Set set = new Set();
        
        set.insert(5);
        set.insert(3);
        set.insert(8);
        set.insert(5);
        
        int[] expected = {3, 5, 8};
        assertArrayEquals(expected, set.toArray());

        assertTrue(set.member(3));
        assertTrue(set.member(5));
        assertTrue(set.member(8));
        assertFalse(set.member(10));
    }

    @Test
    public void testSection() {
        Set set1 = new Set();
        Set set2 = new Set();
  
        set1.insert(1);
        set1.insert(3);
        set1.insert(5);
        set1.insert(7);
        
        set2.insert(3);
        set2.insert(7);
        set2.insert(9);

        set1.section(set2);

        int[] expected = {1, 5};
        assertArrayEquals(expected, set1.toArray());
    }

    @Test
    public void testContainsArithTriple() {
        Set set = new Set();

        set.insert(1);
        set.insert(2);
        set.insert(4);
        assertFalse(set.containsArithTriple());

        set.insert(3);
        set.insert(5);
        assertTrue(set.containsArithTriple());
    }

    @Test
    public void testToArray() {
        Set set = new Set();
        
        assertArrayEquals(new int[]{}, set.toArray());

        set.insert(10);
        set.insert(20);
        int[] expected = {10, 20};
        assertArrayEquals(expected, set.toArray());
    }
}
