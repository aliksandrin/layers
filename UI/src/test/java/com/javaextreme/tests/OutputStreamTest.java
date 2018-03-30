package com.javaextreme.tests;

import org.junit.After;
import org.junit.BeforeClass;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class OutputStreamTest {
    protected static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static PrintStream original;

    @BeforeClass
    public static void setUpBeforeAll() {
        original = System.out;
        System.setOut(new PrintStream(output));

    }

    @After
    public void clear() {
        System.setOut(original);
    }
}
