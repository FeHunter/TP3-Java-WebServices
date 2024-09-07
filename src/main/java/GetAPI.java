import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetAPI {
    public static void main (String[] args){
        final String site = "https://api.zippopotam.us/us/90201";

        try {
            HttpClient cliente = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(site))
                    .GET()
                    .build();

            // Envio da requisição e obtenção da resposta
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código de Resposta: " + response.statusCode());

            if (response.statusCode() == 200) {
                System.out.println("Conteúdo do Retorno da API (JSON):");
                System.out.println(response.body());

                // Conversão do JSON para um objeto usando Jackson
                ObjectMapper mapper = new ObjectMapper();
                Localizacao locationResponse = mapper.readValue(response.body(), Localizacao.class);

                // Exibição do objeto convertido
                System.out.println("\nConteúdo do Retorno da API (Objeto):");
                System.out.println(locationResponse);
            } else {
                System.out.println("Falha. Código de resposta: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
