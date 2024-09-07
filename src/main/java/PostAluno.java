import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostAluno {
    public static void main(String[] args) {
        final String url = "https://httpbin.org/post";
        final String jsonInputString = "{\"id\": 1, \"nome\": \"João\", \"nota\": 70}";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .header("Content-Type", "application/json; utf-8")
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Código de resposta
            System.out.println("Código de Resposta: " + response.statusCode());

            // Conteúdo da resposta
            System.out.println("Conteúdo do Retorno da API (JSON):");
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
