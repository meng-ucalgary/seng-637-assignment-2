package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import static org.junit.Assert.*;
import org.junit.*;
import org.jmock.*;

public class DataUtilitiesTest_calculateRowTotalValidColumns {
    private Mockery mockingContext;
    private Values2D values;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
    }

    @Test
    public void calculateRowTotalFirstRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);

    }

    @Test
    public void calculateRowTotalLastRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 1 });
        assertEquals(result, 3.14, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);

    }

    @Test
    public void calculateRowTotalMiddleRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidLastolumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstAndLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 2 });
        assertEquals(12.39, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleAndLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 1, 2 });
        assertEquals(8.37, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowInvalidColumnAUB() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 3 });
        assertEquals(0.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowInvalidColumnAUBAndOneValidColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 2, 3 });
        assertEquals(5.23, result, .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
