package com.javaextreme.tests;

import org.junit.After;
import org.junit.BeforeClass;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class OutputStreamTest {
    protected final static ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUpBeforeAll() {
        System.setOut(new PrintStream(output, true));

    }

    @After
    public void clear() {
        System.setOut(null);
    }
}
