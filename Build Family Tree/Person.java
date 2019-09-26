package Projects;
import java.util.*;

public class Person{
	/**
	* This class serves to hold information about a person (name, mother, father, kids).
	*/
	
	   private String name;
	   private Person mother;
	   private Person father;
	   private ArrayList<Person> kids;
	  
	   /**
	   * Constructs a Person by name and kids (could be empty, but must be initialized).
	   */
	   public Person(String name) {
	       this.name = name;
	       this.kids = new ArrayList<Person>();
	   }

	   public String getName() {
	       return this.name;
	   }

	   public Person getMother() {
	       return this.mother;
	   }

	   public void setMother(Person mother) {
	       this.mother = mother;
	   }

	   public Person getFather() {
	       return this.father;
	   }

	   public void setFather(Person father) {
	       this.father = father;
	   }

	   public ArrayList<Person> getKids() {
	       return this.kids;
	   }
	  
	   public void addKid(Person kid) {
	       kids.add(kid);
	   }
	}




