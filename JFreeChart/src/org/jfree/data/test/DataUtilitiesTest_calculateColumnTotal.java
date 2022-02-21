package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;


public class DataUtilitiesTest_calculateColumnTotal {
	Mockery mockingContext;
	Values2D values;
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
		

    }
	
	
	@Test
	public void calculateColumnTotalAllRowsFirstColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(15.0, result, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalAllRowsMiddleColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 1);
	            will(returnValue(7.5));
	            one(values).getValue(1, 1);
	            will(returnValue(2.5));
	            one(values).getValue(2, 1);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(15, result, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalAllRowsLastColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 2);
	            will(returnValue(7.5));
	            one(values).getValue(1, 2);
	            will(returnValue(2.5));
	            one(values).getValue(2, 2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals(15.0,result,  .000000001d);
	    
	}
	@Test	
	public void calculateColumnTotalWithMaxValueAndFirstColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(Double.MAX_VALUE));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(-2.5));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(Double.MAX_VALUE, result, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalWithMinValueAndFirstColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(Double.MIN_VALUE));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(-2.5));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(Double.MIN_VALUE, result, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWithMaxValueColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, Integer.MAX_VALUE);
	            will(returnValue(7.5));
	            one(values).getValue(1, Integer.MAX_VALUE);
	            will(returnValue(2.5));
	            one(values).getValue(2, Integer.MAX_VALUE);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE);
		assertEquals(15.0, result, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWithMinValueColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, Integer.MIN_VALUE);
	            will(returnValue(7.5));
	            one(values).getValue(1, Integer.MIN_VALUE);
	            will(returnValue(2.5));
	            one(values).getValue(2, Integer.MIN_VALUE);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateColumnTotal(values, Integer.MIN_VALUE);
		assertEquals(15.0, result, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWithSumOf0AndFirstColumn() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(-10));
	        }
	    });
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	    
	}
	
	
	

	

}
