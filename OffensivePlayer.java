/** Program: Milestone5
 * File:OffensivePlayer.java
 * Summary: Extends the Player Class and only displays properties for Offensive players
 * Author: Brandon Labat
 * Date: April 8, 2018
 */
public class OffensivePlayer extends Player{//OffensivePlayer Class that extends the abstract Player Class
	
	public OffensivePlayer(){}//empty Constructor
	
	// OffensivePlayer Properties
	OffensivePlayer(String name, String college, String highschool, String position,
			String team, int experience, int number, int age, String height, int weight, int rushYard,
			int recYard, int passYard){
		
		super();//pulls the variables from the abstractPlayer Class
	
	}	
	//Overrides the toString method in the abstract Players class
	@Override
	//displays the offensive player properties to console
	public String toString() {
		double feet = getHeight()/12;
		double inches = getHeight()%12;
		
		return "\n" + "\nOffensive Player: \n" + getName() 
		+ "\nCollege: " + getCollege() 
		+ "\nHighschool: " + getHighschool() 
		+ "\nAge: " + getAge() 
		+ "\nWeight: " + getWeight() 
		+ "\nHeight: " + feet + " ft" + " " + inches + " in" 
		+ "\nTeam Number: " +getNumber() 
		+ "\nExperience: " + getExperience() 
		+ "\nTeam: " + getTeam() 
		+ "\nPosition: " +getPosition() 
		+ "\nRushing Yards: " + getRushYard() 
		+ "\nRecieving yards: " + getRecYard() 
		+ "\nPassing Yards: " + getPassYard();
		
	}
	}

