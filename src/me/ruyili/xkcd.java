package me.ruyili;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class xkcd {

	
	private static String parse(String web, String get) throws JsonIOException, JsonSyntaxException, IOException{
	    URL url = new URL(web);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    JsonParser jp = new JsonParser();
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    JsonObject rootobj = root.getAsJsonObject(); 
	    String res = rootobj.get(get).getAsString();
	    
	    return res;
	}
	
	public static File getImageFile(int page) throws JsonIOException, JsonSyntaxException, IOException{
		String imageLink = parse("http://xkcd.com/" + page + "/info.0.json", "img");
		URL url = new URL(imageLink);
		BufferedImage img = ImageIO.read(url);
		File file = new File("downloaded.png");
		ImageIO.write(img, "png", file);
		return file;
	}
	
	public static String getImageURL(int page) throws JsonIOException, JsonSyntaxException, IOException{
		String imageLink = parse("http://xkcd.com/" + page + "/info.0.json", "img");
		return imageLink;
	}
	
	public static String getNewestURL() throws JsonIOException, JsonSyntaxException, IOException{
		String imageLink = parse("http://xkcd.com/info.0.json", "img");
		return imageLink;
	}
	
	public static File getNewestImageFile() throws JsonIOException, JsonSyntaxException, IOException{
		String imageLink = parse("http://xkcd.com/info.0.json", "img");
		URL url = new URL(imageLink);
		BufferedImage img = ImageIO.read(url);
		File file = new File("downloaded.png");
		ImageIO.write(img, "png", file);
		return file;
	}
	
	
	public static String getTitle(int page) throws IOException{
	    URL url = new URL("http://xkcd.com/" + page + "/info.0.json");
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    JsonParser jp = new JsonParser();
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    JsonObject rootobj = root.getAsJsonObject(); 
	    String title = rootobj.get("safe_title").getAsString();
	    
	    return title;
	}
	
	public static String getAlt(int page) throws IOException{
	    URL url = new URL("http://xkcd.com/" + page + "/info.0.json");
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    JsonParser jp = new JsonParser();
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    JsonObject rootobj = root.getAsJsonObject(); 
	    String alt = rootobj.get("alt").getAsString();
	    
	    return alt;
	}
	
	public static String getNewestPageNumber() throws IOException{
	    URL url = new URL("http://xkcd.com/info.0.json");
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    JsonParser jp = new JsonParser();
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    JsonObject rootobj = root.getAsJsonObject(); 
	    String num = rootobj.get("num").getAsString();
	    
	    return num;
	}
	
}
