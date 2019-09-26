//CS210 Fall 2017 
//In-Class Assignment #3, problem 2
//Group: Fantastic 4 - 1
// Sam Robinson: built isLeapYear
// Connor O'Bryan: built daysTo
// Pazuzu Jindrich: built addDays
//This class constructs a Date object and methods for a Date calculator 
package homework;

public class Date {
	private int year;
	private int month;
	private int day;
	private final int[] monthN = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30 , 31, 30, 31};//Normal Year
	private final int[] monthL = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30 , 31, 30, 31};//Leap Year
	
//Constructs a new Date object to represent given date
	public Date (int year, int month, int day) {
		if(year < 0 || month < 0 || day < 0) {
			throw new IllegalArgumentException("Invalid date inputed -dates cannot be negative");
		}
		if(month > 12) {
			throw new IllegalArgumentException("Invalid month inputed");
		}
		if(day > 31) {
			throw new IllegalArgumentException("Invalid day inputed");
		}
		this.year = year;
		this.month = month;
		this.day = day;
		
	}
//Methods
	
	//Additional method for accuracy:
	//Uses a switch statement to calculate the days in the given month
	public int getDaysInMonth() {
		switch (month) {
		case 1: //Starting from January
			return 31; //return 31 days in January
		case 2 :  
			if (isLeapYear()){
				return 29;
			}
			return 28;
		case 3: 
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6: 
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		default: //December
			return 31; //31 days in December
		}
	}
	
	//Moves this date object forward in time by the given number of days
	public void addDays(int days) {
		int month = 0;
		int year = 0;
		this.day += days;
		
		while(this.day > getDaysInMonth()) {
			this.day = Math.abs(this.day - getDaysInMonth());
			this.month++;
			while( this.month > 12) {
				this.month = Math.abs(12 - this.month);
				this.year ++;
			}
		}
	}
	//Moves this date object forward in time by the given number of seven-day weeks. 
	public void addWeeks(int weeks) {
		addDays(weeks * 7);
	}
	//Returns the number of days that this date must be adjusted to make it equal to the given other date
	public int daysTo(Date other) {
		int daysFirst = 0; 
		int daysSecond = 0;
		int[] array1st = this.monthN;
		int[] array2nd = this.monthN;
		int counter = 0;
		daysFirst += this.day;
		daysSecond += other.day;
		
		//Checks to see if either dates are leap years and sets arrays accordingly
		if(isLeapYear()) {
			array1st = this.monthL;
		}
		if(other.isLeapYear()) {
			array2nd = this.monthL;
		}
		
		//Adds up all the days up to the month
		for(int i = 0; i < this.month; i++) {
			counter += array1st[i];
		}
		daysFirst += counter;
		counter = 0;
		for(int i = 0; i < other.month; i++) {
			counter += array2nd[i];
		}
		daysSecond += counter;
		counter = 0;

		daysFirst += this.year * 365;
		daysSecond += other.year * 365;
		return daysSecond - daysFirst;
	}
	
	//Returns the day value of this date; for example, for the date 2006/07/22, return 22
	public int getDay() {
		return this.day;
	}
	//Returns the month value of this date; for example, for the date 2006/07/22, return 07
	public int getMonth() {
		return this.month;
	}
	//Returns the year value of this date; for example, for the date 2006/07/22, return 2006
	public int getYear() {
		return this.year;
	}
	//Returns toString
	public String toString() {
		return year + "/" + month + "/" + day;
	}
	//Return true if the year is a leap year
	public boolean isLeapYear() {
		 if (year % 4 != 0) {
	         return false;
	        } else if (year % 400 == 0) {
	         return true;
	        } else if (year % 100 == 0) {
	         return false;
	        } else {
	         return true;
	        }
	}
		
}
