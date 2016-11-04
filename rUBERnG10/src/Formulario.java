
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



    Chofer elegirChofer(Scanner unScanner){
        BaseDeDatos.mostrarChoferes();
        int i = unScanner.getInt("Ingrese la opcion correspondiente:\t");
        while(true){
            try{
                BaseDeDatos.clientes.get(i-1);
                return BaseDeDatos.choferes.get(i-1);
            }
            catch (IndexOutOfBoundsException e){
                i = unScanner.getInt("Ingrese una opcion valida:\t");
            }
        }
    }

     Auto elegirAuto(Scanner unScanner){
        BaseDeDatos.mostrarAutos();
        int i = unScanner.getInt("Ingrese la opcion correspondiente:\t");
        while(true){
             try{
                 BaseDeDatos.clientes.get(i-1);
                 return BaseDeDatos.autos.get(i-1);
             }
             catch (IndexOutOfBoundsException e){
                 i = unScanner.getInt("Ingrese una opcion valida:\t");
             }
        }
    }

    Categoria elegirCategoria(Scanner unScanner){
        BaseDeDatos.mostrarCategorias();
        int i = unScanner.getInt("Ingrese la opcion correspondiente:\t");

        while(true){
            try{
                BaseDeDatos.clientes.get(i-1);
                return BaseDeDatos.categorias.get(i-1);
            }
            catch (IndexOutOfBoundsException e){
                i = unScanner.getInt("Ingrese una opcion valida:\t");
            }
        }
    }

    Cliente elegirCliente(Scanner unScanner){
        BaseDeDatos.mostrarClientes();
        int i = unScanner.getInt("Ingrese la opcion correspondiente.\t");

        while(true){
            try{
                BaseDeDatos.clientes.get(i-1);
                return BaseDeDatos.clientes.get(i-1);
            }
            catch (IndexOutOfBoundsException e){
                i = unScanner.getInt("Ingrese una opcion valida:\t");
            }
        }
    }


    Cliente generarCliente(Scanner unScanner){
        return new Cliente(unScanner.getString("\n"+"Nombre del cliente: \t") ,
                unScanner.getLong("\n"+"Ubicacion X del cliente: \t"),
                unScanner.getLong("Ubicacion Y del cliente: \t"),
                new Tarjeta(unScanner.getString("\n\033[4mDatos de la tarjeta:\033[0m\nNombre del banco: \t"),
                unScanner.getInt("Numero de la tarjeta: \t"), 1000)); //*
    }

}

//*nota respecto al saldo de la tarjeta: no corresponde que el cliente diga cuanto saldo tiene, por lo que se le asigno
//un saldo inicial de 1000$