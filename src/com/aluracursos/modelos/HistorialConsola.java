package com.aluracursos.modelos;

import java.util.ArrayList;

public class HistorialConsola {

    private final ArrayList<String> conversionHistorial = new ArrayList<>();

    public void historialConversionConsole(String conversion) {

        conversionHistorial.add(conversion);

        System.out.println("Historial de conversion:");
        for (String item:conversionHistorial) {
            System.out.println(item);
        }
    }
}
