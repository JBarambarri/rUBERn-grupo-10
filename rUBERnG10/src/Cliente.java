public class Cliente {

    String nombre;
    Coordenada ubicacion;
    Tarjeta tarjeta;


    public Cliente(String unNombre, long unaUbicacionX, long unaUbicacionY, Tarjeta unaTarjeta) {
        nombre = unNombre;
        ubicacion = new Coordenada(unaUbicacionX, unaUbicacionY);
        tarjeta = unaTarjeta;
        BaseDeDatos.clientes.add(this);
    }




    public String getNombre() {
        return nombre;
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenada ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public Viaje pedirViaje(long unaUbicacionDestinoX, long unaUbicacionDestinoY, int unaCantidadDePasajeros){
        System.out.println();
        Jornada jornada = new Jornada(ubicacion, new Coordenada(unaUbicacionDestinoX, unaUbicacionDestinoY));
        return new Viaje(jornada, unaCantidadDePasajeros, this, new RandomString(6).nextString());
    }

}
