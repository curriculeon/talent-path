# Bin and Die Simulation

* **Objective:** To create a simulation of `Die` being rolled and evaluated by a `Bin` which keeps track of the number of times a particular face-value has occurred. 
* **Purpose:** To establish familiarity with composition of array objects.

### Overview
* This project contains 5 classes to be implemented.
    * `Bin` - A class responsible for keeping track of the amount of times an individual face-value has occurred.
    * `Bins` - A class responsible which _contains_ many `Bin` objects.
    * `Die` - A class responsible for has a `faceValue` and the ability to _set_ the `faceValue` to a _random_ value.
    * `Dice` - A class responsible for keeping _handles_ many `Die` objects.
    * `Simulation` - A class responsible for _handling_  `Bins`, `Dice`, and computing statistical distributions.

### Project Instructions
* Within each class are several methods which must be defined to pass test cases.
* Each method has a respective Test class. For example:
  * `new Bin()` can be tested by running the `bintest.ConstructorTest` class.
  * `Bins.incrementBin(Integer)` can be tested by running the `binstest.IncrementBinTest` class.
  * `Die.roll()` can be tested by running the `dietest.RollTest` class.
  * `Dice.rollAndSum()` can be tested by running the `dicetest.ConstructorTest` class.
  * `Simulation.run()` can be tested by running the `simulation.RunTest` class.
* **Ensure that each test-case of each test-class passes with 100% success rate.**
  
### Getting Started
#### Part 1 - Implement `Bin` class
* `Bin` constructor takes an argument of a `Integer` representative of the die-face-value that this `Bin` will be keeping track of.
* `Bin` defines _getters_ for `faceValueToTrack` and `numberOfOccurrences`.
* `Bin` defines a _mutator_ `increment` which increments the field `numberOfOccurrences` by 1.
* **Ensure all test-cases in `bintest` pass with 100% success rate before continuing.**


#### Part 2 - Implement `Bins` class
* `Bins` constructor takes an arugment of two `Integer`s representative of the minimum and maximum die-face-value to track. 
	* Upon construction, `Bins` should create a new `Bin[]` and populate each element with a new `Bin` with a respective face-value to keep track of.
* `Bins` defines `incrementBin` which takes an argument of an `Integer` representative of the `Bin` containing the die-face-value whose we would like to increment the number of occurrences of.
* `Bins` defines `getBin` which takes an argument of an `Integer` representative fo the `Bin` containing the die-face-value we would like to retrieve.
* `Bins` defines _getter_ for _composite_ `Bin[]` field.
* **Ensure all test-cases in `binstest` pass with 100% success rate before continuing.**




#### Part 3 - Implement `Die` class
* `Die` constructor takes an argument of an `Integer` representative of the number of faces this `Die` will have.
* `Die` has a `numberOfFaces` field representative of the number of faces this `Die` will have.
* `Die` has a `currentFaceValue` field representative of the current die-face-value that is viewable.
* `Die` defines `roll` method which sets the `currentFaceValue` field to a random value ranging between 1 and 6.
* `Die` defines _getters_ for `currentFaceValue` and `numberOfFaces`
* **Ensure all test-cases in `dietest` pass with 100% success rate before continuing.**




#### Part 4 - Implement `Dice` class
* `Dice` constructor takes an argument of an `Integer` representative of the number of `Die` this `Dice` will have.
	* Upon construction, `Dice` populates a `Die[]` _field_ with _new_ `Die` instances.
* `Dice` defines `rollAndSum` method which returns an `Integer` representative of sum of all `currentFaceValue` on each of the `Die` in the `Die[]` field.
* `Dice` defines `getRollMin` method which returns an `Integer` representative of the minimum possible roll-sum.
* `Dice` defines `getRollMax` method which returns an `Integer` representative of the maximum possible roll-sum.
* **Ensure all test-cases in `dietest` pass with 100% success rate before continuing.**



#### Part 5 - Implement `Simulation` class
* `Simulation` constructor takes two arguments of `Integer`, one representative of `numberOfDie` to be tossed, and `numberOfTimes` to toss the die. 
	* Upon construction, `Simulation` uses each argument to set a respective _field_.
* `Simulation` defines a `run` method which create a new instance of `Dice` with respective `numberOfDie` passed as an argument upon construction.
	* `run` creates new instance of `Bins` using `rollMinimum` and `rollMaximum` as its constructor arguments.
	* `run` invokes `roll` on `dice` for `numberOfTimes` number of times.
* `Simulation` defines a `getPercentageOfOccurrences` method which takes an argument of an `Integer` representative of the die-face-value to evaluate, and returns a `Double` representative of the percentage of times the face-value has occurred.
* **Ensure all test-cases in `simulationtest` pass with 100% success rate before continuing.**



#### Part 6 - MainApplication

* Use `MainApplication.main(String[])` to run simulations.
* Create readable output to display distributions of occurrences by `@Override`ing the `toString()` method in `Simulation`.


* Sample Script

```java
Simulation simulation = new Simulation(2, 1000000);
simulation.run();
String results = simulation.toString();
System.out.println(results);
```

* Sample Script Output

```java
***
SimulationTest of 2 dice tossed for 1000000 times.
***

 2 :    27917: 0.03 **
 3 :    55422: 0.06 *****
 4 :    83457: 0.08 ********
 5 :   110961: 0.11 ***********
 6 :   139098: 0.14 *************
 7 :   166977: 0.17 ****************
 8 :   138386: 0.14 *************
 9 :   111102: 0.11 ***********
10 :    83367: 0.08 ********
11 :    55799: 0.06 *****
12 :    27514: 0.03 **
```

