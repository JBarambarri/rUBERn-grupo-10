import org.joda.time.DateTime;

public class Viaje {

    Jornada jornada;
    int cantidadDePasajeros;
    DateTime dateAndTime;


    public Viaje(Jornada unaJornada, int unaCantidadDePasajeros){
        jornada = unaJornada;
        cantidadDePasajeros = unaCantidadDePasajeros;
        new GestionLogistica(this);
        this.dateAndTime = DateTime.now();
    }

    public String datosDelViaje(){
        return "\nUbicacion pasajero:\t(" + jornada.coordenadaInicial.coordenadaX + "," + jornada.coordenadaInicial.coordenadaY + ")\n" +
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
