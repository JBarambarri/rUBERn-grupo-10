import java.util.ArrayList;
import java.util.Objects;


public class GestionLogistica {

    SolicitudViaje solicitudViaje;
    Jornada jornada;
    int cantidadDePasajeros;

    public int distanciaMinima = 10; //?

    private ArrayList<Chofer> choferesTemporal = Chofer.getList();

    public GestionLogistica(SolicitudViaje solicitudViaje){
        jornada = solicitudViaje.getJornada();
        cantidadDePasajeros = solicitudViaje.getCantidadDePasajeros();
        this.solicitudViaje = solicitudViaje;
        enviarViajeAChofer();
    }


    public void setDistanciaMinima(int nuevaDistanciaMinima){
        distanciaMinima = nuevaDistanciaMinima;
    }


    private void enviarViajeAChofer(){
        for(int j=0; j<choferesTemporal.size(); j++){
            if (!choferesTemporal.get(j).estado || cantidadDePasajeros > choferesTemporal.get(j).auto.capacidadMaxima ||
                    Calculadora.dist2Coord(choferesTemporal.get(j).getCoordenada(), jornada.coordenadaInicial) >= distanciaMinima){
                choferesTemporal.remove(j);
            }

        }
        if(choferesTemporal.size()==0) {
            System.out.println("No hay choferes disponibles");
        }
        for(int i=0; i<choferesTemporal.size(); i++){
            if (choferesTemporal.get(i).estado && cantidadDePasajeros <= choferesTemporal.get(i).auto.capacidadMaxima &&
                    Calculadora.dist2Coord(choferesTemporal.get(i).getCoordenada(), jornada.coordenadaInicial) < distanciaMinima) {
                System.out.print(solicitudViaje.datosDelViaje());
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
        new GestionEconomica();
    }

}
