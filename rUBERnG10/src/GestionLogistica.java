import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GestionLogistica {

    Viaje viaje;
    Jornada jornada;
    int cantidadDePasajeros;

    public int distanciaMinima = 10; //?

    private ArrayList<Chofer> choferesTemporal = BaseDeDatos.choferes;

    public GestionLogistica(Viaje viaje){
        jornada = viaje.getJornada();
        cantidadDePasajeros = viaje.getCantidadDePasajeros();
        this.viaje = viaje;
        enviarViajeAChofer();
    }


    public void setDistanciaMinima(int nuevaDistanciaMinima){
        distanciaMinima = nuevaDistanciaMinima;
    }


    private void enviarViajeAChofer(){
        for(int j=0; j<choferesTemporal.size(); j++){
            if (!choferCumpleCondiciones(j)){
                choferesTemporal.remove(j);
            }

        }
        if(choferesTemporal.size()==0) {
            System.out.println("\n\033[031mNo hay choferes disponibles\033[030m");
        }
        for(int i=0; i<choferesTemporal.size(); i++){
            if (choferCumpleCondiciones(i)) {
                System.out.print(viaje.datosDelViaje());
                System.out.println("Chofer:  " + choferesTemporal.get(i).getNombre());
                String s = choferesTemporal.get(i).recibirPropuesta();
                if (Interpreter.interpreter(s)) {
                    choferAcepta(i);
                    break;
                }else{
                    choferNoAcepta(i);
                }
            }else{
                choferesTemporal.remove(i);
            }
        }
    }

    private void choferNoAcepta(int i) {
        choferesTemporal.remove(i);
        enviarViajeAChofer();
    }


    private void choferAcepta(int i) {
        choferesTemporal.get(i).coordenada = jornada.coordenadaFinal;
        new GestionEconomica(choferesTemporal.get(i), viaje);

        BaseDeDatos.viajes.add(new Viaje(jornada, cantidadDePasajeros));
    }


    private boolean choferCumpleCondiciones(int i){
        return choferesTemporal.get(i).estado && cantidadDePasajeros <= choferesTemporal.get(i).auto.capacidadMaxima &&
        Calculadora.dist2Coord(choferesTemporal.get(i).getCoordenada(), jornada.coordenadaInicial) < distanciaMinima;
    }






}