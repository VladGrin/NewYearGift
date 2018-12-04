package com.newyeargift.model;

import com.newyeargift.model.sweets.Chocolate;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightComparatorTest {

    @Test
    public void compare() {
        WeightComparator weightComparator = new WeightComparator();
        Sweet sweet1 = new Chocolate("aaa", 20);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Sweet sweet3 = new Chocolate("ccc", 20);
        assertTrue(weightComparator.compare(sweet1, sweet2) < 0);
        assertTrue(weightComparator.compare(sweet2, sweet1) > 0);
        assertEquals(0, weightComparator.compare(sweet3, sweet1));
    }
}