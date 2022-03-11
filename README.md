# SENG-637 Assignment 2

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

The objective of this assignment is to test five methods from two different classes - `org.jfree.data.Range` and `org.jfree.data.DataUtilities`.

The `Range` class is best described as representing an immutable range of values. For the `Range` class, functions can be static methods or instance methods that perform operations on a range.

`DataUtilities`, on the other hand, provides a set of utility methods to be used in different data classes, with the exception of datasets. The methods in the `DataUtilities` class that will be tested involves parameters from two interfaces; `Values2D` and `KeyedValues`. `Values2D` is a general purpose interface for accessing a table of values whereas `KeyedValues` is an interface assisting the storage of an ordered list of key-value pairs.

## Video demo

Link to the video demonstration of testing is [here](https://youtu.be/gPVR7DnBnlg).

## Detailed description of unit test strategy

The test plan for `Range` and `DataUtilities` will be defined differently due to the differences of the two classes' functionalities. While designing the test cases, we first determine the domain of the input parameters. Based on the domain, we create equivalent classes and perform Equivalence Class Testing and Boundary Value Testing. We also test max, min, `NaN`, and `null` input values wherever possible.

### `Range`

For this class, an `exampleRange` of -10 to 10 is used by all the test cases. Additional ranges are created depending upon specific test cases. Since the `exampleRange` is -10 to 10, the following are the BVT notations and their values

| BVT Notation | Value                                                                      |
| ------------ | -------------------------------------------------------------------------- |
| BLB          | -10.00001                                                                  |
| LB           | -10                                                                        |
| ALB          | -9.99999                                                                   |
| NOM          | Any `double` between -9 to 9 or other standard value (depending on method) |
| BUB          | 9.99999                                                                    |
| UB           | 10                                                                         |
| AUB          | 10.00001                                                                   |

The below five methods are to be explored

- `shift(Range base, double delta, boolean allowZeroCrossing)`
- `isNaNRange()`
- `expandToInclude(Range range, double value)`
- `combineIgnoringNaN(Range range1, Range range2)`
- `intersects(double b0, double b1)`

### `DataUtilities`

`jMock` is used to mock the interfaces `Values2D` and `KeyedValues`. `Values2D` object is mocked a 3\*3 matrix holding `double` values. `KeyedValues`object is mocked holding `Integer` as key-value pairs. Since the matrix row and column count is 3, the following are the BVT notations and their values

| BVT Notation | Value |
| ------------ | ----- |
| BLB          | -1    |
| LB           | 0     |
| ALB          | 1     |
| NOM          | 1     |
| BUB          | 1     |
| UB           | 2     |
| AUB          | 3     |

The below five methods are to be explored.

- `calculateColumnTotal(Values2D data, int column)`
- `calculateColumnTotal(Values2D data, int column, int[] validRows)`
- `calculateRowTotal(Values2D data, int row)`
- `calculateRowTotal(Values2D data, int row, int[] validCols)`
- `getCumulativePercentages(KeyedValues data)`

## Test cases developed

### 1. `Range.isNaNRange()`

| Test case                        | Input partitions         | Status |
| -------------------------------- | ------------------------ | ------ |
| `isNaNRangeWithBothBoundNOM`     | (-10, 10)                | Pass   |
| `isNaNRangeWithBothBoundSameNOM` | (10, 10)                 | Pass   |
| `isNaNRangeWithLowerBoundMin`    | (-Double.MAX_VALUE, 10)  | Pass   |
| `isNaNRangeWithUpperBoundMax`    | (10, Double.MAX_VALUE)   | Pass   |
| `isNaNRangeWithLowerBoundNaN`    | (Double.NaN, 10)         | Pass   |
| `isNaNRangeWithUpperBoundNaN`    | (-10, Double.NaN)        | Pass   |
| `isNaNRangeWithBothBoundNaN`     | (Double.NaN, Double.NaN) | Pass   |

### 2. `Range.shift(Range, double, boolean)`

| Test case                                                   | Input partitions                   | Status |
| ----------------------------------------------------------- | ---------------------------------- | ------ |
| `shiftRightToMaxValueAtZeroRangeAllowZeroCrossing`          | (0.0, 0.0), Double.MAX_VALUE, true | Pass   |
| `shiftRightAtZeroRangeDisallowZeroCrossing`                 | (0.0, 0.0), 4.0, false             | Pass   |
| `shiftLeftToMinValueAtZeroRangeAllowZeroCrossing`           | (0.0, 0.0), Double.MIN_VALUE, true | Pass   |
| `shiftLeftAtZeroRangeDisallowZeroCrossing`                  | (0.0, 0.0), -5.0, false            | Pass   |
| `shiftRightNegativeRangeAllowZeroCrossingForLbAndUb`        | (-10.0, -5.0), 15.0, true          | Pass   |
| `shiftRightNegativeRangeDisallowZeroCrossingForLbAndUb`     | (-10.0, -5.0), 18.0, false         | Pass   |
| `shiftLeftPostiveRangeAllowZeroCrossingForLbAndUb`          | (5.0, 7.0), -10.0, true            | Pass   |
| `shiftLeftPostiveRangeDisallowZeroCrossingForLbAndUb`       | (5.0, 7.0), -9.0, false            | Pass   |
| `shiftRightNegativeLbAndPostiveUbRangeDisallowZeroCrossing` | (-3.0, 7.0), 6.0, false            | Pass   |
| `shiftLeftNegativeLbAndPostiveUbRangeDisallowZeroCrossing`  | (-3.0, 7.0), -8.0, false           | Pass   |

### 3. `Range.intersects(double, double)`

| Test case                      | Input partitions              | Status |
| ------------------------------ | ----------------------------- | ------ |
| `intersectsWithInputBLBAndLB`  | (-10.00001, -10)              | Pass   |
| `intersectsWithInputBLBAndALB` | (-10.00001, -9.99999)         | Pass   |
| `intersectsWithInputBLBAndAUB` | (-10.00001, 10.00001)         | Pass   |
| `intersectsWithInputLBAndALB`  | (-10, -9.99999)               | Pass   |
| `intersectsWithInputLBAndUB`   | (-10, 10)                     | Pass   |
| `intersectsWithInputNOMAndNOM` | (-1, 1)                       | Pass   |
| `intersectsWithInputBUBAndUB`  | (9.99999, 10)                 | Pass   |
| `intersectsWithInputUBAndAUB`  | (10, 10.00001)                | Pass   |
| `intersectsWithInputMINAndAUB` | (Double.MIN_VALUE, 10.00001)  | Pass   |
| `intersectsWithInputBLBAndMAX` | (-10.00001, Double.MAX_VALUE) | Pass   |
| `intersectsWithInput0And0`     | (0, 0)                        | Pass   |
| `intersectsWithInputNaNAnd1`   | (Double.NaN, 1)               | FAIL   |

### 4. `Range.expandToInclude(Range, double)`

| Test case                                   | Input partitions             | Status |
| ------------------------------------------- | ---------------------------- | ------ |
| `expandToIncludeWithInputBLB`               | (-10, 10), -10.00001         | Pass   |
| `expandToIncludeWithInputLB`                | (-10, 10), -10               | Pass   |
| `expandToIncludeWithInputALB`               | (-10, 10), -9.99999          | Pass   |
| `expandToIncludeWithInputBUB`               | (-10, 10), 9.99999           | Pass   |
| `expandToIncludeWithInputUB`                | (-10, 10), 10                | Pass   |
| `expandToIncludeWithInputAUB`               | (-10, 10), 10.00001          | Pass   |
| `expandToIncludeWithInputPositive`          | (-10, 10), 25                | Pass   |
| `expandToIncludeWithInputNegative`          | (-10, 10), -25               | Pass   |
| `expandToIncludeWithInputDoubleMax`         | (-10, 10), Double.MAX_VALUE  | Pass   |
| `expandToIncludeWithInputNegativeDoubleMax` | (-10, 10), -Double.MAX_VALUE | Pass   |

### 5. `Range.combineIgnoringNaN(Range, Range)`

| Test case                                 | Input partitions                    | Status |
| ----------------------------------------- | ----------------------------------- | ------ |
| `combineIgnoringNaNWithSmallerRange`      | (-10, 10), (-5, 6)                  | Pass   |
| `combineIgnoringNaNWithDisjointRange`     | (-10, 10), (20, 50)                 | Pass   |
| `combineIgnoringNaNWithNull`              | (-10, 10), null                     | Pass   |
| `combineIgnoringNaNWithLowerBoundMinimum` | (-10, 10), (-Double.MAX_VALUE, -20) | Pass   |
| `combineIgnoringNaNWithLowerBoundNaN`     | (-10, 10), (Double.NaN, -20)        | Pass   |
| `combineIgnoringNaNWithLB`                | (-10, 10), (-10, 20)                | Pass   |
| `combineIgnoringNaNWithALB`               | (-10, 10), (-9.99999, 20)           | Pass   |
| `combineIgnoringNaNWithBLB`               | (-10, 10), (-10.00001, 20)          | Pass   |
| `combineIgnoringNaNWithUpperBoundMaximum` | (-10, 10), (20, Double.MAX_VALUE)   | Pass   |
| `combineIgnoringNaNWithUpperBoundNaN`     | (-10, 10), (20, Double.NaN)         | Pass   |
| `combineIgnoringNaNWithUB`                | (-10, 10), (-20, 10)                | Pass   |
| `combineIgnoringNaNWithAUB`               | (-10, 10), (-20, 10.00001)          | Pass   |
| `combineIgnoringNaNWithBUB`               | (-10, 10), (-20, 9.99999)           | Pass   |
| `combineIgnoringNaNWithBothBoundNaN`      | (-10, 10), (Double.NaN, Double.NaN) | Pass   |
| `combineIgnoringNaNWithZeroRange`         | (-10, 10), (0, 0)                   | Pass   |
| `combineIgnoringNaNWithItself`            | (-10, 10), (-10, 10)                | Pass   |

### 6. `DataUtilities.calculateRowTotal(Values2D, int)`

| Test case                                  | Input partitions                  | Status |
| ------------------------------------------ | --------------------------------- | ------ |
| `calculateRowTotalFirstRow`                | [7.5, 2.5, 5.0], 0                | Pass   |
| `calculateRowTotalLastRow`                 | [7.5, 2.5, 5.0], 2                | Pass   |
| `calculateRowTotalMiddleRow`               | [7.5, 2.5, 5.0], 1                | Pass   |
| `calculateRowTotalWithMaxValueAndFirstRow` | [Double.MAX_VALUE, 2.5, -2.5], 0  | Pass   |
| `calculateRowTotalWithMaxValueRow()`       | [7.5, 2.5, 5.0], Double.MAX_VALUE | Pass   |
| `calculateRowTotalWithMinValueAndFirstRow` | [Double.MIN_VALUE, 2.5, -2.5], 0  | Pass   |
| `calculateRowTotalWithMinValueRow`         | [7.5, 2.5, 5.0], Double.MIN_VALUE | Pass   |
| `calculateRowTotalWithSumOf0AndFirstRow`   | [7.5, 2.5, -10], 0                | Pass   |

### 7. `DataUtilities.calculateRowTotal(Values2D, int, int[])`

| Test case                                                   | Input partitions                                            | Status |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ------ |
| `calculateRowTotalFirstRowValidAllColumns`                  | [7.16, 3.14, 5.23], 0, [0, 1, 2]                            | Pass   |
| `calculateRowTotalMiddleRowValidAllColumns`                 | [7.16, 3.14, 5.23], 1, [0, 1, 2]                            | Pass   |
| `calculateRowTotalLastRowValidAllColumns`                   | [7.16, 3.14, 5.23], 2, [0, 1, 2]                            | Pass   |
| `calculateRowTotalFirstRowValidFirstColumn`                 | [7.16, 3.14, 5.23], 0, [0]                                  | Pass   |
| `calculateRowTotalFirstRowValidMiddleColumn`                | [7.16, 3.14, 5.23], 0, [1]                                  | Pass   |
| `calculateRowTotalFirstRowValidLastColumn`                  | [7.16, 3.14, 5.23], 0, [2]                                  | Pass   |
| `calculateRowTotalMiddleRowValidFirstColumn`                | [7.16, 3.14, 5.23], 1, [0]                                  | Pass   |
| `calculateRowTotalMiddleRowValidMiddleColumn`               | [7.16, 3.14, 5.23], 1, [1]                                  | Pass   |
| `calculateRowTotalMiddleRowValidLastColumn`                 | [7.16, 3.14, 5.23], 1, [2]                                  | Pass   |
| `calculateRowTotalLastRowValidFirstColumn`                  | [7.16, 3.14, 5.23], 2, [0]                                  | Pass   |
| `calculateRowTotalLastRowValidMiddleColumn`                 | [7.16, 3.14, 5.23], 2, [1]                                  | Pass   |
| `calculateRowTotalLastRowValidLastolumn`                    | [7.16, 3.14, 5.23], 2, [2]                                  | Pass   |
| `calculateRowTotalFirstRowValidFirstAndLastColumn`          | [7.16, 3.14, 5.23], 0, [0, 2]                               | Pass   |
| `calculateRowTotalLastRowValidMiddleAndLastColumn`          | [7.16, 3.14, 5.23], 2, [1, 2]                               | Pass   |
| `calculateRowTotalMiddleRowInvalidColumnAUB`                | [7.16, 3.14, 5.23], 1, [3]                                  | Pass   |
| `calculateRowTotalLastRowInvalidColumnAUBAndOneValidColumn` | [7.16, 3.14, 5.23], 2, [2, 3]                               | Pass   |
| `calculateRowTotalFirstRowInvalidColumnBLB`                 | [], 0, [-1]                                                 | FAIL   |
| `calculateRowTotalMaxRowsMaxColumn`                         | [7.16, 3.14], Integer.MAX_VALUE [0, Integer.MAX_VALUE]      | FAIL   |
| `calculateRowTotalBelowMaxRowsBelowMaxColumn`               | [7.16, 3.14], Integer.MAX_VALUE-1, [0, Integer.MAX_VALUE-1] | FAIL   |
| `calculateRowTotalWithMaxValue`                             | [2^53-1, 1], 0, [0, 1]                                      | Pass   |

### 8. `DataUtilities.calculateColumnTotal(Values2D, int)`

| Test case                                        | Input partitions                   | Status |
| ------------------------------------------------ | ---------------------------------- | ------ |
| `calculateColumnTotalAllRowsFirstColumn`         | [7.5, 2.5, 5.0], 0                 | Pass   |
| `calculateColumnTotalAllRowsMiddleColumn`        | [7.5, 2.5, 5.0], 1                 | Pass   |
| `calculateColumnTotalAllRowsLastColumn`          | [7.5, 2.5, 5.0], 2                 | Pass   |
| `calculateColumnTotalWithMaxValueAndFirstColumn` | [Double.MAX_VALUE, 2.5, -2.5], 0   | Pass   |
| `calculateColumnTotalWithMinValueAndFirstColumn` | [Double.MIN_VALUE, 2.5, -2.5], 0   | Pass   |
| `calculateColumnTotalWithMaxValueColumn`         | [7.5, 2.5, 5.0], Integer.MAX_VALUE | Pass   |
| `calculateColumnTotalWithMinValueColumn`         | [7.5, 2.5, 5.0], Integer.MIN_VALUE | Pass   |
| `calculateColumnTotalWithSumOf0AndFirstColumn`   | [7.5, 2.5, -10], 0                 | Pass   |

### 9. `DataUtilities.calculateColumnTotal(Values2D, int, int[])`

| Test case                                                   | Input partitions                                        | Status |
| ----------------------------------------------------------- | ------------------------------------------------------- | ------ |
| `calculateColumnTotalAllRowsValidFirstColumn`               | [7.5, 2.5, 5.0], 0 , [0, 1, 2]                          | Pass   |
| `calculateColumnTotalAllRowsValidMiddleColumn`              | [7.5, 2.5, 5.0], 1 , [0, 1, 2]                          | Pass   |
| `calculateColumnTotalAllRowsValidLastColumn`                | [7.5, 2.5, 5.0], 2 , [0, 1, 2]                          | Pass   |
| `calculateColumnTotalFirstRowValidFirstColumn`              | [7.5, 2.5, 5.0], 0 , [0]                                | Pass   |
| `calculateColumnTotalMiddleRowValidFirstColumn`             | [7.5, 2.5, 5.0], 0 , [1]                                | Pass   |
| `calculateColumnTotalLastRowValidFirstColumn`               | [7.5, 2.5, 5.0], 0 , [2]                                | Pass   |
| `calculateColumnTotalFirstRowValidMiddleColumn`             | [7.5, 2.5, 5.0], 1 , [0]                                | Pass   |
| `calculateColumnTotalMiddleRowValidMiddleColumn`            | [7.5, 2.5, 5.0], 1 , [1]                                | Pass   |
| `calculateColumnTotalLastRowValidMiddleColumn`              | [7.5, 2.5, 5.0], 1 , [2]                                | Pass   |
| `calculateColumnTotalFirstRowValidLastColumn`               | [7.5, 2.5, 5.0], 2 , [0]                                | Pass   |
| `calculateColumnTotalMiddleRowValidLastColumn`              | [7.5, 2.5, 5.0], 2 , [1]                                | Pass   |
| `calculateColumnTotalLastRowValidLastColumn`                | [7.5, 2.5, 5.0], 2 , [2]                                | Pass   |
| `calculateColumnTotalFirstAndLastRowValidFirstColumn`       | [7.5, 2.5, 5.0], 0 , [0, 2]                             | Pass   |
| `calculateColumnTotalInvalidRowAUBAndOneValidRowLastColumn` | [7.5], 2 , [1, 3]                                       | Pass   |
| `calculateColumnTotalInvalidRowAUBMiddleColumn`             | [], 1 , [3]                                             | Pass   |
| `calculateColumnTotalInvalidRowBLBFirstColumn`              | [], 0 , [-1]                                            | FAIL   |
| `calculateColumnTotalMaxRowsMaxColumn`                      | [2.5, 5], Integer.MAX_VALUE, [0, Integer.MAX_VALUE]     | FAIL   |
| `calculateColumnTotalBelowMaxRowsBelowMaxColumn`            | [2.5, 5], Integer.MAX_VALUE-1, [0, Integer.MAX_VALUE-1] | FAIL   |
| `calculateColumnTotalWithMaxValue`                          | [2^53-1, 1], 0, [0, 1]                                  | Pass   |

### 10. `DataUtilities.getCumulativePercentages(KeyedValues)`

| Test method                                                     | Input partitions                                | Status |
| --------------------------------------------------------------- | ----------------------------------------------- | ------ |
| `getCumulativePercentagesWithNoKeyedValues`                     | <>                                              | Pass   |
| `getCumulativePercentagesWithOneRowKeyedValue`                  | <0, 2>                                          | Pass   |
| `getCumulativePercentagesWithOneKeyedValueHavingZeroValue`      | <0, 0>                                          | Pass   |
| `test_getCumulativePercentages_oneKeyedValue_nullValue`         | <0, null>                                       | Pass   |
| `getCumulativePercentagesWithKeyedValuesHavingNullAndMixValues` | <0, -4.5>, <1, 2>, <2, null>, <3, 12.5>, <4, 0> | Pass   |

## Division of team work

Each of the four testers will complete unit tests for at least 1 method of the `Range` class and unit tests for at least 1 method of the `DataUtilities` class using `jMock`. Group peer review will be done after the individual testing to ensure that the quality of work abides to the scope of the test plan. Below table summarizes the distribution of development of test cases.

| API method                                                 | Tester                   |
| ---------------------------------------------------------- | ------------------------ |
| `Range.isNaNRange()`                                       | Bhavyai Gupta            |
| `Range.shift(Range, double, boolean)`                      | Okeoghenemarho Obuareghe |
| `Range.intersects(double, double)`                         | Michael Man Yin Lee      |
| `Range.expandToInclude(Range, double)`                     | Drew Burritt             |
| `Range.combineIgnoringNaN(Range, Range)`                   | Bhavyai Gupta            |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | Michael Man Yin Lee      |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | Bhavyai Gupta            |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | Michael Man Yin Lee      |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | Drew Burritt             |
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

4. The assignment description document [`Assignment_Description.md`](Assignment_Description.md) is very detailed and comprehensive, and it was easy to follow.

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
