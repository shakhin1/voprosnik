package com.dictionary.dao.filters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dictionary.model.Dict;
import com.dictionary.model.Dict_;
import com.dictionary.utils.PredicateBuilder;


public class DictFilter extends AbstractFilter {
	private Long id;
	private String className;
	private String word;
	private String subject;
	private String book;
	private String topic;
	private Integer mark;
	private String link;
	private String type;

	public DictFilter(Builder builder) {
		this.className = builder.className;
		this.word = builder.word;
		this.subject = builder.subject;
		this.book = builder.book;
		this.topic = builder.topic;
		this.mark = builder.mark;
		this.id = builder.id;
		this.link = builder.link;
		this.type = builder.type;
	}

	public Predicate getPredicate(CriteriaBuilder cb, Root<Dict> from) {
		return new PredicateBuilder(cb).addEqualsPredicate(from.get(Dict_.className), className).addEqualsPredicate(from.get(Dict_.word), word)
				.addEqualsPredicate(from.get(Dict_.subject), subject).addEqualsPredicate(from.get(Dict_.book), book)
				.addEqualsPredicate(from.get(Dict_.topic), topic).addEqualsPredicate(from.get(Dict_.mark), mark).buildWithAndConjunction();
	}

	public String getClassName(Boolean tru) {
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static class Builder {
		private Long id;
		private String className;
		private String word;

		private String subject;
		private String book;
		private String topic;
		private Integer mark;
		private String link;
		private String type;

		public Builder() {

		}

		public Builder className(String val) {
			className = val;
			return this;
		}

		public Builder word(String val) {
			word = val;
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

		public Builder mark(Integer val) {
			mark = val;
			return this;
		}

		public Builder id(Long val) {
			id = val;
			return this;
		}

		public Builder link(String val){
			link = val;
			return this;
		}

		public Builder type(String val){
			type = val;
			return this;
		}

		public DictFilter build() {
			return new DictFilter(this);
		}

	}

}
