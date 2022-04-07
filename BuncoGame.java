import java.util.Scanner;

public class BuncoGame {
	private DiceBox box;
	private Player player1;
	private Player player2;
	private int rollP1;
	private int rollP2;
	private String name;
	private int numTurn;
	private int numGame;
	private String option;
	private static int winNum1;
	private static int winNum2;
	
	/**
	 * BuncoGame constructor, initializes a new DiceBox, 
	 * two new Players, and the round number to 1.
	 */
	public BuncoGame() {
		box = new DiceBox();
		player1 = new Player();
		player2 = new Player();
		numTurn = 1;
	}
	
	/**
	 * Initializes the Bunco game. It first asks for the name of the user, then
	 * decides which player will roll first. After, it will print the number of the
	 * game and the round. While the players haven't scored a Bunco or haven't 
	 * gotten 0 points the turn will continue to execute. Then, when one player's turn
	 * is finished, the other player will do its rolls. Finally,
	 * as the game hits the sixth round the method will announce the winner and
	 * ask the user if they want to play another game. 
	 * @return void
	 */
	public void game() {
		System.out.println("Welcome to Bunco");
		Scanner answer  = new Scanner(System.in);
		System.out.println("Please type the name of the player: ");
		name = answer.nextLine();
		player1.setName(name); //Setting the name to the input
		numGame = 1;
		do{
		Player turnPlay = decideTurn(); //deciding the turn
		System.out.println("\nThis is game " + numGame); //printing the number of games played
		if(turnPlay.getName().equals(player1.getName())) { 
		while(!player1.Win() && !player2.Win() && !(numTurn > 6)) {
		System.out.println("Round " + numTurn + "\n");	
		turn(player1); //first turn with player1
		turn(player2); //second turn with player2
		numTurn++;
		}
		}
		else {
		while(!player1.Win() && !player2.Win() && (numTurn < 7)) {
		System.out.println("Round " + numTurn);	
		turn(player2); //first turn with player2
		turn(player1); //first turn with player1
		numTurn++;
		}
		}
		Scanner play  = new Scanner(System.in);
		System.out.println("End of the game! \n");
		Player winner = Win(player1, player2); //Deciding the winner
		System.out.println("The winner is " + winner.getName()); //Printing the winner
		System.out.println("Total games played: " + numGame);
		System.out.println("Total wins"); //Printing the total wins
		System.out.println(player1.getName() + ": " + winNum1); 
		System.out.println(player2.getName() + ": " + winNum2);
		numGame++; 
		box.resetBox(); //reseting the box
		numTurn = 1; //reseting the turns
		player1.resetScore(); //reseting score
		player2.resetScore();
		System.out.println("Would you like to play again?");
			option = play.nextLine();
		}while(option.toLowerCase().equals("yes")); //Continue with the loop if yes
		System.out.println("Thank you for playing!");
	}
		
	
	/**
	 * Decides which player goes first by rolling two dices for each player,
	 * the player with the greatest roll will be returned.
	 * @return the player with the greater turn roll.
	 */
	public Player decideTurn() {
		System.out.println("Deciding turns");
		rollP1 = player1.turnRoll();
		rollP2 = player2.turnRoll();
		System.out.println(player1.getName() + " roll is: " + rollP1);
		System.out.println(player2.getName() + " roll is: " + rollP2);
		if(rollP1 > rollP2) {
			System.out.println(player1.getName() + " goes first!");
			return player1;
		}
		else {
			System.out.println(player2.getName() + " goes first!");
			return player2;
		}
		
	}
	
	/**
	 * Executes a complete turn for one player. 
	 * The method will first discern if the player is the Computer or the user, 
	 * then it will ask the user to roll the dice box, depending on the rolls 
	 * the method will call the corresponding Player method. 
	 * If the player doesn't get any points the while loop will break.
	 * @param Player player
	 * @return void
	 */
	public void turn(Player player) {
		if(!player.getName().equals("Computer")) { //When the player is not the Computer
		System.out.println("It's " + player.getName() + " turn!\n");
		Scanner answer  = new Scanner(System.in);
		while(!player.Win()) {
		System.out.println("Please press enter to roll");
		answer.nextLine(); //Scanning enter key
		box.rollBox(); //Rolling
		int first = box.getFirstRoll(); //Assigning rolls to variables
		int second = box.getSecondRoll();
		int third = box.getThirdRoll();
		int turn = numTurn;
		
		if(first == turn || second == turn || third == turn) {
			player.addPoint();
		}
		else if((first == turn && second == turn) || (first == turn && third == turn) || 
				(second == turn && third == turn)) {
			player.twoPoint();
		}
		else if(first == 1 && second == 1 && third == 1) {
			player.miniBunco();
		}
		else if(first == turn && second == turn && third == turn) {
		player.Bunco();	
		}
		else {
			player.noPoints();
			break; //break of the while loop if no points scored
		}
		}
		}
		else { //Same method, but when it's the Computer's turn
			System.out.println("It's " + player.getName() + " turn!\n");
			while(!player.Win()) {
				box.rollBox(); //rolls without pressing enter
				int first = box.getFirstRoll();
				int second = box.getSecondRoll();
				int third = box.getThirdRoll();
				int turn = numTurn;
				
				if(first == turn || second == turn || third == turn) {
					player.addPoint();
				}
				else if((first == turn && second == turn) || (first == turn && third == turn) || 
						(second == turn && third == turn)) {
					player.twoPoint();
				}
				else if(first == 1 && second == 1 && third == 1) {
					player.miniBunco();
				}
				else if(first == turn && second == turn && third == turn) {
				player.Bunco();	
				}
				else {
					player.noPoints();
					break;
				}
			}
			
		}
		
	}
	
	/**
	 * Compares the scores of both players to see who has won, 
	 * it will return the player with the greatest score.
	 * @param Player p1, Player p2
	 * @return Player with the greatest score.
	 */
	public Player Win(Player p1, Player p2) {
		if(p1.getScore() > p2.getScore()) {
			winNum1++;
			return p1;
		}
		else {
			winNum2++;
			return p2;
		}
	}
	

	

}

