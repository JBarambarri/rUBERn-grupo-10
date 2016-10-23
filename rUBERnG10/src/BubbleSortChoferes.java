import java.util.ArrayList;

public class BubbleSortChoferes {

    Jornada jornada;
    ArrayList<Chofer> choferesFiltrado;

    public BubbleSortChoferes(Jornada unaJornada, ArrayList<Chofer> choferes){
        jornada = unaJornada;
        choferesFiltrado = bubbleSortChoferes(choferes);
    }

    private ArrayList<Chofer> bubbleSortChoferes(ArrayList<Chofer> choferes) {
        for(int i = choferes.size(); i>=0; i--){
            for(int j=0; j<i-1; j++){
                if(condicion(choferes.get(j), choferes.get(j+1))){
                    cambiarlosDePosicion(j, j+1, choferes);
                }
            }
        }
        return choferes;
    }

    private boolean condicion(Chofer chofer1, Chofer chofer2){
        double costoAdicional1 = (chofer1.getAuto().getCategoria().getPorcentajeDeCostoAdicional()/100)*
                (Calculadora.dist2Coord(jornada.getCoordenadaInicial(), chofer1.getCoordenada()))/250;
        double costoAdicional2 = (chofer2.getAuto().getCategoria().getPorcentajeDeCostoAdicional()/100)*
                (Calculadora.dist2Coord(jornada.getCoordenadaInicial(), chofer2.getCoordenada()))/250;

        return costoAdicional1 < costoAdicional2;
    }

    private void cambiarlosDePosicion(int i, int j, ArrayList<Chofer> choferes){
        Chofer temporal = choferes.get(i);
        choferes.set(i, choferes.get(j));
        choferes.set(j, temporal);
    }

    public ArrayList<Chofer> getChoferesFiltrado() {
        return choferesFiltrado;
    }
}
