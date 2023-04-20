/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_version01;

import javax.swing.JLabel;

/**
 *
 * @author Steve
 */
public class SnakePuntaje implements Runnable
{
    private JLabel puntajeLabel;
    boolean estado=true;
    GestorPuntaje Gestor;
    public SnakePuntaje(JLabel puntajeLabel) {
        
        this.puntajeLabel = puntajeLabel;
      
    }

    @Override
    public void run() {
        int segundos = 0;
        int minutos = 0;
        int horas = 0;
        Gestor=new GestorPuntaje();
        while (true) {
            try {
                Thread.sleep(100); // espera un segundo
                
                String puntaje = "Puntaje: "+Gestor.Leer();
                puntajeLabel.setText(puntaje);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

