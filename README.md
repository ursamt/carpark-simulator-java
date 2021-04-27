<H3>Car Park Simulator In Java</H3>

This is a popular interview question. Thought of implementing it in Java.

This is a java project which simulates real time car park operation.

This may be useful for people wanting to understand the design and logic involved in car park application.</br>
This app uses LinkedBlockingQueue to store the cars waiting to be parked and PriorityQueue for parking lots.

To start, 

1. Download the project to your local drive 
2. Import the project into your favorite IDE
3. Build the project and run CarParkApp class
4. Follow the instructions displayed on the console to test the car park application

Alternatively, you may want to compile and run the project from command prompt (windows) / Linux Terminal.


Sample Console Output:

<pre>

|******************************************************************
[ Car Park name : My Car Park, Available Lots : 3 ]
|******************************************************************
Total no. of cars in the queue : 5

Please enter your choice
1. Park the next car waiting in the queue
2. View parked cars
3. Unpark the car
0. Exit
>1
You have entered : 1
Attempting to park Toyota, with reg num:SG123
Car has been parked at P1

Please enter your choice
1. Park the next car waiting in the queue
2. View parked cars
3. Unpark the car
0. Exit
>2
You have entered : 2
**********************************************
Currently parked cars
**********************************************

Parking Lot: P1
Car Brand: Toyota
Car Reg Num: SG123
Parked since : Tue Apr 27 13:58:33 SRET 2021

**********************************************

Please enter your choice
1. Park the next car waiting in the queue
2. View parked cars
3. Unpark the car
0. Exit
>3
You have entered : 3
Please enter the parking lot number
P1
[ Parking Lot : P1, Is Occupied: true. Currently occupied by : [Toyota,SG123]]

About to unpark [Toyota,SG123] from lot : P1
Parking Started at: Tue Apr 27 13:58:33 SRET 2021
Parking Ended at: Tue Apr 27 13:58:33 SRET 2021
Total parked time (mins): 0
Parking charges: 0.0
Car Toyota has been successfully unparked from lot num : P1


Please enter your choice
1. Park the next car waiting in the queue
2. View parked cars
3. Unpark the car
0. Exit
>0
You have entered : 0
Bye
</pre>
