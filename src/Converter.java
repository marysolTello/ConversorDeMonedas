import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    private String url_api;
    private int cantidad;
    private String pais1;
    private String pais2;

    public Converter(String url_api, int cantidad, String pais1, String pais2){
        this.cantidad = cantidad;
        this.url_api = url_api;
        this.pais1 = pais1;
        this.pais2 = pais2;
    }

    public String conversion() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl_api() + getPais1() +
                        "/"+ getPais2() + "/" + String.valueOf(getCantidad())))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        ConvertExchanges results = gson.fromJson(response.body(), ConvertExchanges.class);
        return "El Resultado de Convertir " + getCantidad() + " " + getPais1() + " a " +
                getPais2() + " es: " + results.conversion_result() + " " +
                getPais2();
    }

    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPais1() {
        return pais1;
    }

    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public String getPais2() {
        return pais2;
    }

    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }
}
