package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest_isNaNRange {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.exampleRange = new Range(-10, 10);
    }

    @Test
    public void isNaNRangeWithBothBoundNOM() {
        assertEquals("Testing the range that has different NOM bounds", false, this.exampleRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithBothBoundSameNOM() {
        Range testRange = new Range(10, 10);
        assertEquals("Testing the range that has same NOM bounds", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithLowerBoundMin() {
        Range testRange = new Range(-Double.MAX_VALUE, 10);
        assertEquals("Testing the range that has lower bound as minimum possible value", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithUpperBoundMax() {
        Range testRange = new Range(10, Double.MAX_VALUE);
        assertEquals("Testing the range that has upper bound as maximum possible value", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithLowerBoundNaN() {
        Range testRange = new Range(Double.NaN, 10);
        assertEquals("Testing the range that has lower bound as NaN", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithUpperBoundNaN() {
        Range testRange = new Range(-10, Double.NaN);
        assertEquals("Testing the range that has upper bound as NaN", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithBothBoundNaN() {
        Range testRange = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing the range that has both bounds as NaN", true, testRange.isNaNRange());

    }

    @After
    public void tearDown() throws Exception {
        this.exampleRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
