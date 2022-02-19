package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range exampleRange, hugeRange, verySmallRange, negativeRange, noRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	
    	exampleRange = new Range(-1, 1);
    	hugeRange = new Range(-999999995, 999999999);
    	verySmallRange = new Range(-0.0000000001, 0);
    	negativeRange = new Range(-999999999, -299999999);
    	noRange=new Range(0, 0);
    }

    @Test
    public void intersectsWithinIntersectNoRange() {
        assertTrue(noRange.intersects(0, 0));    
        
    }
    
    @Test
    public void reverseParameterShouldIntersectexampleRange() {
        assertTrue(exampleRange.intersects(0.5, -0.5));    
        
    }

    @Test
    public void intersectsWithinIntersectexampleRange() {
        assertTrue(exampleRange.intersects(-0.5, 0));    
        
    }
    
    
    
    
    @Test
    public void intersectsWithinIntersecthugeRange() {   
        assertTrue(hugeRange.intersects(-999999997, 999999999));      
    }
    
    @Test
    public void intersectsWithinIntersectverySmallRange() {       
        assertTrue(verySmallRange.intersects(-0.00000000001, 0));      
    }
    
    @Test
    public void intersectsWithinIntersectnegativeRange() {       
        assertTrue(negativeRange.intersects(-999999998, -299999999));
        
    }
    
    
    @Test
    public void intersectsShouldNotIntersectexampleRange() {
        assertFalse(exampleRange.intersects(-1.5, -1.1));
        
        
    }
    
    @Test
    public void intersectsShouldNotIntersecthugeRange() {
        assertFalse(hugeRange.intersects(-999999999, -999999998));    
    }
    
    @Test
    public void intersectsShouldNotIntersectverySmallRange() {       
        assertFalse(verySmallRange.intersects(1,2));        
    }
    
    @Test
    public void intersectsShouldNotIntersectnegativeRange() {
        
        assertFalse(negativeRange.intersects(1, 3));
        
    }
    
    @Test
    public void intersectsPartiallyIntersectexampleRange() {
    	assertTrue(exampleRange.intersects(-2, -0.1));
        
        
    }
    
    @Test
    public void intersectsPartiallyIntersecthugeRange() {
    	assertTrue(hugeRange.intersects(-999999999, -599999998));    
    }
    
    @Test
    public void intersectsPartiallyIntersectverySmallRange() {       
    	assertTrue(verySmallRange.intersects(-0.00000000001,5));        
    }
    
    @Test
    public void intersectsPartiallyIntersectnegativeRange() {
        
    	assertTrue(negativeRange.intersects(-599999998, 3));
        
    }
    
   

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
