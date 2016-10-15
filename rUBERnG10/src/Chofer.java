import java.util.ArrayList;

public class Chofer implements Persona{

    String nombre;
    Auto auto;
    Coordenada coordenada;
    boolean estado;


    public Chofer(String unNombre, long unaUbicacionX, long unaUbicacionY, Auto unAuto, Boolean unEstado){
        System.out.print("\n***************Chofer***************\n");
        nombre = unNombre;
        auto = unAuto;
        coordenada = new Coordenada(unaUbicacionX, unaUbicacionY);
        estado = unEstado;
        BaseDeDatos.choferes.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }



    public Auto getAuto() {
        return auto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }



    public String recibirPropuesta(){
        return Scanner.getString("Ingrese 'si' si acepta el viaje" + "\n" + "Ingrese 'no' si no acepta el viaje:\t");
    }
}
