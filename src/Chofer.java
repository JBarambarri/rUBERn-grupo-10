
public class Chofer {

    String nombre;
    Auto auto;
    Coordenada coordenada;
    boolean estado;


    public Chofer(String unNombre, Auto unAuto, Coordenada unaCoordenada, boolean unEstado){
        nombre = unNombre;
        auto = unAuto;
        coordenada = unaCoordenada;
        estado = unEstado;
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
}
