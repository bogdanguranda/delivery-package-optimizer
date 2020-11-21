package com.bogdanguranda.deliverypackageoptimizer;

import org.junit.Before;
import org.junit.Test;

public class TestDeliveryPackageOptimizer {

    @Before
    public void setUp() {

    }

    /**
     * Test that if the file given does not exist a message is prompted to the user.
     */
    @Test
    public void testFileMissing() {
        DeliveryPackageOptimizer.main(new String[]{""});

    }
}