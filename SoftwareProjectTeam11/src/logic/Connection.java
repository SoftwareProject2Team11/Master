package logic;

import java.net.HttpURLConnection;
import java.net.URL;

/*
 * @Author Krishna Srinivasan
 * bron: https://javabeat.net/internet-connection-java/
 * */


public class Connection {
	

	public boolean checkConnection()
	{
		boolean connection = false;
		try {
			try {
				URL url = new URL("http://www.google.com");
				System.out.println(url.getHost());
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();
				con.connect();
				if (con.getResponseCode() == 200){
					
					connection = true;
				}
			} catch (Exception exception) {
			
				connection = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	}
	

