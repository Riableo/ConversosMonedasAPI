package com.aluracursos.principal;

import com.aluracursos.modelos.ConsultaDivisa;
import com.aluracursos.modelos.Currency;
import com.aluracursos.modelos.FormatNumberCurrency;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ConsultaDivisa consultaDivisa = new ConsultaDivisa();
        FormatNumberCurrency numberFormatCurrency = new FormatNumberCurrency();
        int opcion = 1;
        try {
            while (opcion != 2) {
                System.out.println("Seleccione una opción");
                System.out.println("""
                        1. Convertir monedas
                        2. Salir
                        """);
                opcion = sc.nextInt();

                switch (opcion){
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

                        System.out.println(mount + " " + conversionResult.base_code() + " = "
                                + currencyResultFormat  + " " + conversionResult.target_code());

                        break;
                    case 2:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }


        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizando aplicacion");
    }

}
