
public class OpcionesChofer extends Formulario{

    Scanner scanner;


    public OpcionesChofer(Scanner unScanner){
        scanner = unScanner;


        boolean b = true;
        while(b) {
            show();
            int i = unScanner.getInt("\nIngrese la opcion correspondiente:\t");
            try{
                switch (i){
                    case 1: case 2: case 3: break;//sth
                    default:
                        throw new OpcionIngresadaNoValida();
                }
            }
            catch (OpcionIngresadaNoValida o){
                System.out.println("Ingrese una opcion valida por favor");
                new OpcionesChofer(scanner);
            }

            switch (i) {
                case 1:
                    generarChofer();
                    break;
                case 2:
                    if(BaseDeDatos.viajesRealizados.size()==0) {
                        System.out.print("\nNo hay viajes para terminar");
                        new HacerTiempo(4);
                    }else{
                        terminarViaje(elegirChofer(scanner));
                    }
                    break;
                case 3:
                    b = false;
                    break;
            }
        }
    }


    @Override
    void mostrarTitulo() {
        System.out.println("\n**********\033[1mCHOFER\033[0m**********");
    }

    @Override
    void mostrarContenido() {
        System.out.format("+-----------------+---------------+%n");
        System.out.format("|    Opciones     |  N de Opcion  |%n");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Añadir Chofer   |       1       |");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Terminar Viaje  |       2       |");
        System.out.format("+-----------------+---------------+%n");
        System.out.println("| Salir           |       3       |");
        System.out.format("+-----------------+---------------+%n");
    }

    private Chofer generarChofer(){
        try{
            BaseDeDatos.autos.get(0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("\nRubern no tiene autos disponibles por el momento. Espere a que se cree uno...");
            new HacerTiempo(4);
            new OpcionesRubern(scanner);

        }
        return new Chofer(
                scanner.getString("\nNombre del chofer:\t"),
                scanner.getLong("\nUbicacion X del chofer:\t"),
                scanner.getLong("Ubicacion Y del chofer:\t"),
                elegirAuto(scanner),
                Interpreter.interpreter(scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está:\t"), scanner));
    }


    private void terminarViaje(Chofer unChofer){
        try{
            if(unChofer.isEstado()) {
                throw new ChoferNoEstaHaciendoViajeExc();
            }
        }
        catch (ChoferNoEstaHaciendoViajeExc e){}

        unChofer.setEstado(true);
    }

}
