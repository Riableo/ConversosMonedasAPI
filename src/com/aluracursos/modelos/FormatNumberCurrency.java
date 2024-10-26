package com.aluracursos.modelos;

import java.text.DecimalFormat;

public class FormatNumberCurrency {
    public String formatNumberCurrency(double numero) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(numero);
    }
}
