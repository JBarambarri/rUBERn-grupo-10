
public class MenuPrincipal {

    Scanner scanner;

    public MenuPrincipal(Scanner unScanner){
        scanner = unScanner;

        System.out.println("\n**********\033[1m\033[4mBienvenido a rUBERn\033[0m**********\n");

        boolean b = true;

        while (b) {


            System.out.format("+-----------------+---------------+%n");
            System.out.format("|     Opciones    |  N de opcion  |%n");
            System.out.format("+-----------------+---------------+%n");
            System.out.println("| Cliente         |       1       |");
            System.out.format("+-----------------+---------------+%n");
            System.out.println("| Chofer          |       2       |");
            System.out.format("+-----------------+---------------+%n");
            System.out.println("| Rubern          |       3       |");
            System.out.format("+-----------------+---------------+%n");
            System.out.println("| Salir           |       4       |");
            System.out.format("+-----------------+---------------+%n");



            int i = unScanner.getInt("\nIngrese la opcion correspondiente:\t");


            try {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                    //default:
                    //throw new OpcionIngresadaNoValida();
                }
            }
            catch (OpcionIngresadaNoValida o) {
                i = unScanner.getInt("Ingrese una opcion valida por favor: \t");
            }


            switch (i) {
                case 1:
                    new OpcionesCliente(scanner);
                    break;
                case 2:
                    new OpcionesChofer(scanner);
                    break;
                case 3:
                    new OpcionesRubern(scanner);
                    break;
                case 4:
                    System.out.println("\n**********\033[1mGracias por usar rUBERn\033[0m**********");
                    b = false;
                    break;

            }
        }
    }

}
