
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
                        System.out.print("No hay viajes realizados\n");
                        b = false;
                        break;
                    }
                    new Historial(elegirCliente());
                    break;
                case 2:
                    try{
                        BaseDeDatos.viajesRealizados.get(0);
                    }catch (IndexOutOfBoundsException e){
                        System.out.print("No hay viajes realizados\n");
                        b = false;
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
        System.out.println("1. Mostrar historial por cliente");
        System.out.println("2. Mostrar historial por chofer");
        System.out.println("3. Generar auto");
        System.out.println("4. Generar categoria");
        System.out.println("5. Salir");
    }



    Auto generarAuto() {
        try{
            BaseDeDatos.categorias.get(0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("No hay categorias disponibles. A continuacion cree una:");
            generarCategoria();
        }

        System.out.println("\n\033[4mDatos del auto:\033[0m");
        return new Auto(
                Scanner.getString("Marca del auto:\t"),
                Scanner.getInt("Capcidad maxima del auto:\t"),
                elegirCategoria());
    }

    Categoria generarCategoria(){
        return new Categoria(
                Scanner.getString("Nombre de la categoria del auto:\t"),
                Scanner.getInt("Porcentaje de costo adicional:\t"));
    }
}
