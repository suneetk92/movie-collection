package com.sk.app.movie_collection_database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public static List<MovieList> getMovieListFromExcel(String FILE_PATH_EXCEL) throws IOException {
		List<MovieList> list = new ArrayList<MovieList>();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(FILE_PATH_EXCEL);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet("Movies");
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				MovieList movieList = new MovieList();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (Cell.CELL_TYPE_NUMERIC == cell.getCellType() && cell.getColumnIndex() == 0) {
						movieList.setYear(((Double) cell.getNumericCellValue()).intValue());
					} else if (Cell.CELL_TYPE_STRING == cell.getCellType() && cell.getColumnIndex() == 1) {
						movieList.setMovieName(cell.getStringCellValue());
					}
				}
				list.add(movieList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return list;
	}
}
