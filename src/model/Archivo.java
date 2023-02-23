package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {

    private String palabra;
    private String ruta;

    public Archivo(String ruta, String palabra) {
        this.palabra = palabra;
        this.ruta = ruta;
    }

    public static int buscarPalabra(String ruta, String palabra) {
        int contador = 0;

        try (BufferedReader leerTexto = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = leerTexto.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String i : palabras) {
                    if (i.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
        } catch (IOException m) {
            m.printStackTrace();
        }

        return contador;

    }
}
