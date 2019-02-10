package com.librarymanagement.utility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateTimeUtility {
	public static LocalDate getDateFromString(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
}
