public class TextoIngresadoNoValido extends RuntimeException {

    public TextoIngresadoNoValido(){
        super("Ingrese 'si' o 'no' por favor");
    }
}