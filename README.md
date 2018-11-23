#Future Gadget Labs  ParkingLot

#Running the application:

Using the tomcat plugin for maven, click on "tomcat7:run" under the maven projects tab(located on the right side) on intellij.

#Default pricing scheme:

Time	 |   Fee 
   
0-30min	 |   R10  
30-60min |   R20   
1hr-1.5hr	 |   R30   
1.5hr-2hr	 |   R40   
2.5hr+     |   R50  
LOST	 |   R100   

if a car stays for longer than 2.5 hours(the longest possible time allocation, it is assumed the ticket is lost and the fee will be the 2.5hr + lost fee. 

#View all tickets
Definition 
 
GET /all

This will display a list of all tickets in the database.





#Creating a ticket.
Definition

POST /create


[ 
   
        {
            "id": 31,
            "time_in": "05:50:22"
            }
  
] 

I have intentionally not auto incremented the ticket ID. This was done so you know your ticket ID when you sre going to update your ticket.

#Updating a ticket.
Definition

PUT /update/(id)


[ 
   
        {
                 "time_out": "11:00:00",
                 "is_lost": true
             }
  
] 

example: http://localhost:8080/update/5

The next iteration will have tests completed. I decided to focus on improving existing code for this iteration in these last few days.
The next iteration will also have a better database structure since it was not yet necessary.
