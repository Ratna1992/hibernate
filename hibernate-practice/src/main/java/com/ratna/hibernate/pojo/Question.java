package com.ratna.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String question;
	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
	private Collection<Answer> answer = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Collection<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Collection<Answer> answer) {
		this.answer = answer;
	}
	


}
