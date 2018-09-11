package model;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.json.simple.JSONObject;

/**
 * 
 */

/**
 * @author jam
 *
 */
public abstract class Item {
	
	public enum ItemType{
		ChemicalItem;
		public static String toString(ItemType type) {
			switch (type) {
			case ChemicalItem:
				return "chemical_item";
			}
			return "";
		}
		public static ItemType fromString(String str) {
			if("chemical_item".equals(str)) {
				return ItemType.ChemicalItem;
			}
			return ItemType.ChemicalItem;
		}
	}
	
	private JSONObject dataObj = new JSONObject();
	
	public Item() {
	}
	public Item(Item copy) {
		this.dataObj = (JSONObject)copy.dataObj.clone();
	}
	
	public String toJSON() {
		return dataObj.toJSONString();
	}
	
	public String toCSV() {
		String result = "";
		for(String attr: this.getSchema()) {
			result += this.get(attr) + "\t";
		}
		return result.trim();
	}

	public void init(String data) {
		if(data == null) {
			return;
		}
		for(String attr: this.getSchema()) {
			this.getData().put(attr, "-");
		}
		data = data.trim();
		StringTokenizer st = new StringTokenizer(data, "\t");
		for(String attr: getSchema()) {
			if(! st.hasMoreElements()) {
				dataObj.put(attr, "-");
			}else {
				dataObj.put(attr, st.nextElement());
			}
		}
	}

	public String[] getSchema() {
		String [] schema = new String[1];
		schema[0] = "";
		return schema;
	}

	public JSONObject getData() {
		return dataObj;
	}
	
	public String get(String attr) {
		return (String)dataObj.get(attr);
	}
	
	public void set(String attr, String data) {
		dataObj.put(attr, data);
	}
	
	public boolean contains(String keywords) {
		for(String attr: getSchema()) {
			String value = (String)dataObj.get(attr);
			if(value.contains(keywords)) {
				return true;
			}
		}
		return false;
	}
}
