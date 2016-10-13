public class Cliente {

    String nombre;
    Coordenada ubicacion;


    public Cliente(){
        System.out.print("\n***************Cliente***************\n");
        nombre = Scanner.getString("Nombre del cliente: \t");
        long ubicacionX = Scanner.getLong("Ubicacion X del cliente: \t");
        long ubicacionY = Scanner.getLong("Ubicacion Y del cliente: \t");
        ubicacion = new Coordenada(ubicacionX, ubicacionY);
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

    public SolicitudViaje pedirViaje(){
        System.out.println();
        long coordenadaDestinoX = Scanner.getLong("Ingrese destino en X:\t");
        long coordenadaDestinoY = Scanner.getLong("Ingrese destino en Y:\t");
        Jornada jornada = new Jornada(ubicacion, new Coordenada(coordenadaDestinoX, coordenadaDestinoY));
        return new SolicitudViaje(jornada, Scanner.getInt("Ingrese la cantidad de pasajeros:\t"));
    }

}
