package units;

import item.Item;
import item.ItemType;

public class SpitterAI extends Unit {
	
	public SpitterAI() {
		super();
		Item givenWeapon = new Item("Ebola-Virus Spit Launcher", ItemType.ATK);
		itemList.add(givenWeapon);
	}

	@Override
	public void visibility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int movesAvailable(int hinderance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
