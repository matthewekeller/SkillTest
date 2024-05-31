package FederalHoliday;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HolidayFinder {
	
	ArrayList<Holiday> getHolidays(String year) throws JsonMappingException, JsonProcessingException, ClientError {
		
		ArrayList<Holiday> holidays = new ArrayList<Holiday>();
        
        // Get the JSON response
    	QueryFederalHolidays qfh = new QueryFederalHolidays();
        String jsonString = qfh.queryNagar(year);  // 400 error will be thrown from here
        
        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        holidays = objectMapper.readValue(jsonString, new TypeReference<ArrayList<Holiday>>() {});
                
        return holidays;
    }
	
	String whatHolidayIsToday(Date today) throws JsonMappingException, JsonProcessingException {
		String notFoundMessage = "Not a holiday";
		
		String yearPattern = "yyyy";
		DateFormat df = new SimpleDateFormat(yearPattern);		
		String yearAsString = df.format(today);
		
		ArrayList<Holiday> holidays = null;
		try {
			holidays = getHolidays(yearAsString);
		} catch (ClientError e) {
        	// Parse the 400 error
			ObjectMapper objectMapper = new ObjectMapper();
        	ErrorResponse errorResponse = objectMapper.readValue(e.getMessage(), ErrorResponse.class);
        	return errorResponse.getTitle() + ":" +  objectMapper.writeValueAsString(errorResponse.getErrors());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		
		String dayPattern = "yyyy-MM-dd";
		DateFormat df2 = new SimpleDateFormat(dayPattern);		
		String dayAsString = df2.format(today);
		
		Iterator it = holidays.iterator();
    	while (it.hasNext()) {
			Holiday holiday = (Holiday) it.next();
			if (holiday.date.equals(dayAsString)) {
				return holiday.localName;
			}			
		} 
		return notFoundMessage;
	}

}
