package me.ruyili;

import java.awt.image.BufferedImage;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Victor
 */
public class XkcdTest {

    private Xkcd xkcd;

    @Before
    public void setup() throws IOException {
        xkcd = new Xkcd(789);
    }

    public XkcdTest() {

    }

    @Test
    public void testGetImage() throws IOException {
        BufferedImage image = xkcd.getImage();
        assertEquals(740, image.getWidth());
        assertEquals(181, image.getHeight());
    }
    @Test
    public void testGetImageURL() {
        String expected = "http://imgs.xkcd.com/comics/showdown.png";
        String actual = xkcd.getImageURL();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle() {
        String expected = "Showdown";
        String actual = xkcd.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAlt() {
        String expected = "The tumbleweed then tried to roll off into the sunset, but due to the Old West's placement north of the subtropical ridge, the prevailing winds were in the wrong direction.";
        String actual = xkcd.getAlt();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumber() {
        int expected = 789;
        int actual = xkcd.getNumber();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSafeTitle() {
        String expected = "Showdown";
        String actual = xkcd.getSafeTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTranscript() {
        String expected ="[[Two cowboys face off silently in the desert, the blazing sun beating down.]]\n\n[[They exchange steely glares, hands poised to reach their guns, as a tumbleweed rolls into frame.]]\n<<TUMBLE>>\n\n[[Close-up on the tumbleweed. It draws two guns.]]\n<<CLICK CLICK>>\n\n[[The tumbleweed shoots both cowboys simultaneously, and they fall backwards.]]\n<<BLAM BLAM>>\n\n{{Title text: The tumbleweed then tried to roll off into the sunset, but due to the Old West's placement north of the subtropical ridge, the prevailing winds were in the wrong direction.}}";
        String actual = xkcd.getTranscript();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLink() {
        String expected ="";
        String actual = xkcd.getLink();
        assertEquals(expected, actual);        
    }

    @Test
    public void testGetImagrUrl() {
        
        String expected ="http://imgs.xkcd.com/comics/showdown.png";
        String actual = xkcd.getImageURL();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMonth() {
        int expected = 9;
        int actual = xkcd.getMonth();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetYear() {
        int expected = 2010;
        int actual = xkcd.getYear();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDay() {
        int expected = 6;
        int actual = xkcd.getDay();
        assertEquals(expected, actual);
    }

}
