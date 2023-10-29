// package com.mycompany.SoccerTeam;
import com.mycompany.SoccerTeam.*;

/**
 * Kunjal Arora, Lab B
 * This class implements a simple soccer team 
 *@author EECS2030 - F23
 */
public class SoccerTeam {

	private Player[] players ;
	private Coach coach;
	/**
	 * This is the default constructors. 
	 * At most 11 player can play this team. 
	 * At most there are 4 roles players can have.
	 */
	private SoccerTeam() {
		players = new Player[11];
	}
	
	/**
	 * This is the overloaded constructor for this class
	 * @param player is an array containing all the players who entered the team.
	 * @param coach is the coach that trains the team's players.
	 */
	
	private SoccerTeam (Player [] player, Coach coach) {
		for(int i=0; i<player.length; i++) {
			this.players[i] = Player.getInstance(player[i]);
		}
		this.coach = Coach.getInstance(coach);
	}
	
	/**
	 * This is the copy constructor for this class
	 * @param team is an object of SoccerTeam, whose component is deeply copied into 
	 * the component of this object.
	 */
	private SoccerTeam (SoccerTeam team) {
		for(int i=0; i<team.players.length; i++) {
			this.players[i] = Player.getInstance(team.players[i]);
		}
		this.coach = Coach.getInstance(team.coach);
	}
	
	/**
	 * This is a static factory method
	 * @return IT returns an object of SoccerTeam
	 */
	public static SoccerTeam getInstance() {
		SoccerTeam team = new SoccerTeam();
		for(int i=0; i<team.players.length; i++) {
			team.players[i] = Player.getInstance();
		}
		Coach coach = Coach.getInstance();
		return team;
		
	}
	/**
	 * This is a static factory method
	 * @param player is an array that contains players.
	 * @param coach is a coach of the team
	 * @return It returns an object of SoccerTeam made using the input parameters.
	 */
	public static SoccerTeam getInstance(Player [] player, Coach coach) {
		SoccerTeam team1 = new SoccerTeam();
		for(int i=0; i<player.length; i++) {
			team1.players[i] = Player.getInstance(player[i]);
		}
		team1.coach = Coach.getInstance(coach);
		return team1;
		
	}
	
	/**
	 * This is a static factory method
	 * @param team is an object of SoccerTeam
	 * @return it returns an object of SoccerTeam made using the input parameter. 
	 */
	public static SoccerTeam getInstance(SoccerTeam team) {
		Player player1[] = new Player[11];
		for(int i=0; i<team.players.length; i++) {
			player1[i] = Player.getInstance(team.players[i]);
		}
		Coach coachCopy = Coach.getInstance(team.coach);
		SoccerTeam teamNew = new SoccerTeam(player1, coachCopy);
		return teamNew;
	}
	public static void main(String[] args) {
		Coach coach = Coach.getInstance(); 
		boolean expected = true;
		boolean actual = (coach.getName().compareTo("")== 0) && (coach.getYearsExp() == 0) 
						&& (coach.getLevel().compareTo("") == 0);
		System.out.println("the actual output is: " + actual + "the expected output is" + expected);
		System.out.println("it is working");
	}
	/**
	 * This is the getter method for the player list.
	 * @return returns an array containing all the players of this team. 
	 */
	public Player[] getPlayers() {
		SoccerTeam teamTry = new SoccerTeam();
		/**for(int i=0; i<this.players.length; i++) {
		*	teamTry.players[i] = Player.getInstance(this.players[i]);
		*}
		*/
		teamTry.players = this.players;
		return teamTry.players;
		
	}
	
	/**
	 * This is the getter method for the coach attribute.
	 * @return Returns an object of coach containing all the components of this team's coach.
	 */

	public Coach getCoach() {
		Coach coachCopy = Coach.getInstance(this.coach);
		return coachCopy;
		
	}
	
	/**
	 * This is the setter method for the player attribute, which deeply copies 
	 * the input parameter into the player attribute of this object. 
	 * @param player is an array of Player, whose elements are copied in the player attribute of this object.
	 */
	
	public void setPlayers(Player [] player) {
		for(int i=0; i<player.length; i++) {
			this.players[i] = Player.getInstance(this.players[i]);
		}
	}
	
	/**
	 * This is the setter method for the coach attribute, which deeply copies 
	 * the input parameter into the coach attribute of this object.
	 * @param coach is an object of Coach, whose attributes are copied in the coach attribute of this object.
	 */
	public void setCoach(Coach coach) {
		this.coach = Coach.getInstance(coach);
	}

}

