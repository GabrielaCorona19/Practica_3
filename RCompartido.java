
package condicionescompetencias;

public class RCompartido {
    private String datoCompartido;
    private interrupcion[] inter;
    
    RCompartido(){
        inter = new interrupcion[2]; 
        for(int i =0; i<inter.length; i++)
            inter[i] = new interrupcion();
        datoCompartido="";
    }
    public int largo(){
        return inter.length;
    }
    
    public boolean comprobarInter(int i){
        return inter[i].getInter();
    }
    
    public void estadoInter(int i, boolean estado){
       inter[i].setDatoInter(estado);
    }

    
     public String getDatoCompartido() {
        return datoCompartido;
    }
    public void setDatoCompartido(String datoCompartido) {
        this.datoCompartido = datoCompartido;
    }
}
