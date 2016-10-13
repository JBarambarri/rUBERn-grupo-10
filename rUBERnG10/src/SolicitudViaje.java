
public class SolicitudViaje {

    Jornada jornada;
    int cantidadDePasajeros;


    public SolicitudViaje(Jornada unaJornada, int unaCantidadDePasajeros){
        jornada = unaJornada;
        cantidadDePasajeros = unaCantidadDePasajeros;
        new GestionLogistica(this);
    }

    public String datosDelViaje(){
        return "Ubicacion pasajero:\t(" + jornada.coordenadaInicial.coordenadaX + "," + jornada.coordenadaInicial.coordenadaY + ")\n" +
                "Destino:\t(" + jornada.coordenadaFinal.coordenadaX + "," + jornada.coordenadaFinal.coordenadaY +")\n" +
                "Cantidad de pasajeros:" + "\t" + cantidadDePasajeros + "\n\n";
    }

    public Jornada getJornada() {
        return jornada;
    }

    public int getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }

}
