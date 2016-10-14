
public class Categoria {

    String nombre;
    int porcentajeDeCostoAdicional;

    public Categoria(){
        nombre = Scanner.getString("Ingrese el nombre de la categoria del auto:\t");
        porcentajeDeCostoAdicional = Scanner.getInt("Ingrese el porcentaje de costo adicional:\t");
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcentajeDeCostoAdicional() {
        return porcentajeDeCostoAdicional;
    }
}
