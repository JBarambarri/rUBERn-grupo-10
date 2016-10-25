
public class OpcionesChofer extends Formulario{

    public OpcionesChofer(){
        boolean b = true;
        while(b) {
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
            try{
                switch (i){
                    case 1: case 2: case 3: break;//sth
                    default:
                        throw new OpcionIngresadaNoValida();
                }
            }
            catch (OpcionIngresadaNoValida o){
                System.out.println("Ingrese una opcion valida por favor");
                new OpcionesChofer();
            }

            switch (i) {
                case 1:
                    generarChofer();
                    break;
                case 2:
                    if(BaseDeDatos.viajesRealizados.size()==0) {
                        System.out.print("No hay viajes para terminar");
                    }else{
                        terminarViaje(elegirChofer());
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
        System.out.println("1. Añadir Chofer");
        System.out.println("2. Terminar viaje");
        System.out.println("3. Salir");
    }

    private Chofer generarChofer(){
        try{
            BaseDeDatos.autos.get(0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Rubern no tiene autos disponibles por el momento. Espere a que se cree uno");
            new OpcionesRubern();
        }
        return new Chofer(
                Scanner.getString("Nombre del chofer:\t"),
                Scanner.getLong("Ubicacion X del chofer:\t"),
                Scanner.getLong("Ubicacion Y del chofer:\t"),
                elegirAuto(),
                Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está:\t")));
    }


    private void terminarViaje(Chofer unChofer){
        try{
            if(unChofer.isEstado()) {
                throw new ChoferNoEstaHaciendoViajeExc();
            }
        }
        catch (ChoferNoEstaHaciendoViajeExc e){
    }
        unChofer.setEstado(true);
    }

}
