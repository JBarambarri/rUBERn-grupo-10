
public class OpcionesChofer extends Formulario{

    public OpcionesChofer(){
        boolean b = true;
        while(b) {
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
            try{
                switch (i){
                    case 1: case 2: case 3: case 4: case 5: break;//sth
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
                    if(BaseDeDatos.autos.size()==0){
                        System.out.println("No hay autos disponibles. A continuacion cree uno:");
                        if(BaseDeDatos.categorias.size()==0) {
                            System.out.println("Tampoco hay categorias disponibles. A continuacion cree una:");
                            generarCategoria();
                        }
                        generarAuto();
                    }
                    generarChofer();
                    break;
                case 2:
                    if(BaseDeDatos.categorias.size()==0){
                        System.out.println("No hay categorias disponibles. A continuacion cree una:");
                        generarCategoria();
                    }
                    generarAuto();
                    break;
                case 3:
                    generarCategoria();
                    break;
                case 4:
                    if(BaseDeDatos.viajesRealizados.size()==0) {
                        System.out.print("No hay viajes para terminar");
                    }else{
                        terminarViaje(elegirChofer());
                    }
                    break;
                case 5:
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
        System.out.println("2. Añadir Auto ");
        System.out.println("3. Añadir Categoria");
        System.out.println("4. Terminar viaje");
        System.out.println("5. Salir");
    }


    private static void terminarViaje(Chofer unChofer){
        unChofer.setEstado(true);
    }


}
