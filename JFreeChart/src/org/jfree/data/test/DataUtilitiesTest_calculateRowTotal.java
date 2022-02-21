package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;


public class DataUtilitiesTest_calculateRowTotal {
	Mockery mockingContext;
	Values2D values;
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
		

    }
	
	
	@Test
	public void calculateRowTotalFirstRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(15.0, result, .000000001d);
	    
	    
	}
	
	@Test
	public void calculateRowTotalMiddleRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(1, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 1);
	            will(returnValue(2.5));
	            one(values).getValue(1, 2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals(15.0, result, .000000001d);
	    
	    
	}
	
	@Test
	public void calculateRowTotalLastRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(7.5));
	            one(values).getValue(2, 1);
	            will(returnValue(2.5));
	            one(values).getValue(2, 2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, 2);
		assertEquals(15.0, result, .000000001d);
	    
	    
	}
	
	@Test
	public void calculateRowTotalWithSumOf0AndFirstRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(-10));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0,result,  .000000001d);
	    
	}
	
	public void calculateRowTotalWithMinValueAndFirstRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(Double.MIN_VALUE));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(-2.5));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(Double.MIN_VALUE, result, .000000001d);
	    
	}
	
	@Test
	public void calculateRowTotalWithMaxValueRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(Integer.MAX_VALUE,0);
	            will(returnValue(7.5));
	            one(values).getValue(Integer.MAX_VALUE,1);
	            will(returnValue(2.5));
	            one(values).getValue(Integer.MAX_VALUE,2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE);
		assertEquals(15.0, result, .000000001d);
	    
	}
	
	@Test
	public void calculateRowTotalWithMinValueRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(Integer.MIN_VALUE,0);
	            will(returnValue(7.5));
	            one(values).getValue(Integer.MIN_VALUE,1);
	            will(returnValue(2.5));
	            one(values).getValue(Integer.MIN_VALUE,2);
	            will(returnValue(5.0));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, Integer.MIN_VALUE);
		assertEquals(15.0, result, .000000001d);
	    
	}
	
	@Test
	public void calculateRowTotalWithMaxValueAndFirstRow() {
		
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(Double.MAX_VALUE));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(-2.5));
	        }
	    });
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(Double.MAX_VALUE, result, .000000001d);
	    
	    
	}
	
	
	
	
	
	

	

}
