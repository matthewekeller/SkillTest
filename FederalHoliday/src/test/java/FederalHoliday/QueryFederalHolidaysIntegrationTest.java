package FederalHoliday;

import junit.framework.TestCase;

public class QueryFederalHolidaysIntegrationTest extends TestCase {
    
    
    public void testJsonStringForNewYears() throws ClientError {
    	QueryFederalHolidays qfh = new QueryFederalHolidays();
    	String json = qfh.queryNagar("2024");
    	//System.err.println(json);
        assertTrue(json.contains("{\"date\":\"2024-01-01\",\"localName\":\"New Year's Day\",\"name\":\"New Year's Day\"") );
    }
    
    public void testJsonStringForError() throws ClientError {
    	QueryFederalHolidays qfh = new QueryFederalHolidays();
    	boolean exceptionThrown = false;
    	try {
    		String json = qfh.queryNagar("202400");
    	} catch (ClientError e) {
    		exceptionThrown = true;    	
	    } catch (Exception e) {
			exceptionThrown = true;
		}
    	assertTrue("ClientError exception should have been thrown",exceptionThrown);
    }
}
