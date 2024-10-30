package com.aluracursos.modelos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialConversiones {
    public void historialConversiones(String message) throws IOException {
        LocalDateTime actualTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dateFormat = actualTime.format(dateTimeFormatter);

        File f = new File("historial_conversiones.txt");

        if (!f.exists()) {
            System.out.println("Not exists file ");

            FileWriter archivoConversiones = new FileWriter("historial_conversiones.txt");
            archivoConversiones.write("["+dateFormat+"]" + " " + message);
            archivoConversiones.close();
        }else {
            System.out.println("Exists file ");
            // Create log file with time
            FileWriter fw = new FileWriter("historial_conversiones.txt", true);
            fw.write("\n["+dateFormat+"]" + " " + message);
            fw.close();
        }

    }
}
