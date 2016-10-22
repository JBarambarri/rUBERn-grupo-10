
public class Categoria{

    String nombre;
    int porcentajeDeCostoAdicional;

    public Categoria(String unNombre, int unPorcentajeDeCostoAdicional){
        nombre = unNombre;
        porcentajeDeCostoAdicional = unPorcentajeDeCostoAdicional;
        BaseDeDatos.categorias.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcentajeDeCostoAdicional() {
        return porcentajeDeCostoAdicional;
    }
}
