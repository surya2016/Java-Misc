package common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.digest.DigestUtils;


public class FirebaseConnections {
	/**
	 * Function to fetch user data
	 * @param userKey
	 * @param newDB
	 * @return user data
	 * @throws IOException
	 */
	public String getData(String userKey, String path) throws IOException {
		try {
			/*
			 * HTTPS request URL formation
			 */
			URL url = null;
			url = new URL("https://company.firebaseio.com/users/"+userKey+path+".json?auth=authkey");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json;");
			/*
			 * Sending request
			 */
			connection.connect();
			if(connection.getResponseCode() != 200 && connection.getResponseCode() != 201 && connection.getResponseCode() != 404) {
				return null;
			} else if(connection.getResponseCode() == 404) {
				return null;
			}
			return readInputStreamToString(connection);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
 	}
	
	private String readInputStreamToString(HttpsURLConnection connection) {
	    String result = null;
	    StringBuffer sb = new StringBuffer();
	    InputStream is = null;

	    try {
	        is = new BufferedInputStream(connection.getInputStream());
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String inputLine = "";
	        while ((inputLine = br.readLine()) != null) {
	            sb.append(inputLine);
	        }
	        result = sb.toString();
	    }
	    catch (Exception e) {
	        result = null;
	    }
	    finally {
	        if (is != null) {
	            try { 
	                is.close(); 
	            } 
	            catch (IOException e) {
	            	
	            }
	        }   
	    }
	    return result;
	}
	
	public String getUserKey(String userId, String email) {		
		
		return "a" + DigestUtils.shaHex(email + "salt" + userId);
	}
}