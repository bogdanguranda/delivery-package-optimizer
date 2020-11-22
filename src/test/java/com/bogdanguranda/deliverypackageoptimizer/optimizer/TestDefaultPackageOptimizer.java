package com.bogdanguranda.deliverypackageoptimizer.optimizer;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestDefaultPackageOptimizer {

    private PackageOptimizer packageOptimizer = new DefaultPackageOptimizer();

    /**
     * Test that if no item is given the result package is empty.
     */
    @Test
    public void testWhenNoItemThenResultIsEmpty() {
        UseCase useCase = new UseCase(100.0,
                Arrays.asList()
        );
        Package optimizedPackage = packageOptimizer.optimize(useCase);

        assertNull(optimizedPackage);
    }

    /**
     * Test that if 1 item is given that fits, the result package contains it.
     */
    @Test
    public void testWhen1ItemFitsThenIsInTheResult() {
        UseCase useCase = new UseCase(100.0,
                Arrays.asList(
                        new Item(1, 30.4, 10)
                )
        );
        Package optimizedPackage = packageOptimizer.optimize(useCase);

        assertNotNull(optimizedPackage);
        assertEquals(100, optimizedPackage.getWeightLimit(), 0.0);
        assertNotNull(optimizedPackage.getItems());
        assertEquals(1, optimizedPackage.getItems().size());

        Item item = optimizedPackage.getItems().get(0);
        assertNotNull(item);
        assertEquals(1, (int) item.getId());
        assertEquals(30.4, item.getWeight(), 0.0);
        assertEquals(10, (int) item.getCost());
    }

    /**
     * Test that if 2 items are given that fit, the result package contains both.
     */
    @Test
    public void testWhen2ItemThatFitTheyAreInTheResult() {
        UseCase useCase = new UseCase(100.0,
                Arrays.asList(
                        new Item(1, 30.4, 10),
                        new Item(2, 19.6, 25)
                )
        );
        Package optimizedPackage = packageOptimizer.optimize(useCase);

        assertNotNull(optimizedPackage);
        assertEquals(100, optimizedPackage.getWeightLimit(), 0.0);
        assertNotNull(optimizedPackage.getItems());
        assertEquals(2, optimizedPackage.getItems().size());

        Item item1 = optimizedPackage.getItems().get(0);
        assertNotNull(item1);
        assertEquals(1, (int) item1.getId());
        assertEquals(30.4, item1.getWeight(), 0.0);
        assertEquals(10, (int) item1.getCost());

        Item item2 = optimizedPackage.getItems().get(1);
        assertNotNull(item2);
        assertEquals(2, (int) item2.getId());
        assertEquals(19.6, item2.getWeight(), 0.0);
        assertEquals(25, (int) item2.getCost());
    }

    /**
     * Test that if 3 items are given, but only two fit and are more expensive, the result package contains the two of them.
     */
    @Test
    public void testWhen3ItemsWhereTwoAreTheBestFitThenResultHasThem() {
        UseCase useCase = new UseCase(100.0,
                Arrays.asList(
                        new Item(1, 30.4, 10),
                        new Item(2, 90.0, 25),
                        new Item(3, 19.6, 25)
                )
        );
        Package optimizedPackage = packageOptimizer.optimize(useCase);

        assertNotNull(optimizedPackage);
        assertEquals(100, optimizedPackage.getWeightLimit(), 0.0);
        assertNotNull(optimizedPackage.getItems());
        assertEquals(2, optimizedPackage.getItems().size());

        Item item1 = optimizedPackage.getItems().get(0);
        assertNotNull(item1);
        assertEquals(1, (int) item1.getId());
        assertEquals(30.4, item1.getWeight(), 0.0);
        assertEquals(10, (int) item1.getCost());

        Item item2 = optimizedPackage.getItems().get(1);
        assertNotNull(item2);
        assertEquals(3, (int) item2.getId());
        assertEquals(19.6, item2.getWeight(), 0.0);
        assertEquals(25, (int) item2.getCost());
    }

    /**
     * Test that if 3 items are given and there are 2 possible combinations, the lower weight is taken.
     */
    @Test
    public void testWhen3ItemsWith2CombinationsExistThenResultHasTheLowerCostOne() {
        UseCase useCase = new UseCase(100.0,
                Arrays.asList(
                        new Item(1, 49.0, 10),
                        new Item(2, 50.0, 10),
                        new Item(3, 49.0, 10)
                )
        );
        Package optimizedPackage = packageOptimizer.optimize(useCase);

        assertNotNull(optimizedPackage);
        assertEquals(100, optimizedPackage.getWeightLimit(), 0.0);
        assertNotNull(optimizedPackage.getItems());
        assertEquals(2, optimizedPackage.getItems().size());

        Item item1 = optimizedPackage.getItems().get(0);
        assertNotNull(item1);
        assertEquals(1, (int) item1.getId());
        assertEquals(49.0, item1.getWeight(), 0.0);
        assertEquals(10, (int) item1.getCost());

        Item item2 = optimizedPackage.getItems().get(1);
        assertNotNull(item2);
        assertEquals(3, (int) item2.getId());
        assertEquals(49.0, item2.getWeight(), 0.0);
        assertEquals(10, (int) item2.getCost());
    }
}
