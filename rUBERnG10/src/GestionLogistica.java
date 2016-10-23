import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GestionLogistica {

    Viaje viaje;
    Jornada jornada;
    int cantidadDePasajeros;
    Cliente cliente;
    String codigoViaje;

    public int distanciaMinima = 100; //?


    private ArrayList<Chofer> choferesTemporal = BaseDeDatos.choferes;


    public GestionLogistica(Viaje unViaje, Cliente unCliente){
        jornada = unViaje.getJornada();
        cantidadDePasajeros = unViaje.getCantidadDePasajeros();
        viaje = unViaje;
        cliente = unCliente;
        codigoViaje = viaje.getCodigoViaje();

        //BubbleSortChoferes bsc = new BubbleSortChoferes(jornada, BaseDeDatos.choferes);
        //choferesTemporal = bsc.getChoferesFiltrado();
        enviarViajeAChofer();

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
                for(int j=0; j<25; j++){
                    System.out.println();
                }
                System.out.println("\n**********\033[1mCHOFER\033[0m**********");
                System.out.print(viaje.datosDelViaje());
                System.out.println("Chofer:  " + choferesTemporal.get(i).getNombre());
                String s = choferesTemporal.get(i).recibirPropuesta();
                if (Interpreter.interpreter(s)) {
                    choferAcepta(i);
                    break;
                }else{
                    choferNoAcepta(i);
                }
                break;
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

        new GestionEconomica(choferesTemporal.get(i), viaje, cliente);

        BaseDeDatos.viajesRealizados.add(new ViajesRealizados(choferesTemporal.get(i), viaje ));
    }


    private boolean choferCumpleCondiciones(int i){
        return choferesTemporal.get(i).estado && cantidadDePasajeros <= choferesTemporal.get(i).auto.capacidadMaxima &&
        Calculadora.dist2Coord(choferesTemporal.get(i).getCoordenada(), jornada.coordenadaInicial) < distanciaMinima;
    }

}