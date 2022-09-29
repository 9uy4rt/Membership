package Mem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateCheck {
	LocalDate localDate = LocalDate.now();
	String date = localDate.format(DateTimeFormatter.ofPattern("MMdd"));
}