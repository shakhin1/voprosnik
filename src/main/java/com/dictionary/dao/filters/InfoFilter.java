package com.dictionary.dao.filters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dictionary.model.Info;
import com.dictionary.model.Info_;
import com.dictionary.utils.PredicateBuilder;


public class InfoFilter extends AbstractFilter {
	private Long id;
	private String fio;
	private String nameOfClass;
	private String subject;
	private String book;
	private String topic;
	private String mark;

	public Predicate getPredicate(CriteriaBuilder cb, Root<Info> from) {
		return new PredicateBuilder(cb).addEqualsPredicate(from.get(Info_.fio), fio)
				.addEqualsPredicate(from.get(Info_.nameOfClass), nameOfClass).addEqualsPredicate(from.get(Info_.subject), subject)
				.addEqualsPredicate(from.get(Info_.book), book).addEqualsPredicate(from.get(Info_.topic), topic)
				.addEqualsPredicate(from.get(Info_.mark), mark).buildWithAndConjunction();
	}

	public InfoFilter(Builder builder) {
		this.fio = builder.fio;
		this.nameOfClass = builder.nameOfClass;
		this.subject = builder.subject;
		this.book = builder.book;
		this.topic = builder.topic;
		this.mark = builder.mark;
		this.id = builder.id;
	}

	public String getFio() {
		return fio;
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

	public Long getId() {
		return id;
	}

	public static class Builder {
		private Long id;
		private String fio;
		private String nameOfClass;
		private String subject;
		private String book;
		private String topic;
		private String mark;

		public Builder() {

		}

		public Builder fio(String val) {
			fio = val;
			return this;
		}

		public Builder nameOfClass(String val) {
			nameOfClass = val;
			return this;
		}

		public Builder subject(String val) {
			subject = val;
			return this;
		}

		public Builder book(String val) {
			book = val;
			return this;
		}

		public Builder topic(String val) {
			topic = val;
			return this;
		}

		public Builder mark(String val) {
			mark = val;
			return this;
		}

		public Builder id(Long val) {
			id = val;
			return this;
		}

		public InfoFilter build() {
			return new InfoFilter(this);
		}

	}
}
