import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetUniversidade {
    public static void main(String[] args) {
        final String url = "http://universities.hipolabs.com/search?country=Brazil";

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envio da requisição e obtenção da resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Exibição do código de status da resposta
            System.out.println("Código de Resposta: " + response.statusCode());

            if (response.statusCode() == 200) {
                System.out.println("Conteúdo do Retorno da API (JSON):");
                System.out.println(response.body());

                // Conversão do JSON para uma lista de objetos usando Jackson
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignora propriedades desconhecidas
                List<Universidade> universidades = mapper.readValue(response.body(), mapper.getTypeFactory().constructCollectionType(List.class, Universidade.class));

                // Exibição da lista de universidades
                System.out.println("\nConteúdo do Retorno da API (Objeto):");
                universidades.forEach(System.out::println);
            } else {
                System.out.println("Falha. Código de resposta: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
