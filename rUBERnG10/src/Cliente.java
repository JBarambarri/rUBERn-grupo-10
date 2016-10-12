
public class Cliente {

    String nombre;
    Coordenada ubicacion;


    public Cliente(String unNombre, Coordenada unaUbicacion){
        nombre = unNombre;
        ubicacion = unaUbicacion;
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
    
}
