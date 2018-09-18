package com.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Info")
public class Info {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "fio", nullable = false)
	private String fio;
	@Column(name = "nameOfClass", nullable = false)
	private String nameOfClass;
	@Column(name = "subject", nullable = false)
	private String subject;
	@Column(name = "book", nullable = false)
	private String book;
	@Column(name = "topic", nullable = false)
	private String topic;
	@Column(name = "mark", nullable = false)
	private String mark;

	public Info() {
	}

	public Info(String fio, String nameOfClass, String subject, String book, String topic, String mark) {
		this.fio = fio;
		this.nameOfClass = nameOfClass;
		this.subject = subject;
		this.book = book;
		this.topic = topic;
		this.mark = mark;
	}

	public String getFio() {
		return fio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getNameOfClass() {
		return nameOfClass;
	}

	public void setNameOfClass(String nameOfClass) {
		this.nameOfClass = nameOfClass;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}
