
public class Categoria {

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


    public int compare(Categoria c1, Categoria c2) {
        if(c1.getPorcentajeDeCostoAdicional() > c2.getPorcentajeDeCostoAdicional()) return -1;
        if(c1.getPorcentajeDeCostoAdicional() < c2.getPorcentajeDeCostoAdicional()) return 1;
        return 0;
    }
}
