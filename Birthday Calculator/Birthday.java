//This program is a birthday calendar

import java.util.Scanner;

public class Birthday {

	public static void main( String[] args){
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
	
		//Introductory Questions
		System.out.println("Please enter today's date:");	
		int ttlDayToday = getMonthAndBirthdate(console);
			
		//Birthday Questions
		System.out.println("Please enter your Birthday:");
		int ttlDayBirthDay = getMonthAndBirthdate(console);
		
		
		//Birthday Alarm & Birthday Fact
		birthDayAlarm (ttlDayBirthDay,ttlDayToday);
	}
			
		
	
	//METHODS:
		//number of days since the beginning of the year		
		public static int getDaysSinceBeginningOfTheYear (int month){
			switch(month){
				case 1:
					return 0; //1-31
				case 2:
					return 31; //31-59
				case 3:
					return 59; //59-90
				case 4:
					return 90; //90-120
				case 5:
					return 120; //120-151
				case 6:
					return 151; //151-181
				case 7:
					return 181; //181-212
				case 8:
					return 212; //212-243
				case 9:
					return 243; //243-273
				case 10:
					return 273; //273-304
				case 11:
					return 304; //304-334
				default:
					return 334; //334-365
			}
		}
	
		//number of days in the month
		public static int getNumberOfDaysInTheMonth(int month){
			switch(month){
				case 1:
					return 31;
				case 2:
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
				default://"else"
					return 31;
			}
		}
		
	//Birthday Alarm!
		public static void birthDayAlarm (int x, int y){
			if(Math.abs(x-y)>1 && Math.abs(x-y)<=365){
				System.out.println("Your next birthday is in "+Math.abs(x-y)
				+" days!");
			}else{
				if (Math.abs(x-y)==1){
					System.out.println("Wow, your birthday is tomorrow!");
				}else{
					if (Math.abs(x-y)==0){
						System.out.println("Happy birthday!");
					}
					}
				}
			System.out.println();
			if(x==239){
				System.out.print("<<SHARKS LEARNED HOW TO SWIM>>");
			}
		}

		
		//This method recieves information: today's date and user's birthdate
		public static int getMonthAndBirthdate (Scanner console){
			int month;
			int day;
			do{
				System.out.print("What is the month (1-12)?");
				month = console.nextInt();
			}while(month >=13 || month <= 0);
			int daysInMonth = getNumberOfDaysInTheMonth(month);
			do{
				System.out.print("What is the day (1-"+daysInMonth+")?");
				day = console.nextInt();
			}while(day > daysInMonth || day <= 0); 
			int ttlDayToday= day + getDaysSinceBeginningOfTheYear(month);
			System.out.println(month+"/"+day+" is day #"+ttlDayToday+" of 365"); 
			System.out.println();
			return ttlDayToday;
		}
}
