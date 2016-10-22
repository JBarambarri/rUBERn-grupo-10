
public class OpcionesCliente extends Formulario{

    public OpcionesCliente(){
        boolean b = true;
        while(b) {
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
            switch (i) {
                case 1:
                    generarCliente();
                    break;
                case 2:
                    if(BaseDeDatos.clientes.size()==0) {
                        System.out.println("No hay clientes disponibles. Se va a proceder a crear uno");
                        generarCliente();
                    }
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


    private Cliente generarCliente(){
        return new Cliente(Scanner.getLong("Ubicacion X del cliente: \t"),
        Scanner.getLong("Ubicacion Y del cliente: \t"),
        Scanner.getString("Nombre del cliente: \t") ,
        new Tarjeta(Scanner.getString("\n\033[4mDatos de la tarjeta:\033[0m\nNombre del banco: \t"), Scanner.getInt("Numero de la tarjeta: \t"), 1000)); //*
    }

    private static Viaje pedirViaje(Cliente unCliente){
        return unCliente.pedirViaje(
                Scanner.getLong("Destino en X: \t"),
                Scanner.getLong("Destino en Y: \t"),
                Scanner.getInt("Cantidad de pasajeros: \t"));
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

    private Cliente elegirCliente(){
        mostrarClientes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente. Si no se encuentra ingrese 0:\t");
        try{
            BaseDeDatos.clientes.get(i-1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ingrese sus datos:");
            generarCliente();
            i = BaseDeDatos.clientes.size();
        }
        return BaseDeDatos.clientes.get(i-1);


    }

    private static void mostrarClientes(){
        for(int i=0; i<BaseDeDatos.clientes.size(); i++){
            System.out.println("Cliente " + (i+1) + ": "+ BaseDeDatos.clientes.get(i).getNombre() + "\n");
        }
    }

}

//*nota respecto al saldo de la tarjeta: no corresponde que el cliente diga cuanto saldo tiene, por lo que se le asigno
//un saldo inicial de 1000$