/**
 * 
 * This class implements all a player requires to play in this team. 
 * A player has a number, a name, and a role. A role can be either defense, central, striker, or goal keeper. 
 * these roles can be represented by the characters 'd', 'c', 's', or 'g'
 *
 */
class Player {
	private int number;
	private String name;
	private char Role;
	
	/**
	 * This is the overloaded constructor for this class
	 * @param num
	 * @param name
	 * @param role
	 */
	private Player(int num, String name, char role) {
		this.number = num;
		this.name = name;
		this.Role = role;
	}

	
	/**
	 * This is the copy constructor for this class
	 * @param player
	 */
	private Player(Player player) {
		this.number = player.number;
		this.name = player.name;
		this.Role = player.Role;
	}
	
	/**
	 * This is a static factory method.
	 * @return It returns an object of Player
	 */
	public static Player getInstance() {
		Player player1 = new Player(0, "", ' ');
		return player1;
		
	}
	
	/**
	 * This is a static factory method
	 * @param num is the player number
	 * @param name is the name of player
	 * @param role is the role of the player in the team
	 * @return It returns an object of player, which is made by the two input variables. 
	 */
	public static Player getInstance(int num, String name, char role) {
		Player player1 = new Player(num, name, role);
		return player1;
	}
	
	/**
	 * This is a static factory method
	 * @param player is an object of player
	 * @return it returns an object of player that is made using the input parameter. 
	 */
	public static Player getInstance(Player player) {
		Player player1 = new Player(player.number, player.name, player.Role);
		return player1;
	}

	/**
	 * This is the getter method for attribute name
	 * @return returns the value of attribute name
	 */
	public String getName() {
		String nameCopy = this.name;
		return nameCopy;
		
	}
	
	/**
	 * This is the getter method for attribute role
	 * @return returns the reference to attribute role.
	 */
	public char getRole() {
		char RoleCopy = this.Role;
		return RoleCopy;
		
	}
	
	/**
	 * This is the setter method for attribute name
	 * @param name is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		this.name = new String(name);
	}
	
	/**
	 * This is the setter method for attribute role
	 * @param role is the object, whose reference is used to initialize attribute role.
	 */
	public void setRole(char role) {
		 this.Role = role;
	}
	
}

/**
 * This class represent the coach that trains the team's players.
 * A coach has a name, a number of years of experience, and a level of expertise. 
 * The level of expertise can be represented by one of the strings: "high", "average", or "beginner".
 */
class Coach{
	private String name ;
	private int yearsExp;
	private String level;
	
	/**
	 * This is the overloaded constructor.
	 * @param name is the name of the coach.
	 * @param yearsExp is the number of years of experience of the coach.
	 * @param level is the level of experience of the coach.
	 */
	private Coach(String name, int yearsExp, String level) {
		this.name = new String(name);
		this.yearsExp = yearsExp;
		this.level = new String(level);
	}
	
	/**
	 * This is a static factory method that initializes the attributes to their default values. 
	 * @return It returns an Coach object.
	 */
	public static Coach getInstance() {
		Coach coach1 = new Coach("", 0, "");
		return coach1;
	}
	
	/**
	 * This is a static factory method
	 * @param name is the name of the coach.
	 * @param yearsExp is the number of years of experience of the coach.
	 * @param level is the level of experience of the coach.
	 * @return it returns a Coach object.
	 */
	public static Coach getInstance(String name, int yearsExp, String level) {
		Coach coach = new Coach(new String(name), yearsExp, new String(level));
		return coach;
	}
	
	/**
	 * This is the copy constructor.
	 * @param coach is an object of Coach that is used to initialize this object.
	 */
	private Coach(Coach coach) {
		this.name = new String(coach.name);
		this.yearsExp = yearsExp;
		this.level = new String(coach.level);
	}
	
	public static Coach getInstance(Coach coach) {
		return new Coach(new String(coach.name), coach.yearsExp, new String(coach.level));
	}
	public String getName() {
		String nameCopy = new String(this.name);
		return nameCopy;

	}
	public int getYearsExp() {
		int yearsExpCopy = this.yearsExp;
		return yearsExp;

	}
	public String getLevel() {
		String levelCopy = new String(this.level);
		return levelCopy;
	}
}




	

