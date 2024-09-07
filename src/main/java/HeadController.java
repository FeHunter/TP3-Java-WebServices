import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HeadController {
    public static void main (String[] args){
        final String site = "https://g1.com.br";

        try {
            URL url = URI.create(site).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");

            // Código de resposta
            pegarResposta(connection);

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (String key : headers.keySet()){
                System.out.println(key + ": " + headers.get(key));
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int pegarResposta (HttpURLConnection connection) throws IOException {
        System.out.println("Código: " + connection.getResponseCode() + " Messagem: " + connection.getResponseMessage());
        return connection.getResponseCode();
    }
}
