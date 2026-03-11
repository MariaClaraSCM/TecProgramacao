package br.edu.fatecpg.atvd3.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApiCnpj {
    public String buscarEmpresa(String cnpj) throws Exception {

        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

