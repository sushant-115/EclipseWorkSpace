package com.spring.bean;

import java.util.Map;

public class QuestionBean {
	private String question;
	private Map<String ,String> answers;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Map<String, String> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<String, String> answers) {
		this.answers = answers;
	}
	

}
