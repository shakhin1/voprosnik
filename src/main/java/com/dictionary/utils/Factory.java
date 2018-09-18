package com.dictionary.utils;

import com.dictionary.dao.DictDao;
import com.dictionary.dao.InfoDao;
import com.dictionary.dao.impl.DictDaoImpl;
import com.dictionary.dao.impl.InfoDaoImpl;
import com.dictionary.service.FileService;
import com.dictionary.service.impl.FileServiceImpl;

public final class Factory {

	private static DictDao dictDao = null;
	private static InfoDao infoDao = null;
	private static FileService fileService = null;
	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public DictDao getDictDao() {
		if (dictDao == null) {
			dictDao = new DictDaoImpl();
		}
		return dictDao;
	}

	public InfoDao getInfoDao() {
		if (infoDao == null) {
			infoDao = new InfoDaoImpl();
		}
		return infoDao;
	}

	public FileService getFileService() {
		if (fileService == null) {
			fileService = new FileServiceImpl();
		}
		return fileService;
	}

}
