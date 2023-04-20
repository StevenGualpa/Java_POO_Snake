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
public class SnakeTiempo implements Runnable
{
    private JLabel tiempoLabel;
    boolean estado=true;
    public SnakeTiempo(JLabel tiempoLabel) {
        this.tiempoLabel = tiempoLabel;
    }

    @Override
    public void run() {
        int segundos = 0;
        int minutos = 0;
        int horas = 0;
        
        while (true) {
            try {
                Thread.sleep(1000); // espera un segundo
                segundos++;
                
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                
                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                }
                
                String tiempo = "Tiempo: "+ String.format("%02d:%02d:%02d", horas, minutos, segundos);
                tiempoLabel.setText(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

