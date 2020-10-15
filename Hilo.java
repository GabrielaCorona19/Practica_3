
package condicionescompetencias;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    private int tiempo;
    
    Hilo(JTextArea area, RCompartido rc, int tiempo){
        this.area = area; 
        this.rc = rc;
        this.muerto = false;
        this.tiempo = tiempo;
    }  
    public void matar(){
        this.muerto = true;
    }   
    public void run(){
        boolean bandera = false;
        while(true){
            try{
                int largo = rc.largo();
                bandera = false;
                sleep(tiempo);

                for(int i = 0; i<largo; i++)
                    if(rc.comprobarInter(i) == true)
                        bandera = true;

                if (bandera == false){
                    //Aca entra a su sección critica
                    rc.setDatoCompartido(this.getName());
                    
                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, true);
                    
                    if(muerto == true)
                        this.stop();

                    area.append(rc.getDatoCompartido()+ "\n");

                    sleep(1000);

                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, false);
                }
            }catch(Exception e){e.printStackTrace();}
        }
    }
    
}
