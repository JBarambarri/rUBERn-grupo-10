
public class OpcionesCliente extends Formulario{

    Scanner scanner;

    public OpcionesCliente(Scanner unScanner){
        scanner = unScanner;

        boolean b = true;
        while(b) {
            show();
            int i = scanner.getInt("\nIngrese la opcion correspondiente:\t");
            try{
                switch (i){
                    case 1: case 2: case 3: break;
                    default:
                        throw new OpcionIngresadaNoValida();
                }
            }
            catch (OpcionIngresadaNoValida o){
                System.out.println("Ingrese una opcion valida por favor");
                new OpcionesCliente(scanner);
            }
            switch (i) {
                case 1:
                    generarCliente(scanner);
                    break;
                case 2:
                    if(BaseDeDatos.clientes.size()==0) {
                        System.out.println("No hay clientes disponibles. Se va a proceder a crear uno");
                        pedirViaje(generarCliente(scanner));
                    }else{
                        pedirViaje(elegirCliente(scanner));

                    }
                    break;
                case 3:
                    b = false;
                    break;
            }
        }
    }


    private Viaje pedirViaje(Cliente unCliente){
        return unCliente.pedirViaje(
                scanner.getLong("\nDestino en X: \t"),
                scanner.getLong("Destino en Y: \t"),
                scanner.getInt("\n"+"Cantidad de pasajeros: \t"),
                scanner);
    }

    @Override
    void mostrarTitulo() {
        System.out.println("\n**********\033[1mCLIENTE\033[0m**********");
    }

    @Override
    void mostrarContenido() {
        System.out.format("+-----------------+---------------+%n");
        System.out.format("|     Opciones    |  N de Opcion  |%n");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Añadir Cliente  |       1       |");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Pedir Viaje     |       2       |");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Salir           |       3       |");
        System.out.format("+-----------------+---------------+%n");
    }
}


