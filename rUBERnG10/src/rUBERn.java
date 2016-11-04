public class rUBERn {


    public static void main(String args[]) {

        Tarjeta tarjetaDefault = new Tarjeta("default", 101010, 1000);
        Categoria categoriaDefault = new Categoria("default", 10);
        Auto autoDefault = new Auto("default" , 10, categoriaDefault);
        Chofer choferDefault = new Chofer("default", 0, 0, autoDefault, true);
        Cliente clienteDefault = new Cliente("default", 1, 1, tarjetaDefault);
        
        new MenuPrincipal(new RealScanner());

    }









}
