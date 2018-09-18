package com.dictionary.utils;

import com.dictionary.model.Dict;
import com.dictionary.view.dto.Vocabulary;
import com.google.common.base.Function;

/**
 * Created by antonPC on 17.05.15.
 */
public final class InvokeFunctions {
    public static Function<Dict, String> INVOKE_GET_SUBJECT = new Function<Dict, String>() {
        @Override
        public String apply(final Dict entity) {
            return entity.getSubject();
        }
    };

    public static Function<Dict, String> INVOKE_GET_BOOK = new Function<Dict, String>() {
        @Override
        public String apply(final Dict entity) {
            return entity.getBook();
        }
    };

    public static Function<Dict, Vocabulary> INVOKE_GET_TOPIC = new Function<Dict, Vocabulary>() {
        @Override
        public Vocabulary apply(final Dict entity) {
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setLink(entity.getLink());
            vocabulary.setMark(entity.getMark());
            vocabulary.setTopic(entity.getTopic());
            vocabulary.setWord(entity.getWord());
            return vocabulary;
        }
    };
}
