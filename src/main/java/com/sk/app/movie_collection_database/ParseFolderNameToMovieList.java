package com.sk.app.movie_collection_database;

import java.util.ArrayList;
import java.util.List;

public class ParseFolderNameToMovieList {
	public static List<MovieList> getMovieListFromFoldername(List<String> folder) {
		List<MovieList> list = new ArrayList<MovieList>();
		for (String file : folder) {
			MovieList movieList = new MovieList();
			String[] fileName = file.split("] ");
			movieList.setYear(Integer.parseInt(fileName[0].substring(1)));
			movieList.setMovieName(fileName[1]);
			list.add(movieList);
		}
		return list;
	}
}
