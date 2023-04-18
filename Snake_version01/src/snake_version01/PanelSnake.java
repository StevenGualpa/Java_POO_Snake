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
    String estado="start";
    Thread hilo;
    Caminante camino;
    
    int [] comida=new int [2];
            
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

        generarcomida();
        camino=new Caminante(this);
        hilo=new Thread(camino);
        
        hilo.start();
        
        
    }

    @Override
    public void paint(Graphics pintor)
    {
        super.paint(pintor);
        pintor.setColor(colorsnake);
        //pintar snake
        for (int [] par:snake) {
            pintor.fillRect(res/2+par[0]*tam, res/2+par[1]*tam, tam-1, tam-1);
        }
        //pintar comida
        pintor.setColor(colorcomida);
        pintor.fillRect(res/2+comida[0]*tam, res/2+comida[1]*tam, tam-1, tam-1);
    }
    
    public void avanzar()    
    {
        igualarDireccion();
         int [] ultimo=snake.get(snake.size()-1);
         int agregarx=0;
         int agregary=0;
         
         if(estado.equals("start"))
         {
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
                 case "stop":
                     hilo.stop();
                     break;
                 case "start":
                     hilo.start();
                     break;
         }
             int [] nuevo={Math.floorMod(ultimo[0]+agregarx, can),Math.floorMod(ultimo[1]+agregary, can) };
            // snake.add(nuevo);
            // snake.remove(0);
             boolean existe=false;
             for (int i = 0; i < snake.size(); i++) {
                 if(nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
                     existe=true;
                     break;
                 }
             }
             if(existe){
                 
             }else{
                 if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
                     snake.add(nuevo);
                     generarcomida();
                 }
                 else{
                     snake.add(nuevo);
                     snake.remove(0);
                 }
             }
         }

    }
    
    public void generarcomida(){
        boolean existe=false;
        int a= (int) (Math.random()*can);
        int b= (int) (Math.random()*can);
        
        for(int [] par:snake) {
            if(par[0]==a&&par[1]==b){
                existe=true;
                generarcomida();
                break;
            }
            
        }
        if(!existe)
        {
            this.comida[0]=a;
            this.comida[1]=b;
        }

    }
    
    public void cambiardireccion(String dir)    
    {
        //Se comprueba si es pausa
        if(dir.equals("stop")&&estado.equals("start"))    {
            estado="stop";
        }
        else if(dir.equals("stop")&&estado.equals("stop")){
        estado="start";
        }
        else{
            //Evitamos repetir la tecla
            if(!(this.direccion.equals(dir)))
                this.direccionproxima=dir;
        }


    }  

    public void igualarDireccion(){
            this.direccion=this.direccionproxima;
    }  
}
