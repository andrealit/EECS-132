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
  
  
}
