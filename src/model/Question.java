package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author jam
 *
 */
public class Question<Q,A> {

	private Integer id = null;
	private Q info = null;
	private List<Answer<A> > answers = new ArrayList<>();
	private List<Integer > interestedIds = new ArrayList<>();
	private Time requestedTime = null;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setInfo(Q info) {
		this.info = info;
	}
	public Q getInfo() {
		return this.info;
	}
	public void appendAnswer(Answer<A> answer) {
		if(answer != null) {
			answers.add(answer);
		}
	}
	
	public void addInterestedId(Integer id) {
		this.interestedIds.add(id);
	}
	public List<Integer> getInterestedIds(){
		return this.interestedIds;
	}
	public void setRequestedTime(Time time) {
		this.requestedTime = time;
	}
	public Time getRequestedTime() {
		return this.requestedTime;
	}
	
	public List<Answer<A> > getAnswers(){
		return this.answers;
	}
	
	public boolean isComplete() {
		int totalNumOfSellers = User.getTotalNumberOfSellers();
		return answers.size() == totalNumOfSellers;
	}
}
