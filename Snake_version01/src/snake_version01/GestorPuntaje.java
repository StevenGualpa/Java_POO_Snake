/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_version01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestorPuntaje 
{
        
    public void VaciarTexto(){
        try {
            File archivo = new File("src\\Recursos/puntajes.txt");
            FileWriter escritorArchivo = new FileWriter(archivo, false);
            escritorArchivo.write("");
            escritorArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Escribir(String valor){
          FileWriter escritorArchivo = null;
                     try {
                         File archivo = new File("src\\Recursos/puntajes.txt");
                         escritorArchivo = new FileWriter(archivo);
                         escritorArchivo.write(valor);
                     } catch (IOException ex) {
                         Logger.getLogger(PanelSnake.class.getName()).log(Level.SEVERE, null, ex);
                     } finally {
                         try {
                             escritorArchivo.close();
                         } catch (IOException ex) {
                             JOptionPane.showMessageDialog(null, ex.toString());
                         }
                     }
    }
    public String Leer(){
        FileReader lectorArchivo = null;
        String linea="";
        String retorno="";
         try {
             File archivo = new File("src\\Recursos/puntajes.txt");
             lectorArchivo = new FileReader(archivo);
             BufferedReader bufferLector = new BufferedReader(lectorArchivo);
             
             while ((linea = bufferLector.readLine()) != null) {
             retorno=linea;
             }


         } catch (FileNotFoundException ex) {
             Logger.getLogger(PanelSnake.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(PanelSnake.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             try {
                 lectorArchivo.close();
             } catch (IOException ex) {
                 Logger.getLogger(PanelSnake.class.getName()).log(Level.SEVERE, null, ex);
             }
         }

return retorno;
    }
}
