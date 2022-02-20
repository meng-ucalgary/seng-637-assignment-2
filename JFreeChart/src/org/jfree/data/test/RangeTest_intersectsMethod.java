package org.jfree.data.test;


import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;


public class RangeTest_intersectsMethod {
	private Range testRange;
	
	@Before
    public void setUp() throws Exception { 
    	
		testRange = new Range(-10, 10);
    	
    	
    }
	
	@Test
    public void intersectWithInputBLBAndLB() {
        assertFalse(testRange.intersects(-15, -10));    
        
    }
	
	@Test
    public void intersectWithInputBLBAndALB() {
        assertTrue(testRange.intersects(-15, -8));    
        
    }
    
	@Test
    public void intersectWithInputBLBAndAUB() {
        assertTrue(testRange.intersects(-15, 15));    
        
    }
	
	@Test
    public void intersectWithInputLBAndALB() {
        assertTrue(testRange.intersects(-10, 7));    
        
    }
	
	
	@Test
    public void intersectWithInputLBAndUB() {
        assertTrue(testRange.intersects(-10, 10));    
        
    }
	
	@Test
    public void intersectWithInputNOMAndNOM() {
        assertTrue(testRange.intersects(-1, 1));    
        
    }
	
	@Test
    public void intersectWithInputBUBAndUB() {
        assertTrue(testRange.intersects(9, 10));    
        
    }
	
	@Test
    public void intersectWithInputUBAndAUB() {
        assertTrue(testRange.intersects(10, 15));    
        
    }
	
	@Test
    public void intersectWithInputMINAndAUB() {
        assertTrue(testRange.intersects(Double.MIN_VALUE, 15));    
        
    }
	
	@Test
    public void intersectWithInputBLBAndMAX() {
        assertTrue(testRange.intersects(-15, Double.MAX_VALUE));    
        
    }
	
	@Test
    public void intersectWithInput0And0() {
        assertTrue(testRange.intersects(0, 0));    
        
    }
	
	@Test
    public void intersectWithInputNaNAnd1() {
        assertTrue(testRange.intersects(Double.NaN, 1));    
        
    }
	
	
	
    
}
