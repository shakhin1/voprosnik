package com.dictionary.service;

import org.springframework.stereotype.Service;


@Service
public interface FileService {

	public void write(String path, String text);
}
