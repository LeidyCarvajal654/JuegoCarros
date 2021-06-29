/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoFichero {
    
    public void LeerFichero() {
                try {
                   FileReader entrada = new FileReader("Escritorio/juego.txt");
                   int c = entrada.read();
                    while (c!=-1){
                     c = entrada.read();
                     char text = (char) c;
                     System.out.println(text);                     
                }
                    entrada.close();
               } catch (IOException ex) {
                    System.out.println("No se ha encontrado el archivo");
               }
           
       }
    
    public void escribir(){
        String texto = "";
        try {
            FileWriter escritura = new FileWriter("Escritorio/juego.txt");
            for (int i =0;i<texto.length();i++){
                escritura.write(texto.charAt(i));
            }
            escritura.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
