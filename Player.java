/** Program: Milestone5
 * File:Player.java
 * Summary: Abstract class that has the properties of the player object
 * Author: Brandon Labat
 * Date: April 8, 2018
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

 public abstract  class Player {//begin player class
	//declare instance variables
	private String name;
	private String college;
	private String highschool;
	private String position;
	private String team;
	private int experience;
	private int number;
	private int age;
	private int height;
	private int weight;
	private int rushYard;
	private int recYard;
	private int passYard;
	private int tackles;
	private int sacks;
	private int interceptions;
	private ArrayList<Manager> arrayList;
	
	public Player() {}//Empty constructor
	
		
	public Player(String name, String college, String highschool, String position,
			String team, int experience, int number, int age, int height, int weight,int
			rushYard,int passYard,int recYard, int tackles, int sacks, int interceptions) {
		// set instanced variables to be passed in the method
		this.name = name;
		this.college = college;
		this.highschool = highschool;
		this.position = position;
		this.team = team;
		this.experience = experience;
		this.number = number;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.rushYard = rushYard;
		this.recYard = recYard;
		this.passYard = passYard;
		this.tackles = tackles;
		this.sacks = sacks;
		this.interceptions = interceptions;
		
	}
	public String getName() {// get the value of the instanced variable name
	return this.name;
	}
	public int getAge() {// get the value of the instanced variable age
		return this.age;
	}
	public int getWeight() {// get the value of the instanced variable weight
		return this.weight;
	}
	public int getHeight() {// get the value of the instanced variable height
		return this.height;
	}
	public int getNumber() {// get the value of the instanced variable number
		return this.number;
	}
	public int getExperience() {// get the value of the instanced variable experience
		return this.experience;
	}
	public String getTeam() {// get the value of the instanced variable team
		return this.team;
	}
	public String getPosition() {// get the value of the instanced variable position
		return this.position;
	}
	public String getHighschool() {// get the value of the instanced variable highschool
		return this.highschool;
	}
	public String getCollege() {// get the value of the instanced variable college
		return this.college;
	}
	public int getRushYard() {// get the value of the instanced variable rushYard
		return this.rushYard;
	}
	public int getRecYard() {// get the value of the instanced variable recYard
		return this.recYard;
	}
	public int getPassYard() {// get the value of the instanced variable passYard
		return this.passYard;
	}
	public int getTackles() {//  get the value of the instanced variable tackles
		return this.tackles;
	}
	public int getSacks() {// get the value of the instanced variable sacks
		return this.sacks;
	}
	public int getInterceptions() {// get the instanced variable interceptions
		return this.interceptions;
	}
	public void setName(String name) {// set instance variable name to name passed in the method.
		 
		this.name =  name;
	}// end setName method
	public void setCollege(String college) {// set instance variable college to college passed in the method
		this.college = college;
	}// end setCollege method
	public void setAge(int age) {// set instance variable age to age passed in the method
		this.age = age;
	}//end setAge method
	public void setWeight(int weight) {// set instance variable weight to weight passed in the method
		this.weight = weight;
	}// end setWeight method
	public void setNumber(int number) {// set instance variable number to number passed in the method
		this.number = number;
	}// end setNumber method
	public void setExperience(int experience) {//set instance variable experience to experience passed in the method
		this.experience = experience;
	}// end setExperience method
	public void setTeam(String team) {// set instance variable team to team passed in the method
		this.team = team;
	}//end setTeam method
	public void setPosition(String position) {// set instance variable position to position passed in the method
		this.position = position;
	}// end setPosition method
	public void setHighschool(String highschool) {// set instance variable highschool to highschool passed in the method
		this.highschool = highschool;
	}// end setHighschool method
	public void setRushyard(int rushYard) {// set instance variable rushYard to rushYard passed in the method
		this.rushYard = rushYard;
	}// end setRushYard method
	public void setRecyard(int recYard) {// set instance variable recYard to recYard passed in the method
		this.recYard = recYard;
	}// end setRecyard method
	public void setPassyard(int passYard) {// set instance variable passYard to passYard passed in the method
		this.passYard = passYard;
	}// end setPassyard method
	public void setTackles(int tackles) {// set instance variable tackles to tackles passed in the method
		this.tackles = tackles;
	}// end setTackles method
	public void setSacks(int sacks) {// set instance variable sacks to sacks passed in the method
		this.sacks = sacks;
	}// end setSacks method
	public void setInterceptions(int interceptions){// set instance variable interceptions to interceptions passed in the method
		this.interceptions = interceptions;
	}// end setInterceptions method
	public void setHeight(int height) {// set instance variable height to height passed in the method
		this.height = height;
	}//end setHeight method
	//Sorts the ArrayList in descending order
	public ArrayList<Manager> sortDescending(){
		Collections.sort(this.arrayList, Collections.reverseOrder());
		return this.arrayList;
	}
	
	public static void add(OffensivePlayer offensivePlayer) {
		
	}
	public static void add(DefensivePlayers defensivePlayers) {
	
		
	}
	//display player info to console
	public String toString() {//toString method
		double feet = getHeight()/12;//computation to find player height in feet and inches
		double inches = getHeight()%12;
		
		return "\n"  
		+ getName() 
		+ "\nCollege: " + getCollege() 
		+ "\nHighschool: " + getHighschool() 
		+ "\nAge: " + getAge() 
		+ "\nWeight: " + getWeight() 
		+ "\nHeight: " 
		+ feet + " ft" + " " + inches + " in" 
		+ "\nTeam Number: " +getNumber() 
		+ "\nExperience: " + getExperience() 
		+ "\nTeam: " + getTeam() 
		+ "\nPosition: " +getPosition() 
		+ "\nRushing Yards: " + getRushYard() 
		+ "\nRecieving yards: " +getRecYard() 
		+ "\nPassing Yards: " + getPassYard() 
		+ "\nTackles : " + getTackles() 
		+ "\nSacks: " +getSacks() 
		+ "\nInterceptions: " + getInterceptions();
		
	}// end toString method
	
	public String greeting() {
		int r = new Random().nextInt(4);
		String message = "";
		switch(r) {
		case 0: message = "Welcome to NFL Application";
		break;
		case 1: message = "Have Fun";
		break;
		case 2: message = "Hello!";
		break;
		case 3: message = "Have a Great Day";
		break;
		case 4: message = " Have a Great Evening";
		break;
		
		}
		return getName() + " , " + message;
		
	}
}//end Player class

	
				
			
		
	


