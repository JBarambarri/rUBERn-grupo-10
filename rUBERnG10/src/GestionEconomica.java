
public class GestionEconomica {

    Chofer chofer;
    Viaje viaje;
    double saldoUber = 0;

    public GestionEconomica(Chofer unChofer, Viaje unViaje){
        chofer = unChofer;
        viaje = unViaje;
        hacerTransferencias();
    }

    public void hacerTransferencias(){
        double costoViaje = 15 + viaje.getJornada().distancia/100;
        transferenciaChofer(costoViaje);
        transferenciaUber(costoViaje);
    }

    private void transferenciaChofer(double costoViaje) {
        chofer.saldo += viaje.getJornada().getDistancia()*costoViaje*0.9;
    }

    private void transferenciaUber(double costoViaje) {
        saldoUber += viaje.getJornada().getDistancia()*costoViaje*0.1;
    }
}
