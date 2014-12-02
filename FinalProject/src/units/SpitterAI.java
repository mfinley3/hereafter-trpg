package units;

import item.Item;
import item.ItemType;

/**
 * The Class SpitterAI.
 */
public class SpitterAI extends Unit {
	
	/**
	 * Instantiates a new spitter ai.
	 *
	 * @param difficulty the difficulty
	 */
	public SpitterAI(double difficulty) {
		// unitType, their given item, attack, defense, health, movement, difficulty multiplier
		super("Spitter", new Item("None", ItemType.NONE), 40, 40, 100, 6, 3, difficulty);
	}

} // end of SpitterAI
