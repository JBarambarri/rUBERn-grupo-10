
public class OpcionesRubern extends Formulario{

    public OpcionesRubern(){
        boolean b = true;
        while(b){
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
            if(BaseDeDatos.viajesRealizados.size()==0){
                System.out.println("\nNo hay viajes realizados\n");
                i=3;
            }
            try{
                switch (i){
                    case 1: case 2: case 3: break;//sth
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
                    new Historial(elegirCliente());
                    break;
                case 2:
                    new Historial(elegirChofer());
                    break;
                case 3:
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
        System.out.println("3. Salir");
    }
}
