package com.aluracursos.modelos;

import java.util.ArrayList;

public class HistorialConsola {

    private ArrayList<String> conversionHistorial = new ArrayList<String>();

    public void HistorialConsola(String conversion) {

        conversionHistorial.add(conversion);

        System.out.println("Historial de conversion:");
        for (String item:conversionHistorial) {
            System.out.println(item);
        }
    }
}
