package FederalHoliday;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class QueryFederalHolidays {    
        
    String queryNagar(String year) throws ClientError {
        String endpoint = "https://date.nager.at/api/v3/publicholidays/"+year+"/US";
        
        try {
            // Create a URL object
            URL url = new URL(endpoint.toString());

            // Open a connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Check the response code
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) { // 200 OK
                String responseString = extractResponse(false,conn);

                return responseString;                
            } else if (responseCode == 400) {
                String responseString = extractResponse(true,conn);
                throw new ClientError(responseString);         
            }

        } catch (ClientError e) {
        	throw e;   	        	
        } catch (Exception e) {
	    	// we will pretend that the console is our log for now
	    	System.out.println(e.getMessage());
	    	System.out.println(e.getStackTrace());        	        	
	    }
		return "Unhandled Communications error.  Please call support.";  
    }

	private String extractResponse(boolean error,HttpURLConnection conn) throws IOException {
		// Read the response
		BufferedReader infile = null;
		if (error) {
			infile = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		else {
			infile = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}
		StringBuilder responseString = new StringBuilder();
		String inputLine;
		while ((inputLine = infile.readLine()) != null) {
		    responseString.append(inputLine);
		}
		infile.close();
		return responseString.toString();
	}
	
	

    
}
