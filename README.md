<p>
  Phase 1: Enums & Constants (No Dependencies)
These should be created first—they're used by other classes:

SeatStatus.java - enum for seat states
SeatType.java - enum for seat types
BookingStatus.java - enum for booking states
PaymentStatus.java - enum for payment states
Phase 2: Core Model Classes (Depend on enums)
Station.java - represents railway stations
User.java - base user class
Passenger.java - extends/uses User
Seat.java - depends on SeatStatus, SeatType
Coach.java - contains multiple Seats
Train.java - contains multiple Coaches, Stations
Phase 3: Transaction Classes (Depend on models)
Payment.java - depends on PaymentStatus, User
Booking.java - depends on BookingStatus, Train, Passenger, Payment
Phase 4: System Orchestrator (Depends on all models)
RailwaySystem.java - orchestrates Train, Booking, Payment, User management
Phase 5: Main Entry Point (Uses RailwaySystem)
IRCTCApp.java - main application that uses RailwaySystem

</p>
