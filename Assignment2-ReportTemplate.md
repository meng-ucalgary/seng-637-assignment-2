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

The objective of this assignment is to test two classes; namely org.jfree.data.Range (or the Range Class) and org.jfree.data.DataUtilities (or the Data Utilities Class).

The Range class is best described as representing an immutable range of values. For the range class, functions can be static methods or instance methods that performed on a range.

Data Utilities, on the other hand, provides a set of utility methods to be used in different data classes, with the exception of datasets. The methods from which DataUtilites class will be tested on will involve parameters from two interfaces; Values2D and KeyedValues. Values2D is a general interface for accessing a table of values whereas KeyedValues is an interface assisting the storage of an ordered list of key-value pairs.

The test plan as well as details to our unit test strategy can be found in the “Detailed description of unit test strategy” section.

## Video demo

Link to the video demonstration of testing is _TBA_.

## Detailed description of unit test strategy

The test plan for Range and DataUtilities will be defined differently due to the differences of the two classes' functionality.

### Testing Objectives

Within the Range class, the following 5 methods are to be explored:
·         shift(Range base, double delta, boolean allowZeroCrossing)
·         isNaNRange()
·         expandToInclude(Range range, double value)
·         combineIgnoringNaN(Range range1, Range range2)
·         intersects(double b0, double b1)

As with the Data Utilities class, the following 5 methods are to be explored:
·         calculateColumnTotal(Values2D data, int column)
·         calculateColumnTotal(Values2D data, int column, int[] validRows)
·         calculateRowTotal(Values2D data, int row)
·         calculateRowTotal(Values2D data, int row, int[] validCols)
·         getCumulativePercentages(KeyedValues data)

### Testing Type
For the Range Class, traditional unit testing will be used. As for the Data Utilities Class, given that the 5 tests contains uncertain parameters like interfaces (ie. Values2D and KeyedValues), mock testing will be utilized.

### Scope
The scope should be individually discussed between the two classes.
#### Range Class
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

#### DataUtilities Class
For the DataUtilities class, there are two classes (Values2D and KeyedValues) that require the use of jMock.

For the Values2D object, the input partition is a 3x3 matrix with which double values are used at each cell of the array from which the result is asserted.

[Insert keyed values stuff here]


## Test cases developed

| API method                                                 | Test method           | Input partitions |
| ---------------------------------------------------------- | --------------------- | ---------------- |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.*`         |                  |
| `Range.isNaNRange()`                                       | `RangeTest.*`         |                  |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.*`         |                  |
| `Range.combineIgnoringNaN(Range, Range)`                   | `RangeTest.*`         |                  |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInput0And0`         |  (0,0)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndALB`         |  (-15,-8)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndAUB`         |  (-15,15)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndLB`         |  (-15,-10)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBLBAndMAX`         |  (-15,Double.MAX_VALUE)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputBUBAndUB`         |  (9,10)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputUBAndAUB`         |  (10,15)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputLBAndALB`         |  (-10,7)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputLBAndUB`         |  (-10,-10)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputMINAndAUB`         |  (Double.MIN_VALUE,15)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputNaNAnd1`         |  (Double.NaN,1)                |
| `Range.intersects(double, double)`                         | `RangeTest.intersectWithInputNOMAndNOM`         |  (-1,1)                |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalAllRowsFirstColumn` |  [7.5,2.5,5.0], 0                |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        |  `DataUtilitiesTest.calculateColumnTotalAllRowsLastColumn` | [7.5,2.5,5.0], 2                 |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalAllRowsMiddleColumn` |  [7.5,2.5,5.0], 1                 |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMaxValueAndFirstColumn` | [Double.MAX_VALUE,2.5,-2.5], 0                 |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMaxValueColumn` |  [7.5,2.5,5.0], Double.MAX_VALUE                |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMinValueAndFirstColumn` | [Double.MIN_VALUE,2.5,-2.5], 0                 |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithMinValueColumn` | [7.5,2.5,5.0], Double.MIN_VALUE                  |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.calculateColumnTotalWithSumOf0AndFirstColumn` | [7.5,2.5,-10], 0                  |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.*` |                  |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalFirstRow` | [7.5,2.5,5.0], 0  |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalLastRow` | [7.5,2.5,5.0], 2  |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalMiddleRow` | [7.5,2.5,5.0], 1 |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMaxValueAndFirstRow` |[Double.MAX_VALUE,2.5,-2.5], 0       |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMaxValueRow()` | [7.5,2.5,5.0], Double.MAX_VALUE                 |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMinValueAndFirstRow` |[Double.MIN_VALUE,2.5,-2.5], 0                   |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithMinValueRow` | [7.5,2.5,5.0], Double.MIN_VALUE                 |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.calculateRowTotalWithSumOf0AndFirstRow` |  [7.5,2.5,-10], 0                 |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | `DataUtilitiesTest.*` |                  |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | `DataUtilitiesTest.*` |                  |

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

## Division of team work

Each of the four tester will complete at least 1 unit testing of the `Range` class and 1 mock testing from the `DataUtilities` class. Group peer review will be done after the individual testings to ensure that the quality of work abides to the scope of the test plan. Below table summarizes the distribution of development of test cases.

| API method                                                 | Tester                   |
| ---------------------------------------------------------- | ------------------------ |
| `Range.shift(Range, double, boolean)`                      | Okeoghenemarho Obuareghe |
| `Range.isNaNRange()`                                       | Bhavyai Gupta            |
| `Range.expandToInclude(Range, double)`                     | Drew Burritt             |
| `Range.combineIgnoringNaN(Range, Range)`                   | Bhavyai Gupta            |
| `Range.intersects(double, double)`                         | Michael                  |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | Michael                  |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | Drew Burritt             |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | Michael                  |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | Bhavyai Gupta            |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | Okeoghenemarho Obuareghe |

## Difficulties, challenges, and lessons learned

One of the hardest challenges is to agree on the scope as well as what values for the parameters as well as how many variations of these parameters should be tested on as different people have different opinions as to how it should be done.

In the end, after many thorough discussions, we have devised a set of input partitions that we believe, as a team, will effectively test the methods without overburdening the team.

Another difficulty encounter is that there were some confusion that stems from the failed messages from the DataUtilities test using jMock. After some troubleshooting, it was found that we need the Hamcrest external jar (not the given one) in order to get the tests to work.


## Comments and feedback

We believe that the assignment has given us a great opportunity in learning how to effectively design unit tests that also involves mocking certain classes. It is very fun in figuring ways how to mock one of the input classes as we need to guess at each step in anticipating what the targeted method expects from these input objects.

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
