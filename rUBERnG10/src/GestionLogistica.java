import java.util.ArrayList;
import java.util.Objects;

public class GestionLogistica {

    SolicitudViaje solicitudViaje;
    Jornada jornada;
    int cantidadDePasajeros;

    int distanciaMinima = 10;

    ArrayList<Chofer> choferesTemporal = Chofer.choferes;

    public GestionLogistica(SolicitudViaje solicitudViaje){
        jornada = solicitudViaje.getJornada();
        cantidadDePasajeros = solicitudViaje.getCantidadDePasajeros();
        this.solicitudViaje = solicitudViaje;
        enviarViajeAChofer();
    }


    public void setDistanciaMinima(int nuevaDistanciaMinima){
        distanciaMinima = nuevaDistanciaMinima;
    }


    public String datosDelViaje(){
        return "Ubiacion pasajero" + "\t" + jornada.coordenadaInicial + "\n" +
        "Destino" + "\t" + jornada.coordenadaFinal + "\n" +
        "Cantidad de pasajeros:" + "\t" + cantidadDePasajeros;
    }


    private void enviarViajeAChofer(){
        if(choferesTemporal.size()==0) {
            System.out.println("No hay choferes disponibles");
        }
        for(int i=0; i<choferesTemporal.size(); i++){
            if (choferesTemporal.get(i).estado && cantidadDePasajeros <= choferesTemporal.get(i).auto.capacidadMaxima &&
                    Calculadora.dist2Coord(choferesTemporal.get(i).getCoordenada(), jornada.coordenadaInicial) < distanciaMinima) {

                String s = choferesTemporal.get(i).recibirPropuesta(solicitudViaje);
                if (interpreter(s)) {
                    choferAcepta(i);
                    break;
                }else{
                    choferNoAcepta(i);
                }
            }
        }
    }

    private boolean interpreter(String s){
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


    private void choferNoAcepta(int i) {
        choferesTemporal.remove(i);
        enviarViajeAChofer();
    }

    private void choferAcepta(int i) {
        choferesTemporal.get(i).coordenada = jornada.coordenadaFinal;

        new GestionEconomica();
    }


}
