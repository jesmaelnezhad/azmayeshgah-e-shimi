package model;


import java.sql.Time;

/**
 * 
 */

/**
 * @author jam
 *
 */
public class Answer<T> {
	
	private Integer sourceId;
	private T info;
	private Time expirationTime;
	
	public void setInfo(T info) {
		this.info = info;
	}
	public T getInfo() {
		return this.info;
	}
	public void setSourceID(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getSourceID() {
		return this.sourceId;
	}
	public void setExpirationTime(Time time) {
		this.expirationTime = time;
	}
	public Time getExpirationTime() {
		return this.expirationTime;
	}
	
	public boolean isExpired() {
		Time currentTime = new Time(System.currentTimeMillis());
		return currentTime.after(this.getExpirationTime());
	}
}
