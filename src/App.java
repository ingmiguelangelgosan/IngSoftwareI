import java.util.Scanner;

import model.Carpeta;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Carpeta.obtenerArchivos("/home/sirmiguel/Documentos/Universidad/Semestre VI-II/Ing de Software I/Tarea_1/contarPalabras/pruebas1","arar");
        //Carpeta.obtenerArchivos("/home/sirmiguel/Documentos/Universidad/Semestre VI-II/Ing de Software I/Tarea_1/contarPalabras/pruebas2","foto");
        //Carpeta.obtenerArchivos("/home/sirmiguel/Documentos/Universidad/Semestre VI-II/Ing de Software I/Tarea_1/contarPalabras/pruebas3","ejemplo");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduce la ruta completa de la carpeta: ");
        String rutaCarpeta = sc.nextLine();
        
        System.out.print("\nIntroduce la palabra que deseas buscar: ");
        String busquedaPalabra = sc.nextLine();

        Carpeta.obtenerArchivos(rutaCarpeta, busquedaPalabra);
    }
}
