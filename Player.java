public class Player {
	private int score;
	private String name;
	private Dice turnDice;
	private int turnCount;
	
	/**
	 * Player 0-parameter constructor, initializes score to 0 and the 
	 * default name to "Computer".
	 */
	public Player() {
		score = 0;
		name = "Computer";
	}
	
	/**
	 * Sets the name of a player to the input string.
	 * @param String name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Prints out that not points were scored.
	 * Then it prints the total score.
	 * @return void
	 */
	public void noPoints() {
		System.out.println("You didn't get any points. End of your turn.\n");
		System.out.println("Your score is: " + score + "\n");
	}
	
	/**
	 * Adds one point to the score.
	 * @return void
	 */
	public void addPoint() {
		System.out.println("You get 1 point!\n");
		score++;
	}
	
	/**
	 * Adds two points to the score.
	 * @return void
	 */
	public void twoPoint() {
		System.out.println("You get 2 points!\n");
		score += 2;
	}
	
	/**
	 * Adds five points to the score.
	 * @return void
	 */
	public void miniBunco() {
		System.out.println("It's a miniBunco, you get 5 points!\n");
		score += 5;
	}
	
	/**
	 * Adds twenty-one points to the score.
	 * @return void
	 */
	public void Bunco() {
		System.out.println("It's a Bunco, you get 21 points!\n");
		score +=21;
	}
	
	/**
	 * Rolls a special dice to decide the turn. Returns the roll.
	 * @return turnCount
	 */
	public int turnRoll() {
		turnDice = new Dice();
		turnCount = turnDice.rollDice();
		return turnCount;
	}
	
	/**
	 * Gets the total score.
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Gets the name of the player.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Indicates if a player has win when getting a Bunco or getting to 21 points.
	 * @return boolean if the score is equal or larger than 21
	 */
	public boolean Win() {
		return(score >= 21);
	}
	
	/**
	 * Resets the score to 0.
	 * @return void
	 */
	public void resetScore() {
		score = 0;
	}
	

}
