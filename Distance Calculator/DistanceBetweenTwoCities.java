//CS210 Group Project
//This program calculates the distance between cities and converts DMS to DD


package projects;
import java.util.*;


public class DistanceBetweenCities {
	public static void main (String [] args) {
		Scanner console = new Scanner (System.in);
		double radiusInKm = 6372.795;
		double milesPerKm = 0.621371;
		
		//Execute Program
		
		//City One
		//Goes to conversion and conversionNeg method
		//Saves input to specific variables
		System.out.println("Please input coordinates for City 1:");
		System.out.println("North Coordinates:");
		double northRhoOne = conversion(console);
		System.out.println("East Coordinates:");
		double eastLambdaOne = conversion(console);
		System.out.println("South Coordinates:");
		double southRhoOne = conversionNeg(console);
		System.out.println("West Coordinates:");
		double westLambdaOne = conversionNeg(console);
		
		
		//City 1
		//Condenses rhos into one latitude and lambdas into one longitude 
		double cityOneLongitude = eastLambdaOne + westLambdaOne ; 
		double cityOneLatitude = northRhoOne + southRhoOne;
		System.out.println("Latitude: " + cityOneLatitude +"and Longitude: " +cityOneLongitude);
		
		
		//City 2
		//Goes to conversion and conversionNeg method
		//Saves input to specific variables
		System.out.println("Please input coordinates for City 2:");
		System.out.println("North Coordinates:");
		double northRhoTwo = conversion(console);
		System.out.println("East Coordinates:");
		double eastLambdaTwo = conversion(console);
		System.out.println("South Coordinates:");
		double southRhoTwo = conversionNeg(console);
		System.out.println("West Coordinates:");
		double westLambdaTwo = conversionNeg(console);
		
		
		//City 2
		//Condenses rhos into one latitude and lambdas into one longitude
		double cityTwoLongitude = eastLambdaTwo + westLambdaTwo; 
		double cityTwoLatitude = northRhoTwo + southRhoTwo;
		System.out.println("Latitude: " +cityTwoLatitude +"and Longitude: " +cityTwoLongitude);
		
		
		//Calculations and final output
		double longitudeDiff = cityOneLongitude - cityTwoLongitude;
		double angularDiff = Math.acos((Math.sin(cityOneLatitude)*Math.sin(cityTwoLatitude))
				+(Math.cos(cityOneLatitude)*Math.cos(cityTwoLatitude)*Math.cos(longitudeDiff)));
		double angularDistance = radiusInKm * angularDiff;
		System.out.println("The distance between two cities is: " + (int)Math.floor(angularDistance)+" kms.");
		double convertMiles = angularDistance * milesPerKm ; 
		System.out.println("and " + (int)Math.floor(convertMiles) + " miles.");
		
	}
	
	//Obtains user input on coordinates
	//Converts positive values of North latitude and East Longitude
	//returns radian
	public static double conversion (Scanner console) {
		System.out.print("Degrees:");
		int degrees = console.nextInt();
		System.out.print("Minutes:");
		double minutes = console.nextDouble();
		double decimal = minutes/60;
		double deciDegrees = degrees + decimal;
		double radians = Math.toRadians(deciDegrees);
		return radians;
	}
	
	//Obtains user input on coordinates
	//Converts negative vales of South latitude and West longitude
	//return radian
	public static double conversionNeg (Scanner console) {
		System.out.print("Degrees:");
		int degrees = console.nextInt();
		int negDegrees = -degrees;
		System.out.print("Minutes:");
		double minutes = console.nextDouble();
		double decimal = minutes/60;
		double deciDegrees = negDegrees - decimal;
		double radians = Math.toRadians(deciDegrees);
		return radians;
	}
}
