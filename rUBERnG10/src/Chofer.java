import java.util.ArrayList;

public class Chofer {

    String nombre;
    Auto auto;
    Coordenada coordenada;
    boolean estado;
    double saldo;



    public Chofer(String unNombre, long unaUbicacionX, long unaUbicacionY, Auto unAuto, boolean unEstado){
        nombre = unNombre;
        auto = unAuto;
        coordenada = new Coordenada(unaUbicacionX, unaUbicacionY);
        estado = unEstado;
        saldo = 0;
        BaseDeDatos.choferes.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }


    public double getSaldo() {
        return saldo;
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
