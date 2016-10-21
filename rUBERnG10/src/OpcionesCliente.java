
public class OpcionesCliente extends Formulario{

    public OpcionesCliente(){
        show();
        boolean b = true;
        while(b) {
            switch (Scanner.getInt("Ingrese la opcion correspondiente:\t")) {
                case 1:
                    generarCliente();
                    break;
                case 2:
                    pedirViaje(elegirCliente());
                    break;
                case 3:
                    b = false;
                    break;
                default:
                    throw new OpcionIngresadaNoValida();
            }
        }
    }


    public Cliente generarCliente(){
        return new Cliente(Scanner.getLong("Ubicacion X del cliente: \t"),
        Scanner.getLong("Ubicacion Y del cliente: \t"),
        Scanner.getString("Ingrese el nombre del cliente: \t") );
    }

    private static Viaje pedirViaje(Cliente unCliente){
        return unCliente.pedirViaje(
                Scanner.getLong("Ingrese el destino en X: \t"),
                Scanner.getLong("Ingrese el destino en Y: \t"),
                Scanner.getInt("Ingrese la cantidad de pasajeros: \t"));
    }

    @Override
    void mostrarTitulo() {
        System.out.println("\n**********\033[1mCLIENTE\033[0m**********");
    }

    @Override
    void mostrarContenido() {
        System.out.println("1. Añadir Cliente ");
        System.out.println("2. Pedir Viaje");
        System.out.println("3. Salir");
    }

    private static Cliente elegirCliente(){
        mostrarClientes();
        int i = Scanner.getInt("Ingrese el numero correspondiente:\t");
        return BaseDeDatos.clientes.get(i);
    }

    private static String mostrarClientes(){
        String s = "";
        for(int i=0; i<BaseDeDatos.clientes.size(); i++){
            System.out.println("Cliente " + i + ": "+ BaseDeDatos.clientes.get(i).getNombre());
        }
        return s;
    }



}