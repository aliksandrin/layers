package com.javaextreme.tests;

import categories.IntegrationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Category(IntegrationTest.class)
public class ITMainApplication {
    private ByteArrayOutputStream output;


    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test(expected = NullPointerException.class)
    public void main() {

    }
}