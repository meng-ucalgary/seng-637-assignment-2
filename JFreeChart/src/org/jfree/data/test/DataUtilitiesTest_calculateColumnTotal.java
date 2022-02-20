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
	public void calculateColumnTotalWith15And0() {
		
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
		assertEquals(result, 15.0, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWith0And0() {
		
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
		assertEquals(result, 0, .000000001d);
	    
	}
	
public void calculateColumnTotalWithMaxValueAnd0() {
		
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
		assertEquals(result, Double.MAX_VALUE, .000000001d);
	    
	}

	public void calculateColumnTotalWithmINValueAnd0() {
		
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
		assertEquals(result, Double.MIN_VALUE, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWith15AndMaxValue() {
		
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
		assertEquals(result, 15.0, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalWith15AndMinValue() {
		
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
		assertEquals(result, 15.0, .000000001d);
	    
	}
	
	
	

	

}
