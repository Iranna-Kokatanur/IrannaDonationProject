package months;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Helllo {
	
	public static void main(String[] args) {
		
		long monthsBetween = ChronoUnit.MONTHS.between(
			     YearMonth.from(LocalDate.of(2020,11,29)), 
			     YearMonth.from(LocalDate.of(2021,01,01))
			);
		System.out.println(monthsBetween);
	}

}
