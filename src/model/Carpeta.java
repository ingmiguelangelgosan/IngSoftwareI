package model;
import model.Archivo;
import java.io.File;
import java.io.FilenameFilter;

public class Carpeta {
    
    private String rutaCarpeta;
    private String palabra;

    public Carpeta(String rutaCarpeta, String palabra){
        this.rutaCarpeta = rutaCarpeta;
        this.palabra = palabra;
    }

    public static void obtenerArchivos(String rutaCarpeta, String palabra){
        
        // Crear un objeto File para representar la carpeta
        File carpeta = new File(rutaCarpeta);
        
        // Crear un filtro para archivos con extensiones .txt, .xml, .json o .csv
        FilenameFilter filtro = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || name.endsWith(".xml") || name.endsWith(".json") || name.endsWith(".csv");
            }
        };
        
        // Obtener una lista de archivos en la carpeta que cumplan con el filtro
        File[] archivos = carpeta.listFiles(filtro);
        
        // Recorrer la lista de archivos y obtener la ruta de cada uno
        for (File archivo : archivos) {
            String rutaArchivo = archivo.getAbsolutePath();
            //System.out.println(rutaArchivo);
                System.out.println(archivo.getName()+ " " + Archivo.buscarPalabra(rutaArchivo,palabra) + " veces");
            
        }
    }

}

