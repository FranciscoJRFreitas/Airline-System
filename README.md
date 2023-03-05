# JAVA App

## Client Request:
The client wants a system that allows users to book and manage their airline reservations. The system should allow users to view available flights, book flights, cancel reservations, and view their current reservations. Additionally, the system should have an admin interface that allows airline staff to add and manage flights, and view a list of all reservations.

## Features of the system:

Admins and Users have to create an account.  
When the user opens the app, it should have 2 options: Login or Register.  
When they get into the account, they have various options:
- Users should be able to view a list of available flights, including the departure and arrival times, the airline, the number of available seats, and the cost of the flight.
- Users should be able to search for flights by date, time, origin, and destination.
- Users should be able to book a flight by selecting the desired flight and entering their personal information.
- Users should be able to cancel a reservation by entering their reservation ID.
- Users should be able to view a list of their current reservations, including the flight details and the reservation ID.
- Admin staff should be able to add new flights to the system, including the flight number, departure and arrival times, origin and destination airports, and the number of available seats.
- Admin staff should be able to view a list of all reservations, including the user's personal information, the flight details, and the reservation ID.

## Tiebreakers:
If there are multiple flights that meet the user's search criteria, the system should display the flights in order of price, with the cheapest flights listed first. If two flights have the same price, the system should display them in order of departure time, with the earlier flights listed first. If two flights depart at the same time, the system should display them in order of arrival time, with the earlier arrival times listed first.
