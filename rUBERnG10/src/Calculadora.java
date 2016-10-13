
public class Calculadora {

    public static double dist2Coord(Coordenada c1, Coordenada c2){
        return Math.sqrt((Math.pow(c1.getCoordenadaX()-c2.getCoordenadaX(), 2))+
        (Math.pow(c1.getCoordenadaY()-c2.getCoordenadaY(), 2)));
    }
}
