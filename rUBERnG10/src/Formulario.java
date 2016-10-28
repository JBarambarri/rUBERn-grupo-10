
public abstract class Formulario {

    public void show() {

        blanquearPantalla();
        mostrarTitulo();
        System.out.println();
        mostrarContenido();
    }

    abstract void mostrarTitulo();

    abstract void mostrarContenido();


    private void blanquearPantalla() {
        for(int i=0; i<25; i++){
            System.out.println();
        }
    }



    Chofer elegirChofer(){
        BaseDeDatos.mostrarChoferes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.choferes.get(i-1);
    }

     Auto elegirAuto(){
        BaseDeDatos.mostrarAutos();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.autos.get(i-1);
    }

    Categoria elegirCategoria(){
        BaseDeDatos.mostrarCategorias();
        int i = Scanner.getInt("Ingrese la opcion correspondiente:\t");
        return BaseDeDatos.categorias.get(i-1);
    }

    Cliente elegirCliente(){
        BaseDeDatos.mostrarClientes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente.\t");

        while(true){
            try{
                BaseDeDatos.clientes.get(i-1);
                return BaseDeDatos.clientes.get(i-1);
            }
            catch (IndexOutOfBoundsException e){
                i = Scanner.getInt("Ingrese una opcion valida:\t");
            }
        }
    }


    Cliente generarCliente(){
        return new Cliente(Scanner.getString("\n"+"Nombre del cliente: \t") ,
                Scanner.getLong("\n"+"Ubicacion X del cliente: \t"),
                Scanner.getLong("Ubicacion Y del cliente: \t"),
                new Tarjeta(Scanner.getString("\n\033[4mDatos de la tarjeta:\033[0m\nNombre del banco: \t"),
                Scanner.getInt("Numero de la tarjeta: \t"), 1000)); //*
    }

}

//*nota respecto al saldo de la tarjeta: no corresponde que el cliente diga cuanto saldo tiene, por lo que se le asigno
//un saldo inicial de 1000$