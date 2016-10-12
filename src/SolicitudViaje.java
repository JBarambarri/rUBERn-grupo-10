
public class SolicitudViaje {

    Jornada jornada;
    int cantidadDePasajeros;

    public SolicitudViaje(Jornada unaJornada, int unaCantidadDePasajeros){
        jornada = unaJornada;
        cantidadDePasajeros = unaCantidadDePasajeros;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public int getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }
}
