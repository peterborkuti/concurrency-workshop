Concurrency Exercises II - Synchronizers
========================================

git clone git@github.com:peterborkuti/concurrency-workshop.git

Hints: 
* If you are stuck, ask your neighbour

* If you are really stuck, ask me

* If you are really-really stuck, check this repo: https://github.com/peterborkuti/concurrency



Author: Péter Borkuti

Latches
----------------
0. clone the repository and check the _Util_ class

1. TwoThreads
Create two threads. The second should wait for the first to finish
2. WaitForFinish
Create N threads and start them. Create a thread Q which should wait 
for the other N to finish.
3. WaitForEachOther
Create N threads. They should wait for each other to start processing.

Semaphores
---------------

1. SwimmingPool
   There are N lane. Swimmers are coming to swim, but they should ask for permission
   first (= they must wait for an empty lane). If there is an empty lane, a swimmer start
   to swim. After a while it will be tired, gets out from the lane (gives the permission back)
   and goes to the sauna. A swimmer can go back to swim (it should wait for an empty line)
   The Swimming pool opens at 6:00 and closes at 22:00.

2. Laundry
    There are 4 washing machines. People are coming to wash their clothes. A washing
    takes T minutes.

3. Bycicle-shed
    There are M places for bycicles
2. Dishwashers
  See in the book

3. Authors
  5 authors: sleeping, waiting for a pen, writing. 3 pens.

4. Automatic Traffic Light
  Light: red. Green for a given time if there is a car in front of it.

5. Two dependent automatic traffic light
  Green for a given time if there is a car in front of it and the other light is not green

6. Elevator1
  Two stops (Up and Down). People waiting at the stops.

7. Elevator2
  N stops. People waiting at the stops and when get in, choose a random Stop.
