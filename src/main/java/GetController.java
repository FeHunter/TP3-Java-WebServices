import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GetController {
    public static void main (String[] args){
        final String site = "https://example.com";

        try {
            URL url = URI.create(site).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Código de resposta
            pegarResposta(connection);

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (String key : headers.keySet()){
                System.out.println(key + ": " + headers.get(key));
            }

            // Exbir código da pagina
            exibirConteudoDaPagina(connection);

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

    static void exibirConteudoDaPagina (HttpURLConnection connection) throws IOException{
        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String linha;
        while ((linha = br.readLine()) != null){
            System.out.println(linha);
        }
        br.close();
    }
}
