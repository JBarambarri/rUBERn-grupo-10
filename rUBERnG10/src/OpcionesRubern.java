
public class OpcionesRubern extends Formulario{

    public OpcionesRubern(){
        boolean b=true;
        while(b){
            show();
            int i = Scanner.getInt("\nIngrese la opcion correspondiente:\t");
            switch (i){
                case 1:
                    new Historial(elegirCliente());
                    break;
                case 2:
                    new Historial(elegirChofer());
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


    private Cliente elegirCliente() {
        BaseDeDatos.mostrarClientes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.clientes.get(i-1);
    }

    private Chofer elegirChofer() {
        BaseDeDatos.mostrarChoferes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.choferes.get(i-1);
    }


}
