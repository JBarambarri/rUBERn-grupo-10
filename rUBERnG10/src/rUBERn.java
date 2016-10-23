import java.util.Collections;

public class rUBERn {

    public static void main(String args[]) {

        boolean b = true;

        while (b) {

            System.out.println("1. Cliente ");
            System.out.println("2. Chofer ");
            System.out.println("3. Rubern ");
            System.out.println("4. Salir");


            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");

            try{
                switch (i){
                    case 1: case 2: case 3: case 4: break;//sth
                    default:
                        throw new OpcionIngresadaNoValida();
                }
            }
            catch (OpcionIngresadaNoValida o){
                i = Scanner.getInt("Ingrese una opcion valida por favor: \t");
            }

            switch (i) {
                case 1:
                    new OpcionesCliente();
                    break;
                case 2:
                    new OpcionesChofer();
                    break;
                case 3:
                    new OpcionesRubern();
                    break;
                case 4:
                    b = false;
                    break;

                default:
                    throw new OpcionIngresadaNoValida();

            }
        }
    }


    private static Chofer generarChofer(){
        return new Chofer(Scanner.getString("Ingrese el nombre del chofer:\t"),
        Scanner.getLong("Ubicacion X del chofer:\t"),
        Scanner.getLong("Ubicacion Y del chofer:\t"),
        generarAuto(),
        Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está:\t")));
    }

    private static Auto generarAuto() {
        System.out.println("\n\033[4mDatos del auto:\033[0m");
        return new Auto(Scanner.getString("Ingrese la marca del auto:\t"),
        Scanner.getInt("Ingrese la capcidad maxima del auto:\t"),
        generarCategoria());
    }

    private static Categoria generarCategoria(){
        return new Categoria(Scanner.getString("Ingrese el nombre de la categoria del auto:\t"),
        Scanner.getInt("Ingrese el porcentaje de costo adicional:\t"));
    }

}
