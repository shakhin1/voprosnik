package com.dictionary.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.dictionary.service.FileService;

public class FileServiceImpl implements FileService {
	private final String PRE_PATH = "C://databases//results//";

	@Override
	public void write(String fileName, String text) {

		File file = new File(PRE_PATH + fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));

			try {
				bufferedWriter.append(text);
				bufferedWriter.flush();
			}
			finally {
				bufferedWriter.close();
				fileOutputStream.close();
			}
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
