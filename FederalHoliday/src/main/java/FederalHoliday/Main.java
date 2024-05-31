package FederalHoliday;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Main {
	
	
	 // see unit tests to run more scenarios
	 public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		 HolidayFinder hf = new HolidayFinder();
		 String whatHolidayIsToday = hf.whatHolidayIsToday(new Date());
		 System.out.println("Today is "+whatHolidayIsToday);
    }

}
