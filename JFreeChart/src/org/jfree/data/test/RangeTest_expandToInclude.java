package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
 
public class RangeTest_expandToInclude {
	private Range testRange;
	
	@Before
    public void setUp() throws Exception { 
    	
		testRange = new Range(-10, 10);
    	
    }
	
	@Test
    public void expandToIncludeWithInputBLB() {
        assertEquals("Testing epanding range to include value BLB", new Range(-11, 10), Range.expandToInclude(testRange, -11));       
    }
	
	@Test
    public void expandToIncludeWithInputLB() {
        assertEquals("Testing epanding range to include value at LB (range shouldn't change)", new Range(-10, 10), Range.expandToInclude(testRange, -10));       
    }
	@Test
    public void expandToIncludeWithInputALB() {
        assertEquals("Testing epanding range to include value ALB (range shouldn't change)", new Range(-10, 10), Range.expandToInclude(testRange, -9));       
    }

	@Test
    public void expandToIncludeWithInputBUB() {
        assertEquals("Testing epanding range to include value BUB (range shouldn't change)", new Range(-10, 10), Range.expandToInclude(testRange, -9));       
    }
	
	@Test
    public void expandToIncludeWithInputUB() {
        assertEquals("Testing epanding range to include value at UB (range shouldn't change)", new Range(-10, 10), Range.expandToInclude(testRange, 10));       
    }
	@Test
    public void expandToIncludeWithInputAUB() {
        assertEquals("Testing epanding range to include value AUB ", new Range(-10, 11), Range.expandToInclude(testRange, 11));       
    }
	@Test
    public void expandToIncludeWithInputDoubleMax() {
        assertEquals("Testing epanding range to include max double", new Range(-10, Double.MAX_VALUE), Range.expandToInclude(testRange, Double.MAX_VALUE));       
    }
	@Test
    public void expandToIncludeWithInputNegativeDoubleMax() {
        assertEquals("Testing epanding range to include negative max double", new Range(-Double.MAX_VALUE, 10), Range.expandToInclude(testRange, -Double.MAX_VALUE));       
    }
	
}
