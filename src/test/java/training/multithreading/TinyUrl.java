package training.multithreading;

public interface TinyUrl {
    String BASE_URL = "http://tinyurl.com/";

    String shortUrl(String url, String seoWord);

    String longUrl(String shortUrl);
}
