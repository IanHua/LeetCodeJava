/**
 * 535. Encode and Decode TinyURL
 * Fixed-length random string -> longUrl
 * while loop in encode to avoid collision
 * Difficult to predict the pattern of shortUrl
 * O(1)
 */
public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random r = new Random();
    HashMap<String, String> map = new HashMap<String, String>();
    String path = getRand();
    
    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(path)) {
            path = getRand();
        }
        map.put(path, longUrl);
        return "http://tinyurl.com/" + path;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String path = shortUrl.replace("http://tinyurl.com/", "");
        if (map.containsKey(path)) {
            return map.get(path);
        } else {
            return null;
        }
    }
}