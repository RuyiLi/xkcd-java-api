package me.ruyili;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Xkcd {

    private BufferedImage image;
    private String title;
    private String safeTitle;
    private String alt;
    private String transcript;
    private String link;
    private String imageUrl;
    private int number;
    private int month;
    private int year;
    private int day;

    private JsonObject fetchMetadata(URL url) throws IOException {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonObject();
    }

    private void parse(JsonObject metadata) {
        this.title = metadata.get("title").getAsString();
        this.safeTitle = metadata.get("safe_title").getAsString();
        this.alt = metadata.get("alt").getAsString();
        this.transcript = metadata.get("transcript").getAsString();
        this.link = metadata.get("link").getAsString();
        this.imageUrl = metadata.get("img").getAsString();
        this.number = metadata.get("num").getAsInt();
        this.month = metadata.get("month").getAsInt();
        this.year = metadata.get("year").getAsInt();
        this.day = metadata.get("day").getAsInt();
    }

    private Xkcd(URL url) throws IOException {
        JsonObject metadata = fetchMetadata(url);
        parse(metadata);
    }

    public Xkcd(int number) throws IOException {
        this(getXkcdMetadataUrl(number));
    }

    public Xkcd() throws IOException {
        this(getNewestXkcdMetadataURL());
    }

    public static URL getNewestXkcdMetadataURL() {
        try {
            return new URL("http://xkcd.com/info.0.json");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static URL getXkcdMetadataUrl(int page) {
        if (page <= 0) {
            throw new IllegalArgumentException("page must be positive");
        }
        try {
            return new URL("http://xkcd.com/" + page + "/info.0.json");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public BufferedImage getImage() throws IOException {
        if (image == null) {
            URL url = new URL(imageUrl);
            image = ImageIO.read(url);
        }
        return image;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAlt() {
        return alt;
    }

    public int getNumber() {
        return number;
    }

    public String getSafeTitle() {
        return safeTitle;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getLink() {
        return link;
    }


    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

}
