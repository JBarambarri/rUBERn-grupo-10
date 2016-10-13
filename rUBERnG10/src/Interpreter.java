import java.util.Objects;

public class Interpreter {

    public static boolean interpreter(String s){
        if(Objects.equals(s, "si")){
            return true;
        }else{
            if(Objects.equals(s, "no")) {
                return false;
            }else{
                throw new TextoIngresadoNoValido();
            }
        }
    }
}
