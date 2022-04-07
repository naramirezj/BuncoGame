public class DiceBox {
	private Dice d1;
	private Dice d2;
	private Dice d3;
	private int firstRoll;
	private int secondRoll;
	private int thirdRoll;
	
	/**
	 * DiceBox constructor, creates three dices.
	 */
	public DiceBox() {
		d1 = new Dice();
		d2 = new Dice();
		d3 = new Dice();
	}
	
	/**
	 * Rolls three dices at once and prints the results.
	 * @return void
	 */
	public void rollBox() {
		firstRoll = d1.rollDice();
		secondRoll = d2.rollDice();
		thirdRoll = d3.rollDice();
		//turnNum++;
		System.out.println("Rolling...");
		System.out.println("First dice: " + firstRoll);
		System.out.println("Second dice: " + secondRoll);
		System.out.println("Third dice: " + thirdRoll);
	}
	
	/**
	 * Gets the first roll
	 * @return firstRoll;
	 */
	public int getFirstRoll() {
		return firstRoll;
	}
	
	/**
	 * Gets the second roll
	 * @return secondRoll;
	 */
	public int getSecondRoll() {
		return secondRoll;
	}
	
	/**
	 * Gets the third roll
	 * @return thirdRoll;
	 */
	public int getThirdRoll() {
		return thirdRoll;
	}
	
	/**
	 * Resets the three dices at once.
	 * @return void
	 */
	public void resetBox() {
		d1.resetDice();
		d2.resetDice();
		d3.resetDice();
	}
	
}
