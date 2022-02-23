# Assignment 2 Report

**Topic** - Automated requirements based API Unit Testing using JUnit

## Table of Contents

- [Introduction](#introduction)
- [Video demo](#video-demo)
- [Detailed description of unit test strategy](#detailed-description-of-unit-test-strategy)
- [Test cases developed](#test-cases-developed)
- [Division of team work](#division-of-team-work)
- [Difficulties, challenges, and lessons learned](#difficulties-challenges-and-lessons-learned)
- [Comments and feedback](#comments-and-feedback)
- [Contributors](#contributors)

## Introduction

The objective of this assignment is to test five methods each of two classes - `org.jfree.data.Range` and `org.jfree.data.DataUtilities`.

The `Range` class is best described as representing an immutable range of values. For the `Range` class, functions can be static methods or instance methods that performed on a range.

`DataUtilities`, on the other hand, provides a set of utility methods to be used in different data classes, with the exception of datasets. The methods from which `DataUtilities` class will be tested on involves parameter from two interfaces; `Values2D` and `KeyedValues`. `Values2D` is a general purpose interface for accessing a table of values whereas `KeyedValues` is an interface assisting the storage of an ordered list of key-value pairs.

## Video demo

Link to the video demonstration of testing is _TBA_.

## Detailed description of unit test strategy

The test plan for `Range` and `DataUtilities` will be defined differently due to the differences of the two classes' functionalities.

#### `Range`

The below five methods are to be explored

- `shift(Range base, double delta, boolean allowZeroCrossing)`
- `isNaNRange()`
- `expandToInclude(Range range, double value)`
- `combineIgnoringNaN(Range range1, Range range2)`
- `intersects(double b0, double b1)`

For the range class, the range of -10 to 10 is used and testing of its methods will use input partitions that abides to the following BVT Test RANGE (Lower - Upper):

1 BLB - LB
1 BLB - 1 ALB
1 BLB - 1 AUB
LB - 1 ALB
LB - UB
NOM - NOM
1 BUB - UB
UB - 1 AUB
1 BLB - 1 AUB

[insert the boundary graph]

#### `DataUtilities`

The below five methods are to be explored. `jMock` is used to mock the interfaces `Values2D` and `KeyedValues` which are used as parameters to these methods

- `calculateColumnTotal(Values2D data, int column)`
- `calculateColumnTotal(Values2D data, int column, int[] validRows)`
- `calculateRowTotal(Values2D data, int row)`
- `calculateRowTotal(Values2D data, int row, int[] validCols)`
- `getCumulativePercentages(KeyedValues data)`

For the Values2D object, the input partition is a 3x3 matrix with which double values are used at each cell of the array from which the result is asserted. While the KeyedValues object's input partition is a Key-Value pair or a group of pairs.

[Insert keyed values stuff here]

## Test cases developed

| API method                                                 | Test method                                                                       | Input partitions                                      |
| ---------------------------------------------------------- | --------------------------------------------------------------------------------- | ----------------------------------------------------- |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftRightToMaxValueAtZeroRangeAllowZeroCrossing`                      | (0.0,0.0), Double.MAX_VALUE, true                     |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftRightAtZeroRangeDisallowZeroCrossing`                             | (0.0,0.0), 4.0, false                                 |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftLeftToMinValueAtZeroRangeAllowZeroCrossing`                       | (0.0,0.0), Double.MIN_VALUE, true                     |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftLeftAtZeroRangeDisallowZeroCrossing`                              | (0.0,0.0), -5.0, false                                |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftRightNegativeRangeAllowZeroCrossingForLbAndUb`                    | (-10.0,-5.0), 15.0, true                              |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftRightNegativeRangeDisallowZeroCrossingForLbAndUb`                 | (-10.0, -5.0), 18.0, false                            |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftLeftPostiveRangeAllowZeroCrossingForLbAndUb`                      | (5.0, 7.0), -10.0, true                               |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftLeftPostiveRangeDisallowZeroCrossingForLbAndUb`                   | (5.0, 7.0), -9.0, false                               |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftRightNegativeLbAndPostiveUbRangeDisallowZeroCrossing`             | (-3.0, 7.0), 6.0, false                               |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.shiftLeftNegativeLbAndPostiveUbRangeDisallowZeroCrossing`              | (-3.0, 7.0), -8.0, false                              |
| `Range.isNaNRange()`                                       | `RangeTest.*`                                                                     |                                                       |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputBLB`                                           | (-10,10), -11                                         |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputLB`                                            | (-10,10), -10                                         |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputALB`                                           | (-10,10), -9                                          |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputBUB`                                           | (-10,10), 9                                           |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputUB`                                            | (-10,10), 10                                          |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputAUB`                                           | (-10,-10) 11                                          |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputDoubleMax`                                     | (-10,10), Double.MAX_VALUE                            |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.expandToIncludeWithInputNegativeDoubleMax`                             | (-10,10), -Double.MAX_VALUE                           |
| `Range.combineIgnoringNaN(Range, Range)`                   | `RangeTest.*`                                                                     |                                                       |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInput0And0`                                               | (0,0)                                                 |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndALB`                                           | (-15,-8)                                              |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndAUB`                                           | (-15,15)                                              |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndLB`                                            | (-15,-10)                                             |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndMAX`                                           | (-15,Double.MAX_VALUE)                                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBUBAndUB`                                            | (9,10)                                                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputUBAndAUB`                                            | (10,15)                                               |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputLBAndALB`                                            | (-10,7)                                               |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputLBAndUB`                                             | (-10,-10)                                             |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputMINAndAUB`                                           | (Double.MIN_VALUE,15)                                 |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputNaNAnd1`                                             | (Double.NaN,1)                                        |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputNOMAndNOM`                                           | (-1,1)                                                |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalAllRowsFirstColumn`                        | [7.5,2.5,5.0], 0                                      |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalAllRowsLastColumn`                         | [7.5,2.5,5.0], 2                                      |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalAllRowsMiddleColumn`                       | [7.5,2.5,5.0], 1                                      |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMaxValueAndFirstColumn`                | [Double.MAX_VALUE,2.5,-2.5], 0                        |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMaxValueColumn`                        | [7.5,2.5,5.0], Double.MAX_VALUE                       |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMinValueAndFirstColumn`                | [Double.MIN_VALUE,2.5,-2.5], 0                        |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMinValueColumn`                        | [7.5,2.5,5.0], Double.MIN_VALUE                       |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithSumOf0AndFirstColumn`                  | [7.5,2.5,-10], 0                                      |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalAllRowsValidFirstColumn`                   | [7.5,2.5,5.0], 0 , [0,1,2]                            |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalAllRowsValidMiddleColumn`                  | [7.5,2.5,5.0], 1 , [0,1,2]                            |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalAllRowsValidLastColumn`                    | [7.5,2.5,5.0], 2 , [0,1,2]                            |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalFirstRowValidFirstColumn`                  | [7.5,2.5,5.0], 0 , [0]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalMiddleRowValidFirstColumn`                 | [7.5,2.5,5.0], 0 , [1]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalLastRowValidFirstColumn`                   | [7.5,2.5,5.0], 0 , [2]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalFirstRowValidMiddleColumn`                 | [7.5,2.5,5.0], 1 , [0]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalMiddleRowValidMiddleColumn`                | [7.5,2.5,5.0], 1 , [1]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalLastRowValidMiddleColumn`                  | [7.5,2.5,5.0], 1 , [2]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalFirstRowValidLastColumn`                   | [7.5,2.5,5.0], 2 , [0]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalMiddleRowValidLastColumn`                  | [7.5,2.5,5.0], 2 , [1]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalLastRowValidLastColumn`                    | [7.5,2.5,5.0], 2 , [2]                                |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalFirstAndLastRowValidFirstColumn`           | [7.5,2.5,5.0], 0 , [0,2]                              |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalInvalidRowAUBAndOneValidRowLastColumn`     | [7.5], 2 , [1,3]                                      |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalInvalidRowAUBMiddleColumn`                 | [], 1 , [1,2]                                         |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalInvalidRowBLBFirstColumn`                  | [], 0 , [-1]                                          |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalMaxRowsMaxColumn`                          | [2.5,5] ,Integer.MAX_VALUE, [0,Integer.MAX_VALUE]     |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalBelowMaxRowsBelowMaxColumn`                | [2.5,5] ,Integer.MAX_VALUE-1, [0,Integer.MAX_VALUE-1] |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.calculateColumnTotalWithMaxValue`                              | [2^53-1,1], 0 , [0,1]                                 |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalFirstRow`                                     | [7.5,2.5,5.0], 0                                      |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalLastRow`                                      | [7.5,2.5,5.0], 2                                      |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalMiddleRow`                                    | [7.5,2.5,5.0], 1                                      |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMaxValueAndFirstRow`                      | [Double.MAX_VALUE,2.5,-2.5], 0                        |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMaxValueRow()`                            | [7.5,2.5,5.0], Double.MAX_VALUE                       |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMinValueAndFirstRow`                      | [Double.MIN_VALUE,2.5,-2.5], 0                        |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMinValueRow`                              | [7.5,2.5,5.0], Double.MIN_VALUE                       |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithSumOf0AndFirstRow`                        | [7.5,2.5,-10], 0                                      |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | `DataUtilitiesTest.*`                                                             |                                                       |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.getCumulativePercentagesWithNoKeyedValues`                     | <>                                                    |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.getCumulativePercentagesWithOneRowKeyedValue`                  | <0, 2>                                                |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.getCumulativePercentagesWithOneKeyedValueHavingZeroValue`      | <0, 0>                                                |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.test_getCumulativePercentages_oneKeyedValue_nullValue`         | <0, null>                                             |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.getCumulativePercentagesWithKeyedValuesHavingNullAndMixValues` | <0, -4.5>, <1, 2>, <2, null>, <3, 12.5>, <4, 0>       |

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

## Division of team work

Each of the four tester will complete at least 1 unit testing of the `Range` class and 1 unit testing using `jMock` from the `DataUtilities` class. Group peer review will be done after the individual testings to ensure that the quality of work abides to the scope of the test plan. Below table summarizes the distribution of development of test cases.

| API method                                                 | Tester                   |
| ---------------------------------------------------------- | ------------------------ |
| `Range.shift(Range, double, boolean)`                      | Okeoghenemarho Obuareghe |
| `Range.isNaNRange()`                                       | Bhavyai Gupta            |
| `Range.expandToInclude(Range, double)`                     | Drew Burritt             |
| `Range.combineIgnoringNaN(Range, Range)`                   | Bhavyai Gupta            |
| `Range.intersects(double, double)`                         | Michael Man Yin Lee      |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | Michael Man Yin Lee      |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | Drew Burritt             |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | Michael Man Yin Lee      |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | Bhavyai Gupta            |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | Okeoghenemarho Obuareghe |

## Difficulties, challenges, and lessons learned

1. One of the challenges was to agree on the scope of testing. We used equivalence class partitions and boundary value testing to devise our input parameters to make sure we cover most possible test cases in a structured way without overburdening the team by explosive number of test cases.

2. Another challenge was to decide the setup parameters for the instance variables that would ultimately be used by all the test cases. This was overcome by thorough discussions on the setup parameters that would be ideal and would cover requirements for the maximum number of test cases for a given class.

3. Finally a difficulty that we encountered was related to runtime errors in the test cases developed for `DataUtilities`. After some troubleshooting, it was found that a library was missing. We had to download `hamcrest-2.2.jar` from external source and include it in the classpath in order to get the tests to work.

   The lesson learned from this was to not rely solely on what's given. We should visit the official website or mvncentral of the library that we are using to make sure all its dependencies are included too.

4. Mocking is a great way to mock objects. However, often times we have to guess the functionality of the object being mocked according to the given API specification. The specification may not give us true picture of what the code is doing. One of the highlight is the `DataUtilities.getCumulativePercentages` method, where API mentions "The percentages are values between 0.0 and 1.0". However, the actual cumulative percentages given as output from the method can be negative depending upon the input parameter `data`; this matches our manual calculations. This mismatch between the API and the actual working of the method can create doubts in the minds of tester whether they mocked the method correctly or not.

## Comments and feedback

1. This assignment has given us a great opportunity in learning how to effectively design unit tests, and mocking interfaces whose implemented classes might not be available.

2. Testing was automated by `JUnit`, which a very popular testing framework used widely in the industry.

3. Figuring ways how to mock one of the input objects is very intriguing as we need to anticipate what the targeted method expects from those inputs.

4. The assignment description document [`Assignment2.md`](Assignment2.md) is very detailed and comprehensive, and it was easy to follow.

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
