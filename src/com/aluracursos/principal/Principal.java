package com.aluracursos.principal;

import com.aluracursos.modelos.ConsultaDivisa;
import com.aluracursos.modelos.Currency;
import com.aluracursos.formats.FormatNumberCurrency;
import com.aluracursos.modelos.HistorialConsola;
import com.aluracursos.modelos.HistorialConversiones;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsultaDivisa consultaDivisa = new ConsultaDivisa();
        FormatNumberCurrency numberFormatCurrency = new FormatNumberCurrency();

        HistorialConversiones historialConversiones = new HistorialConversiones();
        HistorialConsola conversionHistorial = new HistorialConsola();

        int opcion = 1;

        try {
            while (opcion != 2) {
                System.out.println("Seleccione una opción");
                System.out.println("""
                        1. Convertir monedas
                        2. Salir
                        """);
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Conversion de monedas");
                        List<String> divisasConvert = consultaDivisa.consultaDivisas();

                        String baseCurrency = divisasConvert.get(0);
                        String targetCurrency = divisasConvert.get(1);

                        System.out.println("Ingrese monto a convertir");
                        double mount = sc.nextDouble();

                        Currency conversionResult = consultaDivisa.convertirDivisa(baseCurrency, targetCurrency, mount);

                        // To convert number on own format
                        String currencyResultFormat = numberFormatCurrency.formatNumberCurrency(conversionResult.conversion_result());

                        String msg = mount + " " + conversionResult.base_code() + " = "
                                + currencyResultFormat + " " + conversionResult.target_code();

                        System.out.println(msg);

                        // Create log file with time
                        historialConversiones.historialConversiones(msg);

                        // Print in console historial
                        conversionHistorial.HistorialConsola(msg);

                        break;
                    case 2:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("ERROR: dato insertado no corresponde al tipo ");
        }catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizando aplicacion");
    }

}
