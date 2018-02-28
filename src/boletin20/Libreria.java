
package boletin20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Libreria {
    private Scanner sc;
    private File fich;
    private PrintWriter escribir;
    ArrayList<Libros> arrayLibros= new ArrayList<Libros>();
    Libros lib;

    
    public void crear(){
        fich = new File("libreria.txt");
        if(fich.exists()){
            String linea;
            String[] lista=new String[4];
            Libros lib;
            try{
                sc=new Scanner(new File("libreria.txt"));
                while(sc.hasNextLine()){
                    linea=sc.nextLine();
                    lista=linea.split(",");
                    lib=new Libros(lista[0],lista[1],Float.parseFloat(lista[2]),Integer.parseInt(lista[3]));
                    arrayLibros.add(lib);
                }
            }catch(FileNotFoundException ex){
                System.out.println("No se encuentra el archivo");
            }
            
            sc.close();
        }
      
    }
    
    public ArrayList<Libros> engadir(){
 
        String titulo = JOptionPane.showInputDialog("Título");
        String autor = JOptionPane.showInputDialog("Autor");
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio"));
        int unidades = Integer.parseInt(JOptionPane.showInputDialog("Unidades"));

        Libros lib = new Libros(titulo,autor,precio,unidades);
        arrayLibros.add(lib);
   
        try{
            fich = new File("libreria.txt");
            escribir = new PrintWriter(fich);
            
            for(int i=0;i<arrayLibros.size();i++){
                lib = arrayLibros.get(i);
                escribir.println(lib.getNome()+","+lib.getAutor()+","+lib.getPrecio()+","+lib.getUnidades());
            }
               
        }catch(FileNotFoundException ex){
            System.out.println("error");
        }finally{
            escribir.close();
        }
          for(int i=0;i<arrayLibros.size();i++){
            System.out.println(arrayLibros.get(i));
        }
         return arrayLibros;
    }
    
    public void consultar(ArrayList<Libros>lista){
        float precio = 0;
        
        String titulo = JOptionPane.showInputDialog("escribe un título");
            for(int i=0;i<lista.size();i++){
                if(lista.get(i).getNome().equalsIgnoreCase(titulo)){
                    precio = lista.get(i).getPrecio();
                }else{
                    System.out.println("No se encuentra el libro");
                }
            }        
            System.out.println(precio);    

    }
    
    public void visualizarFicheiro(ArrayList<Libros>lista){
        for(int i=0;i<lista.size();i++){   
            System.out.println(lista.get(i).toString());
        } 
    }
    
    public void borrar(ArrayList<Libros>lista){
        int cantidad=0;
        for(int i=0;i<lista.size();i++){   
            if(lista.get(i).getUnidades()==0){
                lista.remove(i);
            } 
        } 
    }
    
    public void modificarPrecio(ArrayList<Libros>lista){
        String titulo = JOptionPane.showInputDialog("Escribe el título del libro que quieras modificar");
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio a modificar"));
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNome().equalsIgnoreCase(titulo)){
                lista.get(i).setPrecio(precio);
                
            }else{
                System.out.println("No se encuentra ese libro");
            }
        }
        
    }

}