import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HeadTestes {

    @Test
    void testeCodigoResposta() throws IOException {
        HttpURLConnection connectionMock = mock(HttpURLConnection.class);

        when(connectionMock.getResponseCode()).thenReturn(200);

        int codigoResposta = HeadController.pegarResposta(connectionMock);
        assertEquals(200, codigoResposta, "O código de resposta deveria ser 200.");
    }
}
