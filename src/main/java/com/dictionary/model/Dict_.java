package com.dictionary.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Dict.class)
public abstract class Dict_ {

	public static volatile SingularAttribute<Dict, String> className;
	public static volatile SingularAttribute<Dict, String> word;
	public static volatile SingularAttribute<Dict, String> subject;
	public static volatile SingularAttribute<Dict, String> book;
	public static volatile SingularAttribute<Dict, String> topic;
	public static volatile SingularAttribute<Dict, Integer> mark;

}