package com.sk.app.movie_collection_database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {
	private static final WriteToExcel	INSTANCE	= new WriteToExcel();

	public static WriteToExcel getInstance() {
		return INSTANCE;
	}

	public static String setMovieListToExcel(List<MovieList> movieLists, String FILE_PATH_EXCEL) throws IOException {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			inputStream = new FileInputStream(FILE_PATH_EXCEL);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet("Movies");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		int rowIndex = sheet.getLastRowNum() + 1;
		for (MovieList movieList : movieLists) {
			Row row = sheet.createRow(rowIndex++);
			int cellIndex = 0;
			row.createCell(cellIndex++).setCellValue(movieList.getYear());
			row.createCell(cellIndex++).setCellValue(movieList.getMovieName());
		}
		try {
			outputStream = new FileOutputStream(FILE_PATH_EXCEL);
			workbook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
		return null;
	}
}
