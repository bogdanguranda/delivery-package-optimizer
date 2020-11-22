package com.bogdanguranda.deliverypackageoptimizer.printer;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TestStandardOutputResultPrinter {

    private static final String MINUS = "-";
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";
    private static final Double DEFAULT_PACKAGE_LIMIT = 100.0;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ResultPrinter resultPrinter = new StandardOutputResultPrinter();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintWhenNullPackageExpectMinus() {
        resultPrinter.print(null);
        assertEquals(MINUS + NEW_LINE, out.toString());
    }

    @Test
    public void testPrintWhenNoItemsExpectMinus() {
        Package noItemsPackage = new Package();
        resultPrinter.print(noItemsPackage);
        assertEquals(MINUS + NEW_LINE, out.toString());
    }

    @Test
    public void testPrintWhenOneItemExpectIdButNoComma() {
        Integer itemId = 1;
        Item item = new Item(itemId, 15.3, 50);
        Package oneItemPackage = new Package(DEFAULT_PACKAGE_LIMIT, Collections.singletonList(item));
        resultPrinter.print(oneItemPackage);
        assertEquals(itemId + NEW_LINE, out.toString());
    }

    @Test
    public void testPrintWhenMultipleItemsExpectIdsSeparatedByCommas() {
        Integer itemId1 = 1;
        Integer itemId2 = 2;
        Integer itemId3 = 3;
        Item item1 = new Item(itemId1, 15.3, 50);
        Item item2 = new Item(itemId2, 24.0, 10);
        Item item3 = new Item(itemId3, 13.5, 42);
        Package multipleItemsPackage = new Package(DEFAULT_PACKAGE_LIMIT, Arrays.asList(item1, item2, item3));
        resultPrinter.print(multipleItemsPackage);
        assertEquals(itemId1 + COMMA + itemId2 + COMMA + itemId3 + NEW_LINE, out.toString());
    }
}
