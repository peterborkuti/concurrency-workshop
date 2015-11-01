Concurrency Exercises
=====================

Author: Péter Borkuti

Remark
--------------------------

There are two classes in the project, Sleeper and IAMRunning.
You can use these for the solutions - if you are in a hurry - or 
you can write your own version based on the descriptions below.

Learning java.util.concurrent.TimeUnit
----------------
Solutions are in the timeunit package TimeUnitTest class. Answers are usually
1-5 lines of code.

* Check the enum TimeUnit's here:
http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/TimeUnit.html

* Create a class (TimeUnitTest.java) which otputs the answer for these questions:

1. How many minutes are in three days?
2. How many milliseconds are in two hours?
3. How many minutes should your program wait for the next hour's 00 minute?
(For example, when your program starts at 11:09, it should print 51)
4. How many minutes, seconds and milliseconds should your program wait for the next hour's 00 minute?
(Write in the form minutes:seconds.millis)
5. Create code which sleeps for three seconds
6. Create a working code based on this code-fragment:
```
SynchronousQueue<String> queue = new SynchronousQueue<String>();
//Waiting for maximum 3 seconds to poll
queue.poll([WRITE HERE SOMETHING, WRITE HERE SOMETHING);
```

Learning ScheduledExecutorService - scheduled run
----------------
(Solutions are in the timeunit package)
* Check the *schedule* methods in the docs:
http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html

Use this fragment in your main method:
```
ScheduledExecutorService executor =
    Executors.newScheduledThreadPool(1);

...

Util.shutdownAndAwaitTermination(executor);
```

Create a class (IAmRunning) which implements Runnable and writes "I am running" in run() method.
1. Execute this class.
2. Execute this class after 2 seconds from the program starts.
3. Execute this class exactly (as exactly as you can) at when the next minute 
 after the program starts. You main program should sleep for 65 seconds.
4. Execute this class at a future date (your main program should be blocked until
future execution ended)
Check the doc: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledFuture.html
Hint 1:
```
Date targetDate =
    new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-11-2015 09:04:30");
```

Learning ScheduledExecutorService - repeated scheduled run
----------------
(Solutions are in the scheduler package)

Check the *scheduleAtFixedRate* and *scheduleAtFixedDelay* methods in the doc:
http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html

Sub-task

Create a Sleeper runnable class which writes three messages, sleeps between writes
than finishes. It could be super, if you can tell to this class through it's
constructor the duration of it running time. (For example, its run method
should run for 10 seconds).
If you want to concentrate to sheduling and dont want to be distracted by this
sub-task, use the Sleeper class from the scheduler package.

1. Schedule Sleeper to run in every 20 seconds (beware, let enough time for the
executor to finish Sleeper between runs).
Your main program should sleep for some minutes to see the outcomes.
2. Schedule Sleeper to run in every 5 seconds (give less time for the scheduler
than necessary and check its behaviour)
3. Schedule sleeper to run periodically 5 seconds after the previous run finises.


Fancy Exercise
---------------
Let's create something more complex for fun!

Write a RepeatScroll class which scrools given texts in a given place and length
on the terminal.
See this gif:


Or a more complex example for the same topic:


Because this is a complex task here are my hints:

Writing to console at a given coordinate is not an easy task with Java, so use 
the library Lanterna (https://github.com/mabe02/lanterna).
(If you are familiar with other libs which is appropriate for this task,
like libgdx, swing, etc) you can use that, but Lanterna is easy-to-use and you
can fly with it in 3 minutes.)

I added this lib into the project and there is a Main class in lanterna package
for testing the library.

Try it now and do not step forward until it works.

OK, so lanterna is working.

I wrote the Scroll class to free up some time for you.
It is in the scroll package. If you want to use it, please test it:
run the ScrollTest.java. Fix it until all tests run fine
or write your own class.

Now you have a working Scroll class and a working example for Lanterna.
You can find everything in the Main class of lanteran package which you
need for creating RepeatScroll class, so if you want to work alone, do not
read this text more. However, if you do not have enough time,
I can give you more help in the next section.

Feel free to stop reading anywhere and follow your own way!

1. Write the RepeatScroll class in a dumb way:
```
open the terminal
instantiate Scroll class
while (true) {
    Write the scrolled text
    refresh the screen
    wait a bit
}
```

2. More concrete help:
```
    public static void main(String[] args) throws IOException, InterruptedException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        TextGraphics tGraphics = screen.newTextGraphics();

        screen.startScreen();
        screen.clear();

        Scroll scroll = new Scroll(30, '*', "Hello");

        while (screen.pollInput() == null) {
            tGraphics.putString(10, 10, scroll.scrollToRight());
            screen.refresh(Screen.RefreshType.DELTA);
            TimeUnit.MILLISECONDS.sleep(100);
        }

        screen.stopScreen();
    }
```

3. Now transfer this class to use thread for scolling a text
Hint: use scheduleAtFixedRate

Fancier exercises
----------------

So you have a class which uses scheduleAtFixedRate to scroll a text on the screen.

Let the class smarter and smarter!

1. Scroll 3 different texts on the screen in different places!
2. Arbitrary number of different texts should be scrolled!
3. Texts should be scrolled in different speed!
4. Sometimes texts should change its scrolling direction randomly!
5. Create a ScreenPlay class which orchestrate the scrolling texts, like in
a advertising-led-board.
There are some given texts and times for scrolling the texts. You have to
scroll the text one another for the given duration.
6. Code some nice transformation method which runs when the scrolled text
change to another text.
