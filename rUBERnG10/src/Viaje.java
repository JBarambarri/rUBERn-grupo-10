import org.joda.time.DateTime;

public class Viaje {

    Jornada jornada;
    int cantidadDePasajeros;
    DateTime dateAndTime;
    Cliente cliente;
    String codigoViaje;



    public Viaje(Jornada unaJornada, int unaCantidadDePasajeros, Cliente unCliente, String unCodigoViaje){
        jornada = unaJornada;
        cantidadDePasajeros = unaCantidadDePasajeros;
        this.dateAndTime = DateTime.now();
        cliente = unCliente;
        codigoViaje = unCodigoViaje;

        new GestionLogistica(this, unCliente);

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

    public DateTime getDateAndTime() {
        return dateAndTime;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCodigoViaje() {
        return codigoViaje;
    }


}
