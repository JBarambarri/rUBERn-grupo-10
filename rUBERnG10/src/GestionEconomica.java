
public class GestionEconomica {

    Chofer chofer;
    Cliente cliente;
    Viaje viaje;
    double saldoUber = 0;
    int bajadaBandera = 15;

    public GestionEconomica(Chofer unChofer, Viaje unViaje, Cliente unCliente){
        chofer = unChofer;
        viaje = unViaje;
        cliente = unCliente;
        hacerTransferencias();
    }

    public void hacerTransferencias(){
        double costoViaje = bajadaBandera + viaje.getJornada().distancia/100;
        transferenciaCliente(costoViaje);
        transferenciaChofer(costoViaje);
        transferenciaUber(costoViaje);
    }

    private void transferenciaChofer(double costoViaje) {
        chofer.saldo += viaje.getJornada().getDistancia()*costoViaje*0.9;
    }

    private void transferenciaUber(double costoViaje) {
        saldoUber += viaje.getJornada().getDistancia()*costoViaje*0.1;
    }

    private void transferenciaCliente(double costoViaje){
        cliente.getTarjeta().setSaldo(costoViaje);
    }
}
