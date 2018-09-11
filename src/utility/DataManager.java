/**
 * 
 */
package utility;

import model.Item.ItemType;

import org.json.simple.JSONObject;

import model.InterestingItem;
import model.ItemContainer;
import model.Offer;
import model.ProbeRepository;

/**
 * @author jam
 *
 */
public class DataManager {

	private ItemContainer chemicalItems = null;
	private ProbeRepository<InterestingItem, Offer> probeRepository = null;
	
	
	///// Singleton related members
	private static DataManager instance = null;
	private DataManager() {
		
	}
	public static DataManager getDM() {
		if(instance == null) {
			instance = new DataManager();
		}
		return instance;
	}
	
	public void initData(String filePath) {
		chemicalItems = new ItemContainer(ItemType.ChemicalItem, filePath);
		probeRepository = new ProbeRepository<>();
	}
	
	public ItemContainer getMainContainer() {
		return chemicalItems;
	}
	
	public ProbeRepository<InterestingItem, Offer> getProbeRepository() {
		return probeRepository;
	}
	
	
	
	public JSONObject getInfo() {
		JSONObject obj = new JSONObject();
		obj.put("size", chemicalItems.size());
		return obj;
	}
}
