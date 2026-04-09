```
class Travels
    - Name, Address, Contact, List of Vehicle, List of Customer, List of Bookings, Rating
    - BookVehicle(), cancelBooking(), getRating(), getDetails(), getBookingDetails(), getCustomerDetails(), 

class BookingDetails
    - Customer, Vehicle, PickupLocation, DropLocation, Booking-id, Date, Rating, Payment, Discount, Driver, Issue
    - Rating(), payment(), reportIssue(), getDetails(), 

class Vehicle
    - NumberPlate, Seats, Model 
    - acWorking(), assignDriver(), getDetails(), getAvailibility(), 

class Driver
    - Name, Address, Contact, Available, Rating, Driver-id
    - getRating(), hasVehicle(), getDetails(), assignVehicle(), 

class Customer 
    - Name, Address, Contact, Email, Customer-id, Rating
    - myBookings(), BookVehicle(), cancelBooking(), getRating(), getDetails(), 
```

```
class Student
    - Student-id, Name, Date-of-Birth, Address, Standard, Roll No, isStudying, List of Subjects, List of Marks, School/College-Name, attendance, gender
    - getGrades, getPercentage, getResult, addSubject, removeSubject, updateMarks, getDetails, isEligibleforExam, 

class ReportCard
    - Student, Percentage, List of Grades , Result, remarks, examType, issueDate
    - calculatePercentage(), calculateGrade(), getResult(), addRemarks(), generateReportCard(), totalMarks(), 
```