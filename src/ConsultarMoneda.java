import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConusltarMoneda {

    public Moneda traerCotizacion(String tipoMoneda,int cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8f16b2096337b12e75a00db9/latest/USD");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), tipoMoneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontré una pelicula con el numero: " + tipoMoneda);
        }
    }
}
