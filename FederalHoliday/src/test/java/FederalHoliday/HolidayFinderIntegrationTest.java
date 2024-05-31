package FederalHoliday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import junit.framework.TestCase;

public class HolidayFinderIntegrationTest extends TestCase {
	
	public void testArrayList() throws JsonMappingException, JsonProcessingException, ClientError {
		HolidayFinder hf = new HolidayFinder();
    	ArrayList holidays = hf.getHolidays("2024");
    	
    	boolean columbusDayFound = false;
    	Iterator it = holidays.iterator();
    	while (it.hasNext()) {
			Holiday holiday = (Holiday) it.next();
			// System.out.println(holiday.localName);
			// System.out.println(holiday.date);
			// System.out.println("")
			if ( (holiday.localName.equals("Columbus Day"))&&(holiday.getDate().equals("2024-10-14")) ) {
				columbusDayFound = true;
				break;
			}
		}
    	    	
        assertTrue( "Columbas day not found.", columbusDayFound);
    }
	
//	public void testToday() {
//		HolidayFinder hf = new HolidayFinder();
//    	String holiday = hf.whatHolidayIsToday(new Date());
//    	System.out.println(holiday);
//    	    	
//        assertTrue( true );
//    }
	
	public void testNewYears() throws JsonMappingException, JsonProcessingException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.DAY_OF_YEAR, 1);    
		Date firstDay = cal.getTime();
		
		HolidayFinder hf = new HolidayFinder();
    	String holiday = hf.whatHolidayIsToday(firstDay);
    	//System.out.println(holiday);
    	    	
        assertEquals( "New Year's Day", holiday );
    }
	
	public void testNotAHoliday() throws JsonMappingException, JsonProcessingException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.DAY_OF_YEAR, 3);    
		Date firstDay = cal.getTime();
		
		HolidayFinder hf = new HolidayFinder();
    	String holiday = hf.whatHolidayIsToday(firstDay);
    	//System.out.println(holiday);
    	    	
    	assertEquals( "Not a holiday", holiday );
    }
}
