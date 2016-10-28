
public class OpcionesRubern extends Formulario{

    public OpcionesRubern(){
        boolean b = true;
        while(b){
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
                new OpcionesRubern();
            }


            switch (i){
                case 1:
                    try{
                        BaseDeDatos.viajesRealizados.get(0);
                    }catch (IndexOutOfBoundsException e){
                        System.out.print("\nNo hay viajes realizados\n");
                        new HacerTiempo(3);
                        break;
                    }
                    new Historial(elegirCliente());
                    break;
                case 2:
                    try{
                        BaseDeDatos.viajesRealizados.get(0);
                    }catch (IndexOutOfBoundsException e){
                        System.out.print("\nNo hay viajes realizados\n");
                        new HacerTiempo(3);
                        break;
                    }
                    new Historial(elegirChofer());
                    break;
                case 3:
                    generarAuto();
                    break;
                case 4:
                    generarCategoria();
                    break;
                case 5:
                    b = false;
                    break;
            }
        }
    }

    @Override
    void mostrarTitulo() {
        System.out.println("\n**********\033[1mRUBERN\033[0m**********");
    }

    @Override
    void mostrarContenido() {
        System.out.format("+----------------------------------+---------------+%n");
        System.out.format("|             Opciones             |  N de Opcion  |%n");
        System.out.format("+----------------------------------+---------------+%n");
        System.out.println("| Mostrar historial por cliente    |       1       |");
        System.out.format("+----------------------------------+---------------+%n");
        System.out.println("| Mostrar historial por chofer     |       2       |");
        System.out.format("+----------------------------------+---------------+%n");
        System.out.println("| Generar auto                     |       3       |");
        System.out.format("+----------------------------------+---------------+%n");
        System.out.println("| Generar categoria                |       4       |");
        System.out.format("+----------------------------------+---------------+%n");
        System.out.println("| Salir                            |       5       |");
        System.out.format("+----------------------------------+---------------+%n");

    }



    private Auto generarAuto() {
        try{
            BaseDeDatos.categorias.get(0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("\nNo hay categorias disponibles. A continuacion cree una:\n");
            generarCategoria();
        }

        System.out.println("\n\033[4mDatos del auto:\033[0m");
        return new Auto(
                Scanner.getString("Marca del auto:\t"),
                Scanner.getInt("Capacidad maxima del auto:\t"),
                elegirCategoria());
    }

    private Categoria generarCategoria(){
        return new Categoria(
                Scanner.getString("\nNombre de la categoria del auto:\t"),
                Scanner.getInt("Porcentaje de costo adicional:\t"));
    }
}
