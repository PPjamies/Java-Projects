package Projects;
import java.util.*;

	public class Family {
		 private ArrayList<Person> fam;
		  
		   /**
		   * The family object is created and contains one field, which is an ArrayList of unique Persons.
		   */
		   public Family(Scanner read) {
		       this.fam = new ArrayList<Person>();
		       if(read.hasNextLine()) {
		    	   String uniqueN = read.nextLine();
		      
		    	   while (!(uniqueN.equals("END"))) { // add each unique Person to the ArrayList fam
		    		   this.fam.add(new Person(uniqueN));
		    		   uniqueN = read.nextLine();
		    	   }
		    	   sortRelationships(read);
		       }
		   }
		  
		   /**
		   * Method to iterate through the second portion of tudor.txt and set the relationship status for
		   * each Person (following the pattern of: Person, Person's mother, Person's father).
		   */
		   public void sortRelationships(Scanner read) {
		       String pName = read.nextLine();
		       while (read.hasNextLine() && !(pName.equals("END"))) {
		           String mName = read.nextLine();
		           String fName = read.nextLine();
		          
		           Person p = search(pName);

		           if (!(mName.equals("unkown"))) {
		               Person m = search(mName);
		               p.setMother(m);
		               m.addKid(p);
		       
		           }
		           
		           if (!(fName.equals("unkown"))) {
		               Person f = search(fName);
		               p.setFather(f);
		               f.addKid(p);
		           }
		           if(read.hasNextLine()) {
		           pName = read.nextLine();
		           }
		       }
		   }
		  
		   /**
		   * Helper method to find Person by String
		   */
		   public Person search(String name) {
		       for (Person p: this.fam) {
		           if (p.getName().equalsIgnoreCase(name)) {
		               return p;
		           }
		       }
		       Person e = new Person("");
		       return e;
		   }
		   
		   public void displayListOfViableNames(Scanner file3) {
			   while(file3.hasNextLine()) {
				   String names = file3.nextLine();
				   if(file3.hasNextLine() && !(file3.nextLine().equalsIgnoreCase("end"))) {
					   System.out.println(names);
					   names = file3.nextLine();
				   }
			   }
		   }
		}


