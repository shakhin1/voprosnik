package com.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Dict")
public class Dict {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "className", nullable = false)
	private String className;
	@Column(name = "word", nullable = false)
	private String word;
	@Column(name = "link", nullable = true)
	private String link;
	@Column(name = "subject", nullable = false)
	private String subject;
	@Column(name = "book", nullable = false)
	private String book;
	@Column(name = "topic", nullable = false)
	private String topic;
	@Column(name = "mark", nullable = false)
	private Integer mark;
	@Column(name = "type", nullable = true)
	private String type;

	public Dict(String className, String word, String subject, String book, String topic, Integer mark, String type) {
		this.className = className;
		this.word = word;
		this.subject = subject;
		this.book = book;
		this.topic = topic;
		this.mark = mark;
		this.type = type;
	}

	public Dict(String className, String word, String link, String subject, String book, String topic, Integer mark, String type) {
		this.className = className;
		this.word = word;
		this.link = link;
		this.subject = subject;
		this.book = book;
		this.topic = topic;
		this.mark = mark;
		this.type = type;
	}

	public Dict() {
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Long getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
