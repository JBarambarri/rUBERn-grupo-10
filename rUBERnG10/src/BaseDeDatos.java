import java.util.ArrayList;

public class BaseDeDatos {

    static ArrayList<Chofer> choferes = new ArrayList<>();

    static ArrayList<Categoria> categorias = new ArrayList<>();

    static ArrayList<Auto> autos = new ArrayList<>();

    static ArrayList<Cliente> clientes = new ArrayList<>();

    static ArrayList<ViajesRealizados> viajesRealizados = new ArrayList<>();

    static void mostrarChoferes(){
        System.out.println();
        for(int i=0; i<BaseDeDatos.choferes.size(); i++){
            System.out.println("Chofer " + (i+1) + ": "+ BaseDeDatos.choferes.get(i).getNombre() + "\n");
        }
    }

    static void mostrarCategorias(){
        System.out.println();
        for(int i=0; i<BaseDeDatos.categorias.size(); i++){
            System.out.println("Categoria " + (i+1) + ": "+ BaseDeDatos.categorias.get(i).getNombre() + "\n");
        }
    }

    static void mostrarAutos(){
        System.out.println();
        for(int i=0; i<BaseDeDatos.autos.size(); i++){
            System.out.println("Auto " + (i+1) + ": "+ BaseDeDatos.autos.get(i).getMarca() + "\n");
        }
    }

    static void mostrarClientes(){
        System.out.println();
        for(int i=0; i<BaseDeDatos.clientes.size(); i++){
            System.out.println("Cliente " + (i+1) + ": "+ BaseDeDatos.clientes.get(i).getNombre() + "\n");
        }
    }

}

