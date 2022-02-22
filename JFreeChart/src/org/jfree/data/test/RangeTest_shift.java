package org.jfree.data.test;

import static org.junit.Assert.*;import org.jfree.data.Range;
import org.junit.*; import org.junit.Test;

public class RangeTest_shift {
	private Range originRange;
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { originRange = new Range(0.0, 0.0);
    }

    
    @Test
    public void shiftRightToMaxValueAtZeroRangeAllowZeroCrossing() {
		Range rangeShift = Range.shift(originRange, Double.MAX_VALUE, true);
		Range expected = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
		assertTrue("A shift of Double.MAX_VALUE should return a range of (Double.MAX_VALUE, Double.MAX_VALUE)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftRightAtZeroRangeDisallowZeroCrossing() {
		Range rangeShift = Range.shift(originRange, 4.0, false);
		Range expected = new Range(4.0, 4.0);
		assertTrue("A shift of 4.0 should return a range of (4.0, 4.0)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftLeftToMinValueAtZeroRangeAllowZeroCrossing() {
		Range rangeShift = Range.shift(originRange, Double.MIN_VALUE, true);
		Range expected = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
		assertTrue("A shift of Double.MIN_VALUE should return a range of (Double.MIN_VALUE, Double.MIN_VALUE)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftLeftAtZeroRangeDisallowZeroCrossing() {
		Range rangeShift = Range.shift(originRange, -5.0, false);
		Range expected = new Range(-5.0, -5.0);
		assertTrue("A shift of -5.0 should return a range of (-5.0, -5.0)", rangeShift.equals(expected));		
	}
    
    
    @Test
    public void shiftRightNegativeRangeAllowZeroCrossingForLbAndUb() {
    	Range negativeRange = new Range(-10.0, -5.0);
		Range rangeShift = Range.shift(negativeRange, 15.0, true);
		Range expected = new Range(5.0, 10.0);
		assertTrue("A shift of 15.0 should return a range of (5.0, 10.0)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftRightNegativeRangeDisallowZeroCrossingForLbAndUb() {
    	Range negativeRange = new Range(-10.0, -5.0);
		Range rangeShift = Range.shift(negativeRange, 18.0, false);
		Range expected = new Range(0.0, 0.0);
		assertTrue("A shift of 18.0 should return a range of (0.0, 0.0)", rangeShift.equals(expected));
	}
    
    
    
    @Test
    public void shiftLeftPostiveRangeAllowZeroCrossingForLbAndUb() {
    	Range positiveRange = new Range(5.0, 7.0);
		Range rangeShift = Range.shift(positiveRange, -10.0, true);
		Range expected = new Range(-5.0, -3.0);
		assertTrue("A shift of -10.0 should return a range of (-5.0, -3.0)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftLeftPostiveRangeDisallowZeroCrossingForLbAndUb() {
    	Range positiveRange = new Range(5.0, 7.0);
		Range rangeShift = Range.shift(positiveRange, -9.0, false);
		Range expected = new Range(0.0, 0.0);
		assertTrue("A shift of -9.0 should return a range of (0.0, 0.0)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftRightNegativeLbAndPostiveUbRangeDisallowZeroCrossing() {
    	Range range = new Range(-3.0, 7.0);
		Range rangeShift = Range.shift(range, 6.0, false);
		Range expected = new Range(0.0, 13.0);
		assertTrue("A shift of 6.0 should return a range of (0.0, 13.0)", rangeShift.equals(expected));		
	}
    
    @Test
    public void shiftLeftNegativeLbAndPostiveUbRangeDisallowZeroCrossing() {
    	Range range = new Range(-3.0, 7.0);
		Range rangeShift = Range.shift(range, -8.0, false);
		Range expected = new Range(-11.0, 0.0);
		assertTrue("A shift of -8.0 should return a range of (-11.0, 0.0)", rangeShift.equals(expected));		
	}   
    
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
