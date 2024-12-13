package finalproject;

import org.junit.Test;

import finalproject.FileHandler.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

public class FileHandlerTest {
	
// these tests require the save file to be empty to validate
	
//	@Test
//	public void SaveTest() {
//		FileHandler fh = new FileHandler();
//		
//		ArrayList<Creature> test_creatures = new ArrayList<>();
//		test_creatures.add(new Dragon("Dragon", "Nicol Bolas", 25000, 9001));
//		
//		fh.SaveData(test_creatures);
//	}
	
//	@Test
//	public void LoadTest() {
//		int expected_array_size = 1;
//		int actual_array_size = 0;
//		FileHandler fh = new FileHandler();
//		
//		ArrayList<Creature> test_creatures = new ArrayList<>();
//		
//		try {
//			fh.LoadData(test_creatures);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		actual_array_size = test_creatures.size();
//		
//		//Assert
//		Assert.assertEquals(expected_array_size, actual_array_size);
//	}
	
	@Test
	public void SaveTest() throws InterruptedException {
		
		ArrayList<Creature> test_creatures = new ArrayList<>();
		test_creatures.add(new Dragon("Dragon", "Nicol Bolas", 25000, 9001));
		
		Runnable saveRunnable = new SaveDataWorker(test_creatures);
		new Thread(saveRunnable).start();
		Thread.sleep(500);
	}
	
	@Test
	public void LoadTest() throws IOException, InterruptedException {
		int expected_array_size = 1;
		int actual_array_size = 0;
		
		ArrayList<Creature> test_creatures = new ArrayList<>();
		
		Runnable loadRunnable = new LoadDataWorker(test_creatures);
		new Thread(loadRunnable).start();
		Thread.sleep(500);
		
		for(Creature creature : test_creatures) {
			creature.displayInfo();
		}
		
		actual_array_size = test_creatures.size();
		
		//Assert
		Assert.assertEquals(expected_array_size, actual_array_size);
		
	}
	

}
