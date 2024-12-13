package finalproject;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class FileHandler {
	
//	public void SaveData(ArrayList<Creature> creatures) {
//		
//		System.out.println("Save data start...");
//		
//		Gson gson = new Gson();
//		
//		try {
//			File save_file = new File("save_file.json");
//			Writer writer = new FileWriter("save_file.json");
//			
//			if(save_file.createNewFile()) {			
//				System.out.println("Save file created: " + save_file.getAbsolutePath());			
//			}
//			else {
//				System.out.println("Save file exists");
//			}
//			
//			try {
//				System.out.println("Saving...");
//				gson.toJson(creatures, writer);
//				writer.flush();
//				writer.close();
//				System.out.println("Successfully wrote to save file.");
//			}
//			catch(Exception e) {
//				System.out.println("Error writing to file: " + e.toString());
//			}
//		}
//		
//		catch(IOException e) {
//			System.out.println("Error: " + e.toString());
//		}	
//		
//	}
	
//	public void LoadData(ArrayList<Creature> creatures) throws IOException {
//		System.out.println("Loading data from file...");
//		try {
//			JsonReader reader = new JsonReader(new FileReader("save_file.json"));
//			
//			reader.beginArray();
//			while(reader.hasNext()) {
//				String type = null;
//				String name = null;
//				int age = 0;
//				int fire_power = 0;
//				String horn_color = null;
//				int wingspan_inches = 0;
//				
//				reader.beginObject();
//				while(reader.hasNext()) {
//					String key = reader.nextName();
//					if(key.equals("type")) {
//						type = reader.nextString();
//					}
//					else if(key.equals("name")) {
//						name = reader.nextString();
//					}
//					else if(key.equals("age")) {
//						age = reader.nextInt();
//					}
//					else if(key.equals("fire_power")) {
//						fire_power = reader.nextInt();
//					}
//					else if(key.equals("horn_color")) {
//						horn_color = reader.nextString();
//					}
//					else if(key.equals("wingspan_inches")) {
//						wingspan_inches = reader.nextInt();
//					}
//					else {
//						reader.skipValue();
//					}
//				}
//				reader.endObject();
//				switch(type) {
//				case "Dragon":
//					creatures.add(new Dragon(type, name, age, fire_power));
//					break;
//				case "Unicorn":
//					creatures.add(new Unicorn(type, name, age, horn_color));
//					break;
//				case "Phoenix":
//					creatures.add(new Phoenix(type, name, age, wingspan_inches));
//					break;
//				}
//			}
//			System.out.println("Creatures loaded...");
//			reader.endArray();
//			reader.close();
//			System.out.println("Done!");
//		}
//		catch(Exception e) {
//			System.out.println("Error reading data from file: " + e.toString());
//		}
//	}
	
	static class SaveDataWorker implements Runnable {
		
		ArrayList<Creature> _creatures = new ArrayList<>();
		
		public SaveDataWorker(ArrayList<Creature> creatures) {
			this._creatures = creatures;
		}
		
		@Override
		public void run() {
			System.out.println("Save data start...");
			
			Gson gson = new Gson();
			
			try {
				File save_file = new File("save_file.json");
				Writer writer = new FileWriter("save_file.json");
				
				if(save_file.createNewFile()) {			
					System.out.println("Save file created: " + save_file.getAbsolutePath());			
				}
				else {
					System.out.println("Save file exists");
				}
				
				try {
					System.out.println("Saving...");
					gson.toJson(_creatures, writer);
					writer.flush();
					writer.close();
					System.out.println("Successfully wrote to save file.");
				}
				catch(Exception e) {
					System.out.println("Error writing to file: " + e.toString());
				}
			}
			
			catch(IOException e) {
				System.out.println("Error: " + e.toString());
			}	
		}
	}

	static class LoadDataWorker implements Runnable {
		
		ArrayList<Creature> _creatures = new ArrayList<>();
		
		public LoadDataWorker(ArrayList<Creature> creatures) {
			this._creatures = creatures;
		}
		
		@Override
		public void run() {
			System.out.println("Loading data from file...");
			try {
				JsonReader reader = new JsonReader(new FileReader("save_file.json"));
				
				reader.beginArray();
				while(reader.hasNext()) {
					String type = null;
					String name = null;
					int age = 0;
					int fire_power = 0;
					String horn_color = null;
					int wingspan_inches = 0;
					
					reader.beginObject();
					while(reader.hasNext()) {
						String key = reader.nextName();
						if(key.equals("type")) {
							type = reader.nextString();
						}
						else if(key.equals("name")) {
							name = reader.nextString();
						}
						else if(key.equals("age")) {
							age = reader.nextInt();
						}
						else if(key.equals("fire_power")) {
							fire_power = reader.nextInt();
						}
						else if(key.equals("horn_color")) {
							horn_color = reader.nextString();
						}
						else if(key.equals("wingspan_inches")) {
							wingspan_inches = reader.nextInt();
						}
						else {
							reader.skipValue();
						}
					}
					reader.endObject();
					switch(type) {
					case "Dragon":
						_creatures.add(new Dragon(type, name, age, fire_power));
						break;
					case "Unicorn":
						_creatures.add(new Unicorn(type, name, age, horn_color));
						break;
					case "Phoenix":
						_creatures.add(new Phoenix(type, name, age, wingspan_inches));
						break;
					}
				}
				System.out.println("Creatures loaded...");
				reader.endArray();
				reader.close();
				System.out.println("Done!");
			}
			catch(Exception e) {
				System.out.println("Error reading data from file: " + e.toString());
			}
		}
	}
}
