package Projects;
import java.util.*;
import java.io.*;


	public class Relative {
	      
	   /**
	   * This creates a hierarchical relationship mapping for all individuals. Once this gets returned from the
	   * Family class, the showRelatives method is called, passing through the family.
	   */
	   public static void main(String[] args) throws FileNotFoundException { 
		  
		   Scanner file3 = new Scanner (new File("C:\\Users\\Tiffani\\Desktop\\text files\\Tudor.txt"));
	      // Scanner console = new Scanner(System.in);
	       //Scanner read = new Scanner(getFile(console));
		   Scanner read = new Scanner (new File("C:\\Users\\Tiffani\\Desktop\\text files\\Tudor.txt"));
	       Family fam = new Family(read);
	       
	       System.out.println("Hello, this program is going display one family's generation.");
	       fam.displayListOfViableNames(file3);
	       System.out.println("Choose one of the names from the list above.");
	       showRelatives(fam);
	       
	   }

	   /**
	   * Method to read in the person's name to be displayed along with their ancestors and descendants.
	   * Note: a name with multiple tokens can be entered (ex: "James VI" or simply "Margaret").
	   */
	   public static void showRelatives(Family fam) {
	       Scanner scr = new Scanner(System.in);
	       
	       System.out.print("So what did you choose? ");
	       String n = scr.nextLine();
	       Person p = fam.search(n);
	      
	       if (p.equals(null) || (fam.search(p.getName())).getName().equals("")) {
	           System.out.println("Sorry, that person does not exist.");
	       } else {
	           System.out.println("Maternal Line: ");
	           showMother(p);
	           System.out.println("Paternal Line: ");
	           showFather(p);
	           System.out.println("Descendants: ");
	           showDescendants(p,2);
	       }
	       scr.close();
	   }
	  
	
	   
	   public static void showMother(Person p) {
		   if(p!= null) {
			 System.out.println("\t" + p.getName());
			 if(p.getMother() != null) {
				 System.out.println("\t\t" + p.getMother().getName());
			 }else {
				 System.out.println("\t\tCannot find " + p.getName() +"\'s mother from input file");
			   }
		   }
	   }
	   public static void showFather(Person p) {
		   if(p != null) {
			   System.out.println("\t" + p.getName());
			   if(p.getFather() != null) {
				   System.out.println("\t\t" + p.getFather().getName());
			   }else {
				   System.out.println("\t\tCannot find " + p.getName() +"\'s father from input file");
			   }
		   }
	   }
	  
	   /**
	   * This  method displays the descendants of a person
	   */
	   public static void showDescendants(Person p, int generation) {
	       ArrayList<Person> kids = p.getKids();
	       if (kids.size() == 0) {
	           System.out.print("\t\tnone");
	       } else {
	           for (Person k: kids) {
	               for (int i = 0; i < generation; i++) {
	                   System.out.print("    ");
	               }
	               System.out.print("    ");
	               System.out.println(k.getName());
	               //showDescendants(k, generation + 1);
	           }
	       }
	   }
	}

