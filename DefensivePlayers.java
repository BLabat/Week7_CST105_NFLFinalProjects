/** Program: Milestone5
 * File:DefensivePlayers.java
 * Summary: Extends the Player Class and only displays properties for Defensive players
 * Author: Brandon Labat
 * Date: April 8, 2018
 */
public class DefensivePlayers extends Player {//DefensivePlayers Class that extends the abstract Player Class
	
	public DefensivePlayers(){};//empty Constructor
	//Defensive Players properties
	DefensivePlayers(String name, String college, String highschool, String position,
			String team, int experience, int number, int age, String height, int weight, int tackles,
			int sacks, int interceptions){
		super();//pulls the properties from the abstract Players class
	}
	//overrides the toString method in the abstract Players class
@Override
//displays the property of defensive players to console
public String toString() {
	
	double feet = getHeight()/12;
	double inches = getHeight()%12;
	
	return "\n" + "\nDefensive Player: \n" + getName() 
	+ "\nCollege: " + getCollege() 
	+ "\nHighschool: " + getHighschool() 
	+ "\nAge: " + getAge() 
	+ "\nWeight: " + getWeight() 
	+ "\nHeight: " + feet + " ft" + " " + inches + " in" 
	+ "\nTeam Number: " + getNumber() 
	+ "\nExperience: " + getExperience()
	+ "\nTeam: " + getTeam() 
	+ "\nPosition: " +getPosition() 
	+ "\nTackles : " + getTackles() 
	+ "\nSacks: " +getSacks() 
	+ "\nInterceptions: " + getInterceptions();
}
}