package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChemicalItem;

public class DataParser {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/home/jam/Azmayeshgah-e-shimi/data.sdf";
		String outputPath = "/home/jam/Azmayeshgah-e-shimi/data.csv";
		try {
			parseData(filePath, outputPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void parseData(String filePath, String outputPath) throws FileNotFoundException {
	
		
		Scanner dataFile = new Scanner(new FileInputStream(filePath));
		
		List<ChemicalItem> items = new ArrayList<>();
		
		ChemicalItem tempItemContainer = new ChemicalItem();
		while(dataFile.hasNext()) {
			String nextLine = dataFile.nextLine();
			nextLine = nextLine.trim();
			if("$$$$".equals(nextLine)) {
				items.add(tempItemContainer);
				tempItemContainer = new ChemicalItem();
			}else {
				if(">  <Item name>".equals(nextLine)) {
					tempItemContainer.set("name", dataFile.nextLine().trim());
				}else if(">  <Item number>".equals(nextLine)) {
					tempItemContainer.set("number", dataFile.nextLine().trim());
				}else if(">  <CAS Number>".equals(nextLine)) {
					tempItemContainer.set("casNumber", dataFile.nextLine().trim());
				}else if(">  <Formula>".equals(nextLine)) {
					tempItemContainer.set("formula", dataFile.nextLine().trim());
				}
			}
		}
		
		System.out.println("There are " + items.size() + " items.");

		PrintWriter outputFile = new PrintWriter(new FileOutputStream(outputPath));
		
		outputFile.println("name" + "\t" + "number" + "\t" + "CAS" + "\t" + "formula" );
		for(ChemicalItem item : items) {
			outputFile.println(item.toCSV());
		}
		
		
	}

}
