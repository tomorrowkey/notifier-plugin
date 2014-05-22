package com.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void test() {
        assertThat("Hello", is("Hello"));
    }

}
