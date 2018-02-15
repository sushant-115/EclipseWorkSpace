package com.messaging.entity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
@Entity
@Table(name="COPY_QUESTION_TABLE")
@DynamicUpdate
@DynamicInsert
public class CopyOfQuestions<E> {
	@Id
	@GeneratedValue
	private Integer qid;
	private String question;
	private char[] code;
	public char[] getCode() {
		return code;
	}

	public void setCode(char[] code) {
		this.code = code;
	}

	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String qtype;
	private String realAnswer;
	

	public String getRealAnswer() {
		return realAnswer;
	}

	public void setRealAnswer(String realAnswer) {
		this.realAnswer = realAnswer;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	
	public String getQuestion() {
		return question;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	
	

}
