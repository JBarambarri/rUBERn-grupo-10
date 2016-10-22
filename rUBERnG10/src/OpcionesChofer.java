
public class OpcionesChofer extends Formulario{

    public OpcionesChofer(){
        boolean b = true;
        while(b) {
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
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
                default:
                    throw new OpcionIngresadaNoValida();
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

    private static Chofer generarChofer(){
        return new Chofer(
                Scanner.getString("Nombre del chofer:\t"),
                Scanner.getLong("Ubicacion X del chofer:\t"),
                Scanner.getLong("Ubicacion Y del chofer:\t"),
                elegirAuto(),
                Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está:\t")));
    }

    private static Auto generarAuto() {
        System.out.println("\n\033[4mDatos del auto:\033[0m");
        return new Auto(
                Scanner.getString("Marca del auto:\t"),
                Scanner.getInt("Capcidad maxima del auto:\t"),
                elegirCategoria());
    }

    private static Categoria generarCategoria(){
        return new Categoria(
                Scanner.getString("Nombre de la categoria del auto:\t"),
                Scanner.getInt("Porcentaje de costo adicional:\t"));
    }

    private static void terminarViaje(Chofer unChofer){
        unChofer.setEstado(true);
    }

    private static Chofer elegirChofer(){
        BaseDeDatos.mostrarChoferes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.choferes.get(i-1);
    }

    private static Auto elegirAuto(){
        BaseDeDatos.mostrarAutos();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.autos.get(i-1);
    }

    private static Categoria elegirCategoria(){
        BaseDeDatos.mostrarCategorias();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.categorias.get(i-1);
    }

}
