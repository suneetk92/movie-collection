package com.sk.app.movie_collection_database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFolder {
	public static List<String> getMovieListFromFolder(String FILE_PATH_FOLDER) {
		File[] files = null;
		List<String> list = new ArrayList<String>();
		try {
			files = new File(FILE_PATH_FOLDER).listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					list.add(file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
