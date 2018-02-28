
package boletin20;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Boletin20 {

    public static void main(String[] args) {
        int opcion;
        ArrayList<Libros> lista = new ArrayList<>();
        
        do{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Engadir libro\n"
                + "2. Consultar libro\n"
                + "3. Visualizar todos los datos del fichero\n"
                + "4. Borrar libros\n"
                + "5. Modificar precio"));
        Libreria lib = new Libreria();
        
        
        switch(opcion){
            case 1:
                lib.crear();
                lista = lib.engadir();
                break;
            case 2: 
                lib.consultar(lista);
                break;
            case 3:
                lib.visualizarFicheiro(lista);
                break;      
            case 4:
                lib.borrar(lista);
                break;
            case 5:    
                lib.modificarPrecio(lista);
            case 0:
                System.exit(opcion);
        }
        
        }while(opcion<6);
    }
    
}
