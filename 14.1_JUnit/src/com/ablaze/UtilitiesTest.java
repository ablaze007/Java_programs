package com.ablaze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities u;

    @Before
    public void setup() {
        u = new Utilities();
    }
    @Test
    public void everyNthChar() {
        assertArrayEquals("el".toCharArray(), u.everyNthChar("Hello".toCharArray(),2));
        assertArrayEquals("Hello".toCharArray(), u.everyNthChar("Hello".toCharArray(),10));
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF", u.removePairs("AABCDDEFF"));
        assertEquals("ABCDE", u.removePairs("ABCDE"));
        assertEquals("A", u.removePairs("A"));
        assertNull(u.removePairs(null));
    }

    @Test (expected = ArithmeticException.class)
    public void converter() {
        u.converter(10, 0);
        assertEquals(200, u.converter(10,5));
    }

    @Test
    public void nullIfOddLength() {
        assertNotNull(u.nullIfOddLength("Hello!"));
        assertNull(u.nullIfOddLength("Hello"));
    }
}