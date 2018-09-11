/**
 * 
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import model.Item.ItemType;

/**
 * @author jam
 *
 */
public class ItemContainer {

	private Map<Integer, Item> data = new HashMap<>();
	private ItemType type = null;
	
	public ItemContainer(ItemType type, String filePath) {
		this.type = type;
		if(filePath == null || ! loadFromFile(filePath)) {
			loadFromDB();
		}
	}
	
	public ItemContainer(ItemType type) {
		this.type = type;
		loadFromDB();
	}
	
	
	private boolean loadFromFile(String filePath) {
		try {
			Scanner scanner = new Scanner(new FileInputStream(filePath));
			while(scanner.hasNext()) {
				String line = scanner.nextLine().trim();
				Item item = null;
				switch (this.type) {
				case ChemicalItem:
					item = new ChemicalItem();
					break;
				default:
					break;
				}
				item.init(line);
				this.data.put(ItemContainer.generateId(), item);
			}
			scanner.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	private void loadFromDB() {
		
	}
	
	private void saveToDB() {
	}
	
	public int size() {
		return data.size();
	}
	
	
	public Map<Integer, Item> search(String query){
		Map<Integer, Item> results = new HashMap<>();
		for(Map.Entry<Integer,Item> entry : data.entrySet()) {
			int id = entry.getKey();
			Item item = entry.getValue();
			if(item.contains(query)) {
				results.put(id, item);
			}
		}
		return results;
	}
	
	public Item getItemById(int id) {
		return data.get(id);
	}
	
	private static int idCounter = 1;
	private static int generateId() {
		return ++idCounter;
	}
}
