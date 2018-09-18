package com.dictionary.view.dto;

/**
 * Created by antonPC on 16.05.15.
 */
public class Vocabulary {

    private String topic;
    private String word;
    private Integer mark;
    private String link;

    public Vocabulary() {
    }

    public Vocabulary( String topic, String word, Integer mark, String link) {
        this.topic = topic;
        this.word = word;
        this.mark = mark;
        this.link = link;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return topic ;
    }
}
