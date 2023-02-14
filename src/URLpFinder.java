import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class URLpFinder {

    public int findP(String textUrl){

        java.net.URL url;

        try {
            url = new java.net.URL(textUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try(InputStreamReader in = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(in)) {

            String inputLine;
            int count = 0;
            while ((inputLine = bufferedReader.readLine()) != null){
                if (inputLine.contains("<p ") || inputLine.contains("<p>")){
                    count++;
                }
            }

            return count;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
