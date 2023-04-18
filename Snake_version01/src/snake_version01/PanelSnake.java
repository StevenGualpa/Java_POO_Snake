package snake_version01;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Steve
 */
public class PanelSnake extends JPanel{
     Color colorsnake=Color.blue;
     Color colorcomida=Color.red;
    int tammax,tam,can,res; 
    List<int []> snake =new ArrayList<>();
    String direccion="de";
    String direccionproxima="de";

    Thread hilo;
    Caminante camino;
            
    public PanelSnake(int tanmax,int can)
    {  
        this.tammax=tanmax;
        this.can=can;
        this.tam=tammax/can;
        this.res=tammax%can;
        int []a= {can/2-1,can/2-1};
        int []b= {can/2,can/2-1};
        snake.add(a);
        snake.add(b);

        camino=new Caminante(this);
        hilo=new Thread(camino);
        hilo.start();
    }

    @Override
    public void paint(Graphics pintor)
    {
        super.paint(pintor);
        pintor.setColor(colorsnake);
        for (int [] par:snake) {
        
            pintor.fillRect(res/2+par[0]*tam, res/2+par[1]*tam, tam-1, tam-1);
            
        }
    }
    
    public void avanzar()    
    {
        igualarDireccion();
         int [] ultimo=snake.get(snake.size()-1);
         int agregarx=0;
         int agregary=0;
         switch(this.direccion)    
         {
             case "de":
                 agregarx=1;
                 break;
             case "iz":
                 agregarx=-1;
                 break;
             case "ar":
                 agregary=-1;
                 break;
             case "ab":
                 agregary=1;
                 break;

         }
   //int [] nuevo={ultimo[0]+agregarx,ultimo[1]+agregary };
        int [] nuevo={Math.floorMod(ultimo[0]+agregarx, can),Math.floorMod(ultimo[1]+agregary, can) };
         snake.add(nuevo);
         snake.remove(0);
    }
    
    
    
    public void cambiardireccion(String dir)    
    {
this.direccionproxima=dir;

    }  

    public void igualarDireccion(){
            this.direccion=this.direccionproxima;
    }  
}
