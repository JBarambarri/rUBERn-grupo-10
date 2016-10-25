import java.util.Objects;

public class Interpreter {

    public static boolean interpreter(String s){
        try {
            boolean c;
            c = Objects.equals(s, "si") || Objects.equals(s, "no");
            if (!c) {
                throw new RuntimeException();
            }
        }
        catch (RuntimeException r){
            System.out.println();
            s = Scanner.getString("Ingrese si o no por favor:\t");
            interpreter(s);
        }

        boolean b=false;

        if(Objects.equals(s, "si")) {
            b = true;
        }
        if(Objects.equals(s, "no")) {
            b = false;
        }

        return b;
    }
}
