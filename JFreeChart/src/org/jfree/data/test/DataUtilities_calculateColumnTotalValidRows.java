package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilities_calculateColumnTotalValidRows extends DataUtilities {
	
	Mockery mockingContext;
	Values2D values;
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);

    }
	//All valid
	@Test
	public void calculateColumnTotalAllRowsValidFirstColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {0,1,2});
		assertEquals(result, 15.0, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalAllRowsValidMiddleColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 1, new int[] {0,1,2});
		assertEquals(result, 15.0, .000000001d);
	    
	}
	
	@Test
	public void calculateColumnTotalAllRowsValidLastColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {0,1,2});
		assertEquals(result, 15.0, .000000001d);
	    
	}
	//one row valid, first column

	@Test
	public void calculateColumnTotalFirstRowValidFirstColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {0});
		assertEquals(result, 7.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalMiddleRowValidFirstColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {1});
		assertEquals(result, 2.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalLastRowValidFirstColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {2});
		assertEquals(result, 5.0, .000000001d);
	    
	}
	//one row valid, middle column
	@Test
	public void calculateColumnTotalFirstRowValidMiddleColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 1, new int[] {0});
		assertEquals(result, 7.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalMiddleRowValidMiddleColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 1, new int[] {1});
		assertEquals(result, 2.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalLastRowValidMiddleColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {2});
		assertEquals(result, 5.0, .000000001d);
	    
	}
	//one row valid, last column
	@Test
	public void calculateColumnTotalFirstRowValidLastColumn() {
		
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

		double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {0});
		assertEquals(result, 7.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalMiddleRowValidLastColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {1});
		assertEquals(result, 2.5, .000000001d);
	    
	}
	@Test
	public void calculateColumnTotalLastRowValidLastColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {2});
		assertEquals(result, 5.0, .000000001d);
	    
	}	
	//Two rows valid
	@Test
	public void calculateColumnTotalFirstAndLastRowValidFirstColumn() {
		
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
		
		double result = DataUtilities.calculateColumnTotal(values, 0, new int[] {0,2});
		assertEquals(result, 12.5, .000000001d);
	    
	}
	//Two rows valid
		@Test
		public void calculateColumnTotalMiddleAndLastRowValidLastColumn() {
			
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(7.5));
		            one(values).getValue(1, 2);
		            will(returnValue(3.5));
		            one(values).getValue(2, 2);
		            will(returnValue(5.0));
		        }
		    });
			
			double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {1,2});
			assertEquals(result, 8.5, .000000001d);
		    
		}
		//Invalid rows
		@Test
		public void calculateColumnTotalInvalidRowFirstColumn() {
			
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(7.5));
		            one(values).getValue(1, 2);
		            will(returnValue(3.5));
		            one(values).getValue(2, 2);
		            will(returnValue(5.0));
		        }
		    });
			
			double result = DataUtilities.calculateColumnTotal(values, 2, new int[] {3});
			assertEquals(result, 0, .000000001d);
		    
		}
	
}
