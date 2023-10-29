// package com.mycompany.SoccerTeam; 
import com.mycompany.SoccerTeam.*;

public class Main {
	public static void main(String[] args) {
		Coach coach = Coach.getInstance(); 
		boolean expected = true;
		boolean actual = (coach.getName().compareTo("")== 0) && (coach.getYearsExp() == 0) 
						&& (coach.getLevel().compareTo("") == 0);
		System.out.println("the actual output is: " + actual + "the expected output is" + expected);
		System.out.println("it is working");
	}
}
