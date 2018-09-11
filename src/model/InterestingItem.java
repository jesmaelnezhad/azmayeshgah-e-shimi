/**
 * 
 */
package model;

/**
 * @author jam
 *
 */
public class InterestingItem extends Item{

	public InterestingItem() {
		super();
	}
	
	@Override
	public String[] getSchema() {
		String [] result =  {"id", "name", "number", "casNumber", "formula", "extraInfo"};
		return result;
	}
	public InterestingItem(int id, Item item, String extraInfo) {
		String [] itemSchema = item.getSchema();
		for(String field: itemSchema) {
			this.set(field, item.get(field));
		}
		this.set("id", id + "");
		this.set("extraInfo", extraInfo);
	}
	

	
}
