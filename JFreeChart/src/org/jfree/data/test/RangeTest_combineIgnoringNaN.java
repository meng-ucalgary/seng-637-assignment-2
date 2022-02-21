package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest_combineIgnoringNaN {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.exampleRange = new Range(-10, 10);
    }

    @Test
    public void combineIgnoringNaNWithSmallerRange() {
        Range r2 = new Range(-5, 6);
        assertEquals("Testing combining with already included range", new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithDisjointRange() {
        Range r2 = new Range(20, 50);
        assertEquals("Testing combining with disjoint range", new Range(-10, 50),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithNull() {
        Range r2 = null;
        assertEquals("Testing combining with null", this.exampleRange, Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLowerBoundMinimum() {
        Range r2 = new Range(-Double.MAX_VALUE, -20);
        assertEquals("Testing combining with range that has lower bound as minimum possible value",
                new Range(-Double.MAX_VALUE, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLowerBoundNaN() {
        Range r2 = new Range(Double.NaN, -20);
        assertEquals("Testing combining with range that has lower bound as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLB() {
        Range r2 = new Range(-10, 20);
        assertEquals("Testing combining with range that has lower bound as LB",
                new Range(-10, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithALB() {
        Range r2 = new Range(-9.99999, 20);
        assertEquals("Testing combining with range that has lower bound as ALB",
                new Range(-10, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBLB() {
        Range r2 = new Range(-10.00001, 20);
        assertEquals("Testing combining with range that has lower bound as BLB",
                new Range(-10.00001, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUpperBoundMaximum() {
        Range r2 = new Range(20, Double.MAX_VALUE);
        assertEquals("Testing combining with range that has upper bound as maximum possible value",
                new Range(-10, Double.MAX_VALUE),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUpperBoundNaN() {
        Range r2 = new Range(20, Double.NaN);
        assertEquals("Testing combining with range that has upper bound as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUB() {
        Range r2 = new Range(-20, 10);
        assertEquals("Testing combining with range that has upper bound as UB",
                new Range(-20, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithAUB() {
        Range r2 = new Range(-20, 10.00001);
        assertEquals("Testing combining with range that has upper bound as AUB",
                new Range(-20, 10.00001),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBUB() {
        Range r2 = new Range(-20, 9.99999);
        assertEquals("Testing combining with range that has upper bound as BUB",
                new Range(-20, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBothBoundNaN() {
        Range r2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing combining with range that has both bounds as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithZeroRange() {
        Range r2 = new Range(0, 0);
        assertEquals("Testing combining with range that spans 0 to 0 has effective range of 0",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithItself() {
        assertEquals("Testing combining the range with itself", this.exampleRange,
                Range.combineIgnoringNaN(this.exampleRange, this.exampleRange));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
