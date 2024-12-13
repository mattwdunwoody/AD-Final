package finalproject;

import org.junit.Test;
import org.junit.Assert;

public class CreatureManagerTest {
	
	@Test
	public void AddCreatureTest() {
		CreatureManager cm = new CreatureManager();
		
		int expected_array_length = 1;
		int actual_array_length = 0;
		
		cm.addCreature();
		
		actual_array_length = cm.getCreatures().size();
		
		Assert.assertEquals(expected_array_length, actual_array_length);
	}
	
	@Test
	public void RemoveCreatureTest() {
		CreatureManager cm = new CreatureManager();
		
		int expected_array_length = 0;
		int actual_array_length = -1;
		
		cm.removeCreature();
		
		actual_array_length = cm.getCreatures().size();
		
		Assert.assertEquals(expected_array_length, actual_array_length);
		
	}
	
	@Test
	public void DisplayCreaturesTest() {
		CreatureManager cm = new CreatureManager();
		
		cm.displayCreatures();
		
	}
	
	@Test
	public void FilterCreatureTest() {
		CreatureManager cm = new CreatureManager();
		
		cm.filterCreatures();
		
	}
	
	@Test
	public void ShowCreatureStats() {
		CreatureManager cm = new CreatureManager();
		
		cm.showCreatureStats();
		
	}

}
