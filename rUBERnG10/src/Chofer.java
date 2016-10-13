import java.util.ArrayList;
import java.util.Objects;

public class Chofer {

    String nombre;
    Auto auto;
    Coordenada coordenada;
    boolean estado;

    public static ArrayList<Chofer> choferes = new ArrayList<>();

    public static ArrayList<Chofer> getList(){
        return choferes;
    }



    public Chofer(String unNombre, Auto unAuto, Coordenada unaCoordenada, boolean unEstado){
        nombre = unNombre;
        auto = unAuto;
        coordenada = unaCoordenada;
        estado = unEstado;
        choferes.add(this);

    }

    public String getNombre() {
        return nombre;
    }

    public Auto getAuto() {
        return auto;
    }

    public Coordenada getCoordenada() {
        return coordenada;
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


    public String recibirPropuesta(SolicitudViaje viaje){
        System.out.print(viaje.datosDelViaje());
        return Scanner.getString("Ingrese 'si' si acepta el viaje" + "\n" + "Ingrese 'no' si no acepta el viaje");
    }
}
