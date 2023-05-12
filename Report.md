# 7th Assignment Report

![](https://github.com/kianaghamsari/Second-Assignment/blob/develop/uni.png)

## Kiana Ghamsari - 400222079


# Introduction 

The purpose of this project is to focus on various areas of multithreaded programming such as handling race conditions.


# Design and Implementation

The following exercises have been completed:

* `CalculatePi`: The code is a multi-threaded program that calculates the value of pi using the Leibniz formula.
The `PiCalculator` class contains a nested `PiCal` class that implements the `Runnable` interface. The `PiCal` class performs the actual calculation of pi using the Leibniz formula. The `calculate()` method creates a thread pool and submits 4000 `PiCal` tasks to the pool. Each task calculates a portion of the final result using a specific value of `d`.
The `add()` method is used to add the result of each task to a global variable `pi`, which is a BigDecimal object. The `pi` variable is synchronized to ensure that there are no race conditions when adding the results from multiple threads.
Once all tasks have been completed, the `calculate()` method waits for the thread pool to terminate and then sets the scale of the `pi`` variable to the desired floating point value. The result is returned as a string representation of the BigDecimal object.

* `PrioritySimulator`: There are three types of tasks (Black, Blue and White) that have to be executed in the order of Black, Blue and White. The `CountDownLatch` class is used to control the order.

* `Semaphore`: A `semaphore` object is created to be passed into each thread which works like a lock.


# Conclusion

In this project, I experienced:

- The concepts of multithreaded programming
- Pi calculation algorithms
- `Semaphore` class
- `CountDownLatch` class
- `BigDecimal` class

* `CountDownLatch` is a synchronization tool that allows one or more threads to wait until a set of operations being performed in other threads completes.
* `Semaphore` is another synchronization tool that allows a fixed number of threads to access a shared resource at the same time.
* In summary, `CountDownLatch` is used for waiting on a set of tasks to complete before proceeding, while `Semaphore` is used for limiting access to shared resources in multithreaded applications.