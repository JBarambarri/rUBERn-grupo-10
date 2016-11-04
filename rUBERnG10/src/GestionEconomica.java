
public class GestionEconomica {

    Chofer chofer;
    Cliente cliente;
    Viaje viaje;
    double saldoUber = 0;
    int bajadaBandera = 15;
    double costoViaje;

    public GestionEconomica(Chofer unChofer, Viaje unViaje, Cliente unCliente){
        chofer = unChofer;
        viaje = unViaje;
        cliente = unCliente;
        costoViaje = bajadaBandera + viaje.getJornada().getDistancia()/100;
        hacerTransferencias();

    }

    public void hacerTransferencias(){
        transferenciaCliente(costoViaje);
        transferenciaChofer(costoViaje);
        transferenciaUber(costoViaje);
    }

    private void transferenciaChofer(double costoViaje) {
        chofer.agregarSaldo(costoViaje*0.9);
    }

    private void transferenciaUber(double costoViaje) {
        saldoUber += viaje.getJornada().getDistancia()*costoViaje*0.1;
    }

    private void transferenciaCliente(double costoViaje){
        cliente.getTarjeta().setSaldo(costoViaje);
    }

}
