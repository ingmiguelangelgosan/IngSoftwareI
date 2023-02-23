package model;

import java.io.File;
import java.io.FilenameFilter;

public class Carpeta {

    private String rutaCarpeta;
    private String palabra;

    public Carpeta(String rutaCarpeta, String palabra) {
        this.rutaCarpeta = rutaCarpeta;
        this.palabra = palabra;
    }

    public static void obtenerArchivos(String rutaCarpeta, String palabra) {

        File carpeta = new File(rutaCarpeta);

        // Crear un filtro para archivos con extensiones .txt, .xml, .json o .csv
        FilenameFilter filtro = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || name.endsWith(".xml") || name.endsWith(".json")
                        || name.endsWith(".csv");
            }
        };

        // Obtener una lista de archivos en la carpeta que cumplan con el filtro
        File[] archivos = carpeta.listFiles(filtro);
        int totalPalabras = 0;

        // Verificar que la dirección de la carpeta sea correcta o que la carpeta exista
        if (archivos != null) {

            // Verificar que si existan archivos con las extensiones requeridas
            if (archivos.length == 0) {
                System.out.println("\nNo se encontraron archivos de texto en la carpeta\n");
            } else {
                System.out.println();

                // Recorrer la lista de archivos y obtener la ruta de cada uno
                for (File archivo : archivos) {
                    String rutaArchivo = archivo.getAbsolutePath();
                    int palabrasPorArchivo = Archivo.buscarPalabra(rutaArchivo, palabra);
                    totalPalabras += palabrasPorArchivo;

                    System.out.println(archivo.getName() + " " + palabrasPorArchivo + " veces");
                }
                System.out.println("\nTotal: " + totalPalabras + " veces");
            }
        } else {
            System.out.println("\nNo se ha podido encontrar la carpeta indicada\n");
        }
    }

}
