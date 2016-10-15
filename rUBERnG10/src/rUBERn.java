public class rUBERn {

    int distanciaMinima = 10;


    public static void main(String args[]) {

        boolean b = true;

        while (b) {

            System.out.println();
            System.out.println("1. Añadir Cliente ");
            System.out.println("2. Añadir Chofer");
            System.out.println("3. Añadir Auto ");
            System.out.println("4. Añadir Categoria");
            System.out.println("5. Pedir Viaje");
            System.out.println("6. Salir");


            int i = Scanner.getInt("\nIngrese el numero correspondiente a la opcion que desee  ");

            switch (i) {
                case 1:
                    generarCliente();
                    break;
                case 2:
                    generarChofer();
                    break;
                case 3:
                    generarAuto();
                    break;
                case 4:
                    generarCategoria();
                    break;
                case 5:
                    pedirViaje(generarCliente()); //TEMPORAL. NO: crear un nuevo cliente cada vez que pedis viaje.
                    break;
                case 6:
                    b = false;
                    break;

                default:
                    throw new OpcionIngresadaNoValida();

            }
        }
    }


    private static Cliente generarCliente(){
        return new Cliente(Scanner.getLong("Ubicacion X del cliente: \t"),
        Scanner.getLong("Ubicacion Y del cliente: \t"),
        Scanner.getString("Ingrese el nombre del cliente: \t") );
    }

    private static Chofer generarChofer(){
        return new Chofer(Scanner.getString("Ingrese el nombre del chofer: \t"),
        Scanner.getLong("Ubicacion X del chofer: \t"),
        Scanner.getLong("Ubicacion Y del chofer: \t"),
        generarAuto(),
        Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está: \t")));
    }

    private static Auto generarAuto() {
        System.out.println("\n\033[4mDatos del auto:\033[0m");
        return new Auto(Scanner.getString("Ingrese la marca del auto \t"),
        Scanner.getInt("Ingrese la capcidad maxima del auto: \t"),
        generarCategoria());
    }

    private static Categoria generarCategoria(){
        return new Categoria(Scanner.getString("Ingrese el nombre de la categoria del auto:\t"),
        Scanner.getInt("Ingrese el porcentaje de costo adicional:\t"));
    }

    private static Viaje pedirViaje(Cliente unCliente){
        return unCliente.pedirViaje(
        Scanner.getLong("Ingrese el destino en X: \t"),
        Scanner.getLong("Ingrese el destino en Y: \t"),
        Scanner.getInt("Ingrese la cantidad de pasajeros: \t"));
    }
}
