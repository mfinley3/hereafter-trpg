package tests;

import static org.junit.Assert.*;
import model.*;
import controller.*;
import units.*;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestUnitSelection.
 */
public class TestUnitSelection {
	
	/**
	 * Test things.
	 */
	@Test
	public void TestThings(){
		Player p = new Player("EB");
		p.addUnits(new Soldier(Difficulty.EASY.getValue()));
		p.addUnits(new Engineer(Difficulty.EASY.getValue()));
		p.addUnits(new Doctor(Difficulty.EASY.getValue()));
		p.addUnits(new Ranger(Difficulty.EASY.getValue()));
		p.addUnits(new Sniper(Difficulty.EASY.getValue()));

		GameController g = new GameController(p, Difficulty.EASY, "tower");
		System.out.println(g.getMap().toString());
		Unit u = g.getUnitOnMap(2, 0);
		assertTrue(u!=null);
		u = g.getUnitOnMap(2, 2);
		assertNull(u); 
		u = g.getUnitOnMap(1, 0);
		assertTrue(u!=null);
		u = g.getUnitOnMap(0, 0);
		assertTrue(u!=null);
		u = g.getUnitOnMap(0, 1);
		assertTrue(u!=null);
		u = g.getUnitOnMap(0, 2);
		assertTrue(u!=null);
	}
	
	/**
	 * Test movement.
	 */
	@Test
	public void TestMovement(){
		Player p = new Player("EB");
		p.addUnits(new Soldier(Difficulty.EASY.getValue()));
		p.addUnits(new Engineer(Difficulty.EASY.getValue()));
		p.addUnits(new Doctor(Difficulty.EASY.getValue()));
		p.addUnits(new Ranger(Difficulty.EASY.getValue()));
		p.addUnits(new Sniper(Difficulty.EASY.getValue()));
		
		GameController g = new GameController(p, Difficulty.EASY, "tower");
		Unit u = g.getUnitOnMap(0, 0);
		assertTrue(u!=null);
		g.setCurrentUnit(0, 0);
		assertTrue(u==g.getCurrentUnit());
		assertTrue(u.canMove());
		g.setEndRow(2);
		g.setEndColumn(2);
		assertTrue(g.getMap().getSpace(2, 2).getCanMoveTo());
		g.move();
		assertFalse(u.canMove());
		assertFalse(u==g.getUnitOnMap(0, 0));
		assertTrue(u==g.getUnitOnMap(2,2));
		assertTrue(g.setCurrentUnit(1, 0));
		assertFalse(g.setCurrentUnit(2, 2));
		assertTrue(g.getCurrentUnit()==g.getUnitOnMap(1, 0));
		g.setEndRow(2);
		g.setEndColumn(2);
		g.move();
		assertTrue(g.getCurrentUnit().canMove());
	}
	
	/**
	 * Test end turn and new turn.
	 */
	@Test
	public void testEndTurnAndNewTurn(){
		Player p = new Player("EB");
		p.addUnits(new Soldier(Difficulty.EASY.getValue()));
		p.addUnits(new Engineer(Difficulty.EASY.getValue()));
		p.addUnits(new Doctor(Difficulty.EASY.getValue()));
		p.addUnits(new Ranger(Difficulty.EASY.getValue()));
		p.addUnits(new Sniper(Difficulty.EASY.getValue()));
		
		GameController g = new GameController(p, Difficulty.EASY, "tower");
		g.setCurrentUnit(0, 0);
	}
	
	/**
	 * Test attack and heal.
	 */
	@Test
	public void testAttackAndHeal(){
		// Test Attack
		Unit i = new Soldier(Difficulty.EASY.getValue());
		Unit b = new ZombieDogAI(Difficulty.EASY.getValue());
		
		i.reduceHealth(b.getAttack());
		assertTrue(i.getHealth()<100);
	}
}
