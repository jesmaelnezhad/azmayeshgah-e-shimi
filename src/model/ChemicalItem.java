package model;

public class ChemicalItem extends Item{

	public ChemicalItem() {
		super();
	}
	
	@Override
	public String[] getSchema() {
		String [] result =  {"name", "number", "casNumber", "formula"};
		return result;
	}
}