package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * 
 */

/**
 * @author jam
 *
 */
public class CustomerHandler extends Handler{
	private Set<Integer> probingQuestionIds = new HashSet<>();
	
	private List<InterestingItem> interestingItems = new ArrayList<>();
	
	public JSONArray processAnswersForAll() {
		JSONArray results = new JSONArray();
		for(Integer key : probingQuestionIds) {
			
		}
		
		return null;
	}
	
	private JSONObject processAnswers(Integer questionId) {
		//TODO find the optimum answer
		return null;
	}
	
	public void addProbingQuestionId(int id) {
		probingQuestionIds.add(id);
	}
	
	public Set<Integer> getProbingQuestions(){
		return probingQuestionIds;
	}
	
	public List<InterestingItem> getInterestingItems(){
		return interestingItems;
	}
	public void addInterestingItem(InterestingItem item) {
		for(int i = 0 ; i < interestingItems.size(); i++) {
			if(interestingItems.get(i).get("id").equals(item.get("id"))) {
				interestingItems.set(i, item);
				return;
			}
		}
		interestingItems.add(item);
	}
	
	public void removeInterestingItem(int id) {
		int i = 0;
		for(i = 0 ; i < interestingItems.size(); i++) {
			if(interestingItems.get(i).get("id").equals(id + "")) {
				break;
			}
		}
		if(i < interestingItems.size()) {
			interestingItems.remove(i);
		}
	}
	
	public boolean hasInterestingItem(int id) {
		for(int i = 0 ; i < interestingItems.size(); i++) {
			if(interestingItems.get(i).get("id").equals(id + "")) {
				return true;
			}
		}
		return false;
	}
	
	public void clearInterestingItems() {
		interestingItems.clear();
	}
	
}
