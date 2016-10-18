public class Cliente implements Persona{

    String nombre;
    Coordenada ubicacion;


    public Cliente(long unaUbicacionX, long unaUbicacionY, String unNombre) {
        nombre = unNombre;
        ubicacion = new Coordenada(unaUbicacionX, unaUbicacionY);
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


    public Viaje pedirViaje(long unaUbicacionDestinoX, long unaUbicacionDestinoY, int unaCantidadDePasajeros){
        System.out.println();
        Jornada jornada = new Jornada(ubicacion, new Coordenada(unaUbicacionDestinoX, unaUbicacionDestinoY));
        return new Viaje(jornada, unaCantidadDePasajeros);
    }

}
