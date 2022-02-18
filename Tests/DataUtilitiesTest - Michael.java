package org.jfree.data.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.jfree.data.DataUtilities;

import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;


public class DataUtilitiesTest {
	Mockery mockingContext;
	Values2D values;
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);

    }

	@Test
	public void testNormalNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testNegativeColumnNormalNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, -5);
	            will(returnValue(7.5));
	            one(values).getValue(1, -5);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, -5);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testLargeNumberColumnNormalNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 99999);
	            will(returnValue(7.5));
	            one(values).getValue(1, 99999);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 99999);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testColumnNegativeNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, -5.0, .000000001d);
	    
	}
	
	@Test
	public void testColumnLargeNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(999999999));
	            one(values).getValue(1, 0);
	            will(returnValue(1));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 1000000000, .000000001d);
	    
	}
	
	@Test
	public void testColumnSmallNumbersCalculateColumnTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(0.0000000000000000001));
	            one(values).getValue(1, 0);
	            will(returnValue(0.0000000000000000001));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 0.0000000000000000002, 0.0000000000000000001d);
	    
	}
	
	@Test
	public void testNormalNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testNegativeRowNormalNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(-5, 0);
	            will(returnValue(7.5));
	            one(values).getValue(-5, 1);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, -5);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testLargeNumberRowNormalNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(99999, 0);
	            will(returnValue(7.5));
	            one(values).getValue(99999, 1);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 99999);
		assertEquals(result, 10.0, .000000001d);
	    
	}
	
	@Test
	public void testRowNegativeNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(result, -5.0, .000000001d);
	    
	}
	
	@Test
	public void testRowLargeNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(999999999));
	            one(values).getValue(0, 1);
	            will(returnValue(1));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(result, 1000000000, .000000001d);
	    
	}
	
	@Test
	public void testRowSmallNumbersCalculateRowTotalValues2DInt() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(0.0000000000000000001));
	            one(values).getValue(0, 1);
	            will(returnValue(0.0000000000000000001));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(result, 0.0000000000000000002, 0.0000000000000000001d);
	    
	}

	
}
