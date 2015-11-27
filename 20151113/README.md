Concurrency Exercises
=====================

Author: Péter Borkuti

Remark
--------------------------



Learning interruption
----------------
Solutions are in the interruption package. Answers are usually
1-5 lines of code.

* Check the Thread class's interrupt(), interrupted(), isInterrupted() methods
http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html

*Let's check if sleep() is interruptible or not!*
1. Create a Sleeper Runnable, which sleeps for 30 seconds (use _TimeUnit.SECONDS.sleep()_ )and writes 
these messages when appropriate (use _Util.log()_):
"Start sleeping", "I have slept enough", "Somebody interrupted me", "Let's get out from the bed!"

2. Create a Main program (_TestInterruption01.java_) which starts this Runnable with a Thread (do not use Executors!) and
try to interrupt this thread after 10 seconds run!

*Let's check if blocking classes are interruptible or not!*
4. Use a blocking queue for waiting in Sleeper instead of TimeUnit's sleep and run your Main program again!

*Let's check if Object.wait() is interruptible or not!*
5. Use Object.wait in Sleeper.
Hint: Dont be sad if you get an IllegalMonitorStateException, but read the docs:
http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#wait(long)

6. Think about: can you use Thread.interrupt() when you use Executors?


