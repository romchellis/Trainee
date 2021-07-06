package ex.training.multithreading;


import org.junit.jupiter.api.Test;

public class UrlShortenerTest {

    private final TinyUrl shortener = new UrlShortener();


    @Test
    public void shortUrlTest() {


        String willBeDeleted = shortener.shortUrl("www.russia.com", "russland");
        String russland = shortener.shortUrl("www.russia.com", "russland");
        String longRussland = shortener.longUrl(russland);

//        assertEquals();
    }
}