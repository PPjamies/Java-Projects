import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
	public static void main (String[] args){
		@SuppressWarnings("resource")
		Scanner console = new Scanner (System.in);//System.in is very specific to Scanner
		@SuppressWarnings("resource")
		Scanner yesNo = new Scanner (System.in);
		Random randy = new Random ();
		char wantToPlay = ' ';//This is a dummy value to show java that this variable is initialized (no purpose)
		int guessCount = 0;
		int gameCount = 0;
		int ttlGuess = 0;
		int min = 0;
		boolean firstGameDone = false;
		
//launch game
		
		haiku();	
//This loops the entire game as long as user wants to continue playing
		do {
		
			String thinking = "I'm thinking of a number between 1 and 100...";//Example of string
			System.out.println(thinking);
			int randomNumber = randy.nextInt(101);//randomly generates a number between 0-100
			int playerGuess;
			
		//This loops the question till you guess correctly
			do {
				System.out.print("Your guess?");
				playerGuess = console.nextInt();
			
				if (playerGuess > randomNumber) {
					System.out.println("too low you insensitive degenerate!");
				}
				if (playerGuess < randomNumber) {
					System.out.println("too high you overly-confident buffoon!");
				}
				guessCount ++;   
			}while(playerGuess != randomNumber);
			//end of first loop
			
				ttlGuess += guessCount;
			if (playerGuess == randomNumber) {
	            
				if(!firstGameDone || guessCount < min) {
					min = guessCount;	
				}
				firstGameDone = true;
				System.out.println("Hey you got it right in " + guessCount + " guesses! Can I call you daddy?");
				System.out.println("Would you like to play again?");
				wantToPlay = yesNo.next().charAt(0);
				gameCount ++;
				guessCount = 0;
				}
			
		}while(wantToPlay == 'y'|| wantToPlay == 'Y');
	//End of last loop
		
	
		System.out.println("Your overall results, retard:");
		System.out.println("Total games = " + gameCount);
		System.out.println("Total guesses = " + ttlGuess );
		System.out.println("Guesses/game = " + (ttlGuess/gameCount )); 
		System.out.println("Best game = " + min);

}
	
	public static void haiku () {
		System.out.println ("Through friendship we learn");
		System.out.println("To enjoy each's company");
		System.out.println("Hold my hand papi");
		System.out.println("");
	}
	
}
