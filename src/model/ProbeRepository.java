package model;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ProbeRepository<Q,A> {
	private Map<Integer, Question<Q,A>> questions = new HashMap<>();
	
	public Integer registerNewQuestion(Q info, Integer interestedId) {
		Question<Q,A> newQuestion = new Question<>();
		newQuestion.setId(ProbeRepository.getNewId());
		newQuestion.setInfo(info);
		Time currentTime = new Time(System.currentTimeMillis());
		newQuestion.setRequestedTime(currentTime);;
		newQuestion.addInterestedId(interestedId);
		questions.put(newQuestion.getId(), newQuestion);
		return newQuestion.getId();
	}
	
	public void contributeToQuestion(Integer questionId, A answer, Integer sourceId) {
		
		Question<Q,A> question = this.getQuestion(questionId);
		if(question == null) {
			return;
		}
		
		Answer<A> newAnswer = new Answer<>();
		newAnswer.setSourceID(sourceId);
		newAnswer.setInfo(answer);
		
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(new Date()); // sets calendar time/date
	    cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
	    Time expTime = new Time(cal.getTime().getTime()); // returns new date object, one hour in the future
		newAnswer.setExpirationTime(expTime);
		question.appendAnswer(newAnswer);
	}
	
	public Question<Q,A> getQuestion(Integer id){
		if(questions.containsKey(id)) {
			return questions.get(id);
		}else {
			return null;
		}
	}
	
	
	
	///
	private static int idCounter = 0;
	public static int getNewId() {
		return ++idCounter;
	}
}
