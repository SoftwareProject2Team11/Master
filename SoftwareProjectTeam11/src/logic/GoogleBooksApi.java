package logic;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class GoogleBooksApi {
	private final String User_AgentChrome = "Chrome/62.0.3202.94";
	private final String User_AgentMozilla="Mozilla/5.0";
	public ArrayList<String> sendGetRequestChrome(String zoekwoord) throws Exception
	{
		//de JSON voor het gezochte woord opvragen
		String woord = zoekwoord.replace(" ", "+");
		String url = "https://www.googleapis.com/books/v1/volumes?q="+woord;
		URL obj = new URL(url);
		
		HttpURLConnection con =(HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User Agent", User_AgentChrome);
		
		
		System.out.println("\nSending 'GET' request to URL : " + url);
		
		BufferedReader input = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = input.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
		
		
	//JSON converten van JSON naar de data die wij nodig hebben en in een hashmap steken	
		HashMap<String,String>data = new HashMap<String,String>();
		JSONParser parser = new JSONParser();
		Object object = parser.parse(response.toString());
		JSONObject jsonObject = (JSONObject)object;
		
		JSONArray items = (JSONArray)jsonObject.get("items");
		int itemssize = items.size();
		for (int i=0;i<itemssize;i++ )
		{
			JSONObject o = (JSONObject)items.get(i);
			JSONObject volumeInfo= (JSONObject)o.get("volumeInfo");
			
			String itemTitle = (String)volumeInfo.get("title");
			data.put("Title "+(i+1)+": ",itemTitle);
			if(volumeInfo.get("authors")==null)
			{
				data.put("Authors from "+itemTitle+":","not given");	
				
			}
			else
			{
			JSONArray itemauthors = (JSONArray)volumeInfo.get("authors");
			
			for(int j=0;j<itemauthors.size();j++)
			{
				
				data.put("Authors from "+itemTitle+" Author "+(j+1)+":",itemauthors.get(j).toString());	
			
			}
			}
			String itemPublisher = (String)volumeInfo.get("publisher");
			data.put(itemTitle+" its publisher: ",itemPublisher);
			
			String itemPublishedDate=(String)volumeInfo.get("publishedDate");
			data.put(itemTitle+" its published date: ",itemPublishedDate);
			
			String itemDescription =(String)volumeInfo.get("description");
			data.put(itemTitle+" its description: ", itemDescription);
			
			
			if(volumeInfo.get("pageCount")==null)
			{
				data.put(itemTitle+" its amount of pages: ", "not given");
			}
			else
			{
				String itemPageCount =(String)volumeInfo.get("pageCount").toString();
				data.put(itemTitle+" its amount of pages: ", itemPageCount);
			}
			
			if(volumeInfo.get("averageRating")==null)
			{
				data.put(itemTitle+" its average rating: ", "not given");
			}
			else
			{
				String itemAverageRating =(String)volumeInfo.get("averageRating").toString();
				data.put(itemTitle+" its average rating: ", itemAverageRating);
			}
			if(volumeInfo.get("ratingsCount")==null)
			{
				data.put(itemTitle+" its ratings count: ", "not given");
			}
			else
			{
				String itemRatingsCount =(String)volumeInfo.get("ratingsCount").toString();
				data.put(itemTitle+" its ratings count: ", itemRatingsCount);
			}
			
			String itemPrintType = (String)volumeInfo.get("printType");
			data.put(itemTitle+" its sort: ",itemPrintType);
			
			JSONArray itemcategories = (JSONArray)volumeInfo.get("categories");
			for(int k=0;k<itemcategories.size();k++)
			{
				data.put("Categories from "+itemTitle+" categorie "+(k+1)+":",itemcategories.get(k).toString());	
			}
			
			String itemMaturityRating = (String)volumeInfo.get("maturityRating");
			data.put(itemTitle+" its maturity rating: ",itemMaturityRating);
		
			JSONObject itemImageLink = (JSONObject)volumeInfo.get("imageLinks");
			data.put(itemTitle+" its thumbnail: ",itemImageLink.get("thumbnail").toString());
		
			String itemLanguage = (String)volumeInfo.get("language");
			data.put(itemTitle+" its language: ",itemLanguage);
		
			String itemPreviewLink= (String)volumeInfo.get("previewLink");
			data.put(itemTitle+" its link to more info: ",itemPreviewLink);
		
			JSONObject saleInfo = (JSONObject)o.get("saleInfo");
			String itemSaleCountry = (String)saleInfo.get("country");
			data.put(itemTitle+"  where its sold: ",itemSaleCountry);
		
			String itemSaleability = (String)saleInfo.get("saleability");
			data.put(itemTitle+" is it for sale: ",itemSaleability);
		
			JSONObject searchInfo = (JSONObject)o.get("searchInfo");
			if(volumeInfo.get("textSnippet")==null)
			{
				
					data.put(itemTitle+" its amount of pages: ", "not given");
				}
				else
				{
			String itemTextSnippet = (String)searchInfo.get("textSnippet");
			data.put(itemTitle+" its short description: ",itemTextSnippet);
				}
		} ArrayList<String> ConvertedListData = new ArrayList<String>();
		 String convertedDataToString="";
		for (String key: data.keySet()){
	        String keyString =key.toString();
	        String value = data.get(key);  
	        convertedDataToString=keyString + " " + value;
	        ConvertedListData.add(convertedDataToString);
	        convertedDataToString="";

	}
		
		return ConvertedListData;
	}
	
	public ArrayList<String> sendGetRequestMozilla(String zoekwoord) throws Exception
	{

		//de JSON voor het gezochte woord opvragen
		String woord = zoekwoord.replace(" ", "+");
		String url = "https://www.googleapis.com/books/v1/volumes?q="+woord;
		URL obj = new URL(url);
		
		HttpURLConnection con =(HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User Agent", User_AgentMozilla);
		
		
		System.out.println("\nSending 'GET' request to URL : " + url);
		
		BufferedReader input = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = input.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
		
		
	//JSON converten van JSON naar de data die wij nodig hebben en in een hashmap steken	
		HashMap<String,String>data = new HashMap<String,String>();
		JSONParser parser = new JSONParser();
		Object object = parser.parse(response.toString());
		JSONObject jsonObject = (JSONObject)object;
		
		JSONArray items = (JSONArray)jsonObject.get("items");
		int itemssize = items.size();
		for (int i=0;i<itemssize;i++ )
		{
			JSONObject o = (JSONObject)items.get(i);
			JSONObject volumeInfo= (JSONObject)o.get("volumeInfo");
			
			String itemTitle = (String)volumeInfo.get("title");
			data.put("Title "+(i+1)+": ",itemTitle);
			
			if(volumeInfo.get("authors")==null)
			{
				data.put("Authors from "+itemTitle+":","not given");	
				
			}
			else
			{
			JSONArray itemauthors = (JSONArray)volumeInfo.get("authors");
			
			for(int j=0;j<itemauthors.size();j++)
			{
				
				data.put("Authors from "+itemTitle+" Author "+(j+1)+":",itemauthors.get(j).toString());	
			
			}
			}
			String itemPublisher = (String)volumeInfo.get("publisher");
			data.put(itemTitle+" its publisher: ",itemPublisher);
			
			String itemPublishedDate=(String)volumeInfo.get("publishedDate");
			data.put(itemTitle+" its published date: ",itemPublishedDate);
			
			String itemDescription =(String)volumeInfo.get("description");
			data.put(itemTitle+" its description: ", itemDescription);
			
			
			if(volumeInfo.get("pageCount")==null)
			{
				data.put(itemTitle+" its amount of pages: ", "not given");
			}
			else
			{
				String itemPageCount =(String)volumeInfo.get("pageCount").toString();
				data.put(itemTitle+" its amount of pages: ", itemPageCount);
			}
			
			if(volumeInfo.get("averageRating")==null)
			{
				data.put(itemTitle+" its average rating: ", "not given");
			}
			else
			{
				String itemAverageRating =(String)volumeInfo.get("averageRating").toString();
				data.put(itemTitle+" its average rating: ", itemAverageRating);
			}
			if(volumeInfo.get("ratingsCount")==null)
			{
				data.put(itemTitle+" its ratings count: ", "not given");
			}
			else
			{
				String itemRatingsCount =(String)volumeInfo.get("ratingsCount").toString();
				data.put(itemTitle+" its ratings count: ", itemRatingsCount);
			}
			
			String itemPrintType = (String)volumeInfo.get("printType");
			data.put(itemTitle+" its sort: ",itemPrintType);
			
			JSONArray itemcategories = (JSONArray)volumeInfo.get("categories");
			for(int k=0;k<itemcategories.size();k++)
			{
				data.put("Categories from "+itemTitle+" categorie "+(k+1)+":",itemcategories.get(k).toString());	
			}
			
			String itemMaturityRating = (String)volumeInfo.get("maturityRating");
			data.put(itemTitle+" its maturity rating: ",itemMaturityRating);
		
			JSONObject itemImageLink = (JSONObject)volumeInfo.get("imageLinks");
			data.put(itemTitle+" its thumbnail: ",itemImageLink.get("thumbnail").toString());
		
			String itemLanguage = (String)volumeInfo.get("language");
			data.put(itemTitle+" its language: ",itemLanguage);
		
			String itemPreviewLink= (String)volumeInfo.get("previewLink");
			data.put(itemTitle+" its link to more info: ",itemPreviewLink);
		
			JSONObject saleInfo = (JSONObject)o.get("saleInfo");
			String itemSaleCountry = (String)saleInfo.get("country");
			data.put(itemTitle+"  where its sold: ",itemSaleCountry);
		
			String itemSaleability = (String)saleInfo.get("saleability");
			data.put(itemTitle+" is it for sale: ",itemSaleability);
		
			JSONObject searchInfo = (JSONObject)o.get("searchInfo");
			if(volumeInfo.get("textSnippet")==null)
			{
				
					data.put(itemTitle+" its amount of pages: ", "not given");
				}
				else
				{
			String itemTextSnippet = (String)searchInfo.get("textSnippet");
			data.put(itemTitle+" its short description: ",itemTextSnippet);
				}
		}
		 ArrayList<String> ConvertedListData = new ArrayList<String>();
		 String convertedDataToString="";
		for (String key: data.keySet()){
	        String keyString =key.toString();
	        String value = data.get(key);  
	        convertedDataToString=keyString + " " + value;
	        ConvertedListData.add(convertedDataToString);
	        convertedDataToString="";
		}
		
		return ConvertedListData;
	}
	public static void main(String[]args) throws Exception
	{

		GoogleBooksApi gba = new GoogleBooksApi();
		
		System.out.println("Testing - Send Http GET request from Chrome");

		ArrayList<String> Testing1 = gba.sendGetRequestChrome("java programming");
		
		for(int j = 0;j<Testing1.size();j++)
		{
			System.out.println(Testing1.get(j).toString());
		}
	}
}
