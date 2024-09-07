import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostAlunoController {
    public static void main(String[] args) {
        final String url = "https://httpbin.org/post";
        final String jsonInputString = "{\"id\": 1, \"nome\": \"João\", \"nota\": 70}";

        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Envio dos dados
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Código de resposta
            int responseCode = connection.getResponseCode();
            System.out.println("Código de Resposta: " + responseCode);

            // Leitura da resposta
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Conteúdo do Retorno da API (JSON):");
                System.out.println(response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
