/* Date Class for Programming Project 1
 *
 * */

public class Date{
  //fields
  private int day = 1;
  private int month = 1;
  private int year = 1;

  //constructor takes day month and year expects these int values to be within the proper ranges to create a date
  public Date(int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }

  //methods

  //returns the day of the date
  public int getDay(){
    return day;
  }

  //returns the month of the date
  public int getMonth(){
    return month;
  }

  //returns the year of the date
  public int getYear(){
    return year;
  }
