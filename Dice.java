import java.util.Random;

public class Dice {
	private int count;
	private Random num;

	/**
	 * Dice constructor, sets the count to 0
	 */
	public Dice() {
		count = 0;
	}

	/**
	 * Will emulate the rolling of a dice, by generating a 
	 * random number between 1 and 6.
	 * @return count
	 */
	public int rollDice() {
		num = new Random();
		count = num.nextInt(6)+1;
		return count;
	}

	/**
	 * Resets the score to 0.
	 * @return void
	 */
	public void resetDice() {
		count = 0;
	}
	
}
