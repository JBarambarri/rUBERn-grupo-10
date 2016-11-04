
public class Auto {

    String marca;
    int capacidadMaxima;
    Categoria categoria;

    public Auto(String unaMarca, int unaCapacidadMaxima, Categoria unaCategoria){
        marca = unaMarca;
        capacidadMaxima = unaCapacidadMaxima;
        categoria = unaCategoria;
        BaseDeDatos.autos.add(this);
    }

    public String getMarca() {
        return marca;
    }


    public Categoria getCategoria() {
        return categoria;
    }
}
