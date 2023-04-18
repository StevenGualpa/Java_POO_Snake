package snake_version01;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Steve
 */
public class PanelFondo extends JPanel
{
    Color colorfondo=Color.gray;
    int tammax,tam,can,res; 
    
            
    public PanelFondo(int tanmax,int can)
    {  
        this.tammax=tanmax;
        this.can=can;
        this.tam=tammax/can;
        this.res=tammax%can;
    }

    @Override
    public void paint(Graphics pintor)
    {
        super.paint(pintor);
        pintor.setColor(colorfondo);
        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {
                pintor.fillRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
            }
        }
    }

}


