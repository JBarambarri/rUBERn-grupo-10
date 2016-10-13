
public class Auto {

    String marca;
    int capacidadMaxima;
    Categoria categoria;

    public Auto(Categoria unaCategoria){
        marca = Scanner.getString("Ingrese la marca del auto");
        capacidadMaxima = Scanner.getInt("Ingrese la capacidad maxima del auto");
        categoria = unaCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
