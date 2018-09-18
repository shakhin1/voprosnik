package com.dictionary.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Info.class)
public abstract class Info_ {

	public static volatile SingularAttribute<Info, String> fio;
	public static volatile SingularAttribute<Info, String> nameOfClass;
	public static volatile SingularAttribute<Info, String> subject;
	public static volatile SingularAttribute<Info, String> book;
	public static volatile SingularAttribute<Info, String> topic;
	public static volatile SingularAttribute<Info, String> mark;
}
