package com.aluracursos.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsultaDivisa {

    public List<String> consultaDivisas(){
        Scanner sc = new Scanner(System.in);
        List<String> divisas = Arrays.asList("ARS - Peso argentino",
                "BOB - Boliviano boliviano",
                "BRL - Real brasileño",
                "CLP - Peso chileno",
                "COP - Peso colombiano",
                "USD - Dólar estadounidense");

        int action = 0;
        List<String> resultListCurrency =new ArrayList<>();
        while (action < 2){
            int acc = 0;
            for (String item:divisas){
                acc++;
                System.out.println(acc+". "+item);
            }

            int currBase = sc.nextInt();
            System.out.println("Moneda a convertir: " + divisas.get(currBase-1));
            resultListCurrency.add(divisas.get(currBase-1).substring(0,3));
            action++;
        }

        return resultListCurrency;
    }

    public Currency convertirDivisa(String divisaConvetir, String divisaResultado, double mount) {
        String direcccionURL = "https://v6.exchangerate-api.com/v6/059bc03a7082d034552de7e1/pair/" + divisaConvetir + "/" + divisaResultado + "/" + mount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direcccionURL))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        }catch (Exception e){
            throw new RuntimeException("No fue posible la conversion" + e.getMessage());
        }
    }
}