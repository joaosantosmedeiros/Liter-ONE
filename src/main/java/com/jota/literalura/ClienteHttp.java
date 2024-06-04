package com.jota.literalura;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public Livro buscarLivro(String titulo) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String uri = "https://gutendex.com/books/?search=" + titulo.replaceAll(" ", "%20");

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(httpResponse.body(), GutendexResponse.class).getResults()[0];
    }

}
class GutendexResponse {
    private Livro[] results;

    public Livro[] getResults() {
        return results;
    }

    public void setResults(Livro[] results) {
        this.results = results;
    }
}
