
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


    void mostrarClientes(){
        for(int i=0; i<BaseDeDatos.clientes.size(); i++){
            System.out.println("Cliente " + (i+1) + ": "+ BaseDeDatos.clientes.get(i).getNombre() + "\n");
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
        mostrarClientes();
        int i = Scanner.getInt("Ingrese la opcion correspondiente.\t");
        try{
            BaseDeDatos.clientes.get(i-1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ingrese sus datos:");
            generarCliente();
            i = BaseDeDatos.clientes.size();
        }
        return BaseDeDatos.clientes.get(i-1);


    }


    Chofer generarChofer(){
        return new Chofer(
                Scanner.getString("Nombre del chofer:\t"),
                Scanner.getLong("Ubicacion X del chofer:\t"),
                Scanner.getLong("Ubicacion Y del chofer:\t"),
                elegirAuto(),
                Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está:\t")));
    }

    Auto generarAuto() {
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

    Cliente generarCliente(){
        return new Cliente(Scanner.getLong("Ubicacion X del cliente: \t"),
                Scanner.getLong("Ubicacion Y del cliente: \t"),
                Scanner.getString("Nombre del cliente: \t") ,
                new Tarjeta(Scanner.getString("\n\033[4mDatos de la tarjeta:\033[0m\nNombre del banco: \t"),
                Scanner.getInt("Numero de la tarjeta: \t"), 1000)); //*
    }

}

//*nota respecto al saldo de la tarjeta: no corresponde que el cliente diga cuanto saldo tiene, por lo que se le asigno
//un saldo inicial de 1000$