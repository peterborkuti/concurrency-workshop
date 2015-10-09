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

3. BycicleShed
    There are M places for bycicles

4. RailwayStation
	There are N places for the trains to stay.

CyclicBarrier
--------------
1. SwimminRace01
	There is a pool with N lane. There are swimmers coming to swim. If there are exactly N, they are started to swim.
	Swimmers want to got to the sauna than go to the swimming pool again and again.
	You should not take into account, that only N swimmers should be in the pool at the same time.
	Organize only the start of the race.
2. SwimminRace02
	Take into account, that only ONE swimmer should be in one lane. So other swimmers should wait not only to each other to
	gather but for the previous race to finish.

