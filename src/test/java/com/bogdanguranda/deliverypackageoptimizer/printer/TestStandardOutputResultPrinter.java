package com.bogdanguranda.deliverypackageoptimizer.printer;

import com.bogdanguranda.deliverypackageoptimizer.DeliveryPackageOptimizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestDefaultResultPrinter {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Test that if the file given does not exist a message is prompted to the user.
     */
    @Test
    public void testPrint() {
        DeliveryPackageOptimizer.main(new String[]{""});

    }
}
