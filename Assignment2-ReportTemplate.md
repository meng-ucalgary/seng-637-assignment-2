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

Text…

## Video demo

Link to the video demonstration of testing is _TBA_.

## Detailed description of unit test strategy

// including the input partitions you have designed

## Test cases developed

| API method                                                 | Test method           | Input partitions |
| ---------------------------------------------------------- | --------------------- | ---------------- |
| `Range.shift(Range, double, boolean)`                      | `RangeTest.*`         |                  |
| `Range.constrain(double)`                                  | `RangeTest.*`         |                  |
| `Range.expandToInclude(Range, double)`                     | `RangeTest.*`         |                  |
| `Range.combineIgnoringNaN(Range, Range)`                   | `RangeTest.*`         |                  |
| `Range.intersects(double, double)`                         | `RangeTest.*`         |                  |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | `DataUtilitiesTest.*` |                  |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | `DataUtilitiesTest.*` |                  |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | `DataUtilitiesTest.*` |                  |
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
| `Range.constrain(double)`                                  | Bhavyai Gupta            |
| `Range.expandToInclude(Range, double)`                     | Drew Burritt             |
| `Range.combineIgnoringNaN(Range, Range)`                   | Bhavyai Gupta            |
| `Range.intersects(double, double)`                         | Michael                  |
| `DataUtilities.calculateColumnTotal(Values2D, int)`        | Michael                  |
| `DataUtilities.calculateColumnTotal(Values2D, int, int[])` | Drew Burritt             |
| `DataUtilities.calculateRowTotal(Values2D, int)`           | Michael                  |
| `DataUtilities.calculateRowTotal(Values2D, int, int[])`    | Bhavyai Gupta            |
| `DataUtilities.getCumulativePercentages(KeyedValues)`      | Okeoghenemarho Obuareghe |

## Difficulties, challenges, and lessons learned

Text…

## Comments and feedback

Text…

## Contributors

We are group 5, and below are the team members

- [Bhavyai Gupta](https://github.com/zbhavyai)
- [Drew Burritt](https://github.com/dburritt)
- [Michael Man Yin Lee](https://github.com/mlee2021)
- [Okeoghenemarho Obuareghe](https://github.com/oobuareghe)
