package com.aiswarya.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilteredListTest {
    ValueList<Integer> list;

    @Before
    public void setup() {
        list = new EmptyList<Integer>().append(10).append(21).append(30).append(40).append(50);
    }

    @Test
    public void shouldReturnNullHead() {
        assertNull(new EmptyList<Integer>().getHead());
        assertNull(new EmptyList<Integer>().filter(i -> i % 2 == 0).getHead());
    }

    @Test
    public void testBasicFilter() {
        Assert.assertEquals("40", list.filter(a -> a % 2 == 0).getHead().toString());
        Assert.assertEquals("30", list.filter(a -> a % 3 == 0).getHead().toString());
    }

    @Test
    public void testChainedFilter() {

        Assert.assertEquals("21", list.filter(a -> a % 3 == 0)
                                          .filter(a -> a % 7 == 0).getHead().toString());
        Assert.assertNull(list.filter(a -> a % 3 == 0).filter(a -> a % 7 == 0).filter(a -> a % 10 == 0).getHead());
        Assert.assertNull(list.filter(a -> a % 9 == 0).filter(a -> a % 10 == 0).getHead());
        Assert.assertEquals("22", list.map(a -> a + 1).filter(a -> a % 11 == 0).getHead().toString());
        Assert.assertEquals("35", list.filter(a -> a%3 ==0).map(a->a+5).getHead().toString());
        //Assert.assertEquals("26", list.filter(a -> a%3 ==0).map(a->a+5).filter(a->a%2==0).toString());
        System.out.println(list);
        System.out.println(list.filter(a->a%3==0));
    }
}