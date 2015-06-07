package com.sk.app.movie_collection_database;

import java.util.ArrayList;
import java.util.List;

public class App {
	private static final String	FILE_PATH_EXCEL		= "D:/Users/Sk/Documents/MovieList.xlsx";
	private static final String	FILE_PATH_FOLDER	= "H:/Movies";

	public static void main(String[] args) {
		try {
			List<MovieList> list1 = ReadFromExcel.getMovieListFromExcel(FILE_PATH_EXCEL);
			System.out.println(list1);
			List<String> list2 = ReadFromFolder.getMovieListFromFolder(FILE_PATH_FOLDER);
			System.out.println(list2);
			List<MovieList> list3 = ParseFolderNameToMovieList.getMovieListFromFoldername(list2);
			System.out.println(list3);
			List<MovieList> list4 = new ArrayList<MovieList>();
			for (MovieList movieList : list3) {
				if(!list1.contains(movieList)){
					list4.add(movieList);
				}
			}
			System.out.println(list4);
			WriteToExcel.setMovieListToExcel(list4, FILE_PATH_EXCEL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
