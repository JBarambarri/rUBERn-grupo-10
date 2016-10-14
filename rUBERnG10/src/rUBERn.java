public class rUBERn {

    int distanciaMinima = 10;


    public static void main(String args[]) {

        System.out.println("1. Añadir Cliente ");
        System.out.println("2. Añadir Chofer");
        System.out.println("3. Añadir Auto ");
        System.out.println("4. Añadir Categoria");
        System.out.println("5. Pedir Viaje");
        System.out.println("6. Salir");

        boolean b = true;

        while (b) {
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
        return new Cliente();
    }

    private static Chofer generarChofer(){
        return new Chofer(generarAuto());
    }

    private static Auto generarAuto() {
        System.out.println("Datos del auto:\n");
        return new Auto(generarCategoria());
    }

    private static Categoria generarCategoria(){
        return new Categoria(Scanner.getString("Ingrese el nombre de la categoria del auto"), Scanner.getInt("Ingrese el porcentaje de costo adicional"));
    }

    private static SolicitudViaje pedirViaje(Cliente unCliente){
        return unCliente.pedirViaje();
    }

}
