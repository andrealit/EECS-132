// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

import java.util.Scanner;

public class Date {
  
  /* FIELDS */
  private int day = 1;
  private int month = 1;
  private int year = 1;
  
  /* CONSTRUCTORS */
  public Date (int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  /* METHODS */
  
  // A) getDay returns current day
  public int getDay() {
    return day;
  }
  
  // B) getMonth returns current month
  public int getMonth() {
    return month;
  }
  
  // C) getYear returns current year
  public int getYear() {
    return year;
  }
  
  // D) compareTo returns 0 if dates are same, positive number(1) if this date is later than input, and negative number(-1) if date is earlier
  public int compareTo(Date date) {
    if (this.getYear() == date.getYear()) {
      if (this.getMonth() == date.getMonth()) {
        if (this.getDay() == date.getDay()) {
          return 0;
        } else if (this.getDay() > date.getDay()) {
          return 1;
        }
      } else if (this.getMonth() > date.getMonth()) {
        return 1;
      }
    } else if (this.getYear() > date.getYear()) {
      return 1;
    }
    return -1;
  }
  
  // equals checks if two dates have the same day, month, and year
  @Override 
  public boolean equals(Object otherDate) {
    Date compareDate = (Date)otherDate;
    
    if (this.getDay() == compareDate.getDay() && this.getMonth() == compareDate.getMonth() && this.getYear() == compareDate.getYear()) {
      return true;
    } else {
      return false;
    }
    
  }
  
  // toString converts date into an English representation 
  @Override
  public String toString() {
    
    // MONTHS
    String printMonth = "";
    if (this.getMonth() == 1) 
      printMonth = "January";
    else if (this.getMonth() == 2)
      printMonth = "February";
    else if (this.getMonth() == 3)
      printMonth = "March";
    else if (this.getMonth() == 4)
      printMonth = "April";
    else if (this.getMonth() == 5)
      printMonth = "May";
    else if (this.getMonth() == 6)
      printMonth = "June";
    else if (this.getMonth() == 7)
      printMonth = "July";
    else if (this.getMonth() == 8)
      printMonth = "August";
    else if (this.getMonth() == 9)
      printMonth = "September";
    else if (this.getMonth() == 10)
      printMonth = "October";
    else if (this.getMonth() == 11)
      printMonth = "November";
    else if (this.getMonth() == 12)
      printMonth = "December";
    else 
      printMonth = "null";
    
    
    return printMonth + " " + this.getDay() + ", " + this.getYear();
  }
  
  
}
