package com.aiswarya.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldReturnHead() {
        assertEquals(new EmptyList<Integer>().append(10).getHead().toString(), "10");
        assertEquals(new EmptyList<Integer>().append(10).append(20).getHead().toString(), "20");
        assertEquals(new EmptyList<Integer>().append(10).map(i -> i + 1).getHead().toString(), "11");
        assertEquals(new EmptyList<Integer>().append(10).append(20).map(i -> i + 1).getHead().toString(), "21");
        assertEquals(new EmptyList<Integer>().append(10).append(20).map(i -> i + 1).map(i -> i * 2).getHead().toString(), "42");

    }

    @Test
    public void shouldReturnNullHead() {
        assertNull(new EmptyList<Integer>().getHead());
        assertNull(new EmptyList<Integer>().map(i -> i + 1).getHead());
    }
}
