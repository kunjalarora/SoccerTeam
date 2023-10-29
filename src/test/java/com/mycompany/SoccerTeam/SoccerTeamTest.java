import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// import com.mycompany.SoccerTeam.*;

class SoccerTeamTest {

	@Test
	void testCoach1() {
		Coach coach = Coach.getInstance(); 
		boolean expected = true;
		boolean actual = (coach.getName().compareTo("") == 0) && (coach.getYearsExp() == 0) 
				&& (coach.getLevel().compareTo("") == 0);
		assertEquals(actual, expected, "The coach is not initialized correctly by the default constructor of the Coach class.");
	}
	@Test
	void testCoach2() {
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		boolean expected = true;
		boolean actual = (coach.getName().compareTo("Xavi") == 0) && (coach.getYearsExp() == 20) && 
				(coach.getLevel().compareTo("high") == 0);
		assertEquals(actual, expected, "The coach is not initialized correctly by the overloaded constructor of the Coach class.");
	}
	@Test
	void testCoach3() {
		Coach coach1 = Coach.getInstance("Benni", 10, "beginner"); 
		Coach coach2 = Coach.getInstance(coach1); 
		boolean expected = true;
		boolean actual = (coach1.getName().compareTo(coach2.getName()) == 0) && (coach1.getYearsExp() == coach2.getYearsExp()) && 
				(coach1.getLevel().compareTo(coach2.getLevel()) == 0);
		assertEquals(actual, expected, "The coach is not initialized correctly by the copy constructor of the Coach class.");
	}

	@Test
	void testPlayer1() {
		Player player = Player.getInstance(1, "Messi", 's'); 
		char role ='s';
		boolean expected = true;
		boolean actual = (role == player.getRole());
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented for the Player class [wrong getter method].");
	}
	@Test
	void testPlayer2() {
		char role = 'g'; 
		Player player = Player.getInstance(); 
		player.setRole(role);
		boolean expected = true;
		boolean actual = (role == player.getRole());
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented for the Player class.[wrong setter method]");
	}
	@Test
	void testPlayer3() {
		char role = 'd'; 
		Player player1 = Player.getInstance(2, "Ronaldo", role); 
		Player player2 = Player.getInstance(player1);
		boolean expected = true;
		boolean actual = (player1.getRole() == player2.getRole()) && (player2.getRole() == role);
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented in the copy constructor, for role attribute in Player class.");
	}
	@Test
	void testPlayer4() {
		char role = 'c'; 
		Player player1 = Player.getInstance(3, "Benzema", role); 
		Player player2 = Player.getInstance(3, "Benzema", role); 
		boolean expected = true;
	
		boolean actual = (player1.getName() == player2.getName());

		assertEquals(actual, expected, "The aggregation relationship is not correctly implemented for name in Player class.");
	}
	
	@Test
	void testPlayer5() {
		char role = 'g';  
		Player player1 = Player.getInstance(10, new String("Casillas"), role); 
		Player player2 = Player.getInstance(10, "Casillas", role);
		boolean expected = true;
		boolean actual = (player1.getName() != player2.getName());
		assertEquals(actual, expected, "The aggregation relationship is not correctly implemented for name in Player class.");
	}
	@Test
	void testSoccerTeam1() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance(); 
		
		SoccerTeam team = SoccerTeam.getInstance(players, coach); 
		boolean expected = true;
		boolean actual = (team.getPlayers() != players);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for the player list in SoccerTeam class [getPlayer].");
	}
	@Test
	void testSoccerTeam2() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team = SoccerTeam.getInstance(players, coach); 
		boolean expected = true;
		boolean actual = (team.getCoach() != coach);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for the coach attribute in SoccerTeam class [getCoach].");
	}
	@Test
	void testSoccerTeam3() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team = SoccerTeam.getInstance();
		team.setCoach(coach);
		team.setPlayers(players);
		boolean expected = true;
		boolean actual = (team.getCoach() != coach) && (team.getPlayers() != players);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for coach in SoccerTeam class [setCoach and setPlayer].");
	}
	@Test
	void testSoccerTeam4() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team = SoccerTeam.getInstance();
		team.setCoach(coach);
		team.setPlayers(players);
		boolean expected = true;
		boolean actual = (team.getCoach().getLevel() != coach.getLevel());
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for coach in SoccerTeam class [setCoach].");
	}
	@Test
	void testSoccerTeam5() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team = SoccerTeam.getInstance();
		team.setCoach(coach);
		team.setPlayers(players);
		boolean expected = true;
		boolean actual = (team.getPlayers()[0].getName() != players[0].getName() );
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for coach in SoccerTeam class [setPlayer].");
	}

	@Test
	void testSoccerTeam6() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team1 = SoccerTeam.getInstance(players, coach);
		SoccerTeam team2 = SoccerTeam.getInstance(players, coach);
		boolean expected = true;
		boolean actual = (team1.getPlayers() != team2.getPlayers());
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for player array in SoccerTeam class [copy constructor or overloaded constructor].");
	}
	@Test
	void testSoccerTeam7() {
		Player player1 = Player.getInstance(1, "Messi", 's'); 
		Player player2 = Player.getInstance(2, "Neymar", 'd'); 
		Player [] players = new Player[2]; 
		players[0] = player1; 
		players[1] = player2;
		Coach coach = Coach.getInstance("Xavi", 20, "high"); 
		
		SoccerTeam team1 = SoccerTeam.getInstance(players, coach);
		SoccerTeam team2 = SoccerTeam.getInstance(players, coach);
		boolean expected = true;
		boolean actual = (team1.getCoach() != team2.getCoach());
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for coach in SoccerTeam class [copy constructor or overloaded constructor].");
	}
}
