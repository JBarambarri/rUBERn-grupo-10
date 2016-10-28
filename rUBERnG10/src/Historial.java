import static java.lang.StrictMath.round;

public class Historial {


    
    public Historial(Cliente unCliente){
        historialPorCliente(unCliente);
    }

    private static void historialPorCliente(Cliente unCliente){
        for(int i=0; i<BaseDeDatos.viajesRealizados.size(); i++){
            if(BaseDeDatos.viajesRealizados.get(i).getViaje().getCliente().equals(unCliente)){
                historialCliente(i, unCliente);
            }
        }
    }


    private static void historialCliente(int i, Cliente unCliente) {
        new HacerTiempo(10);
        Viaje viaje = BaseDeDatos.viajesRealizados.get(i).getViaje();
        System.out.println(
            "\nCodigo unico del viaje: " + viaje.getCodigoViaje() + "\n" + "Pago" + "\n" +
            viaje.getDateAndTime().getYear() + "/" + viaje.getDateAndTime().getMonthOfYear()
            + "/" + viaje.getDateAndTime().getDayOfMonth() + "\n" +
            viaje.getDateAndTime().getHourOfDay() + ":" + viaje.getDateAndTime().getMinuteOfHour() + "\n" +
            "Numero de tarjeta: " + unCliente.getTarjeta().getNumeroCuenta() + "\n" +
            "Pago de viaje desde (" + viaje.getJornada().getCoordenadaInicial().getCoordenadaX() + "," +
            viaje.getJornada().getCoordenadaInicial().getCoordenadaY() + ") hasta (" +
            viaje.getJornada().getCoordenadaFinal().getCoordenadaX() + "," +
            + viaje.getJornada().getCoordenadaFinal().getCoordenadaY() + ")\n" +
            round(viaje.getJornada().getDistancia()/100) + "$" + "\n");

    }

    public Historial(Chofer unChofer){
        historialPorChofer(unChofer);
    }

    private static void historialPorChofer(Chofer unChofer){
        for(int i=0; i<BaseDeDatos.viajesRealizados.size(); i++){
            if(BaseDeDatos.viajesRealizados.get(i).getChofer().equals(unChofer)){
                historialChofer(i, unChofer);
            }
        }
    }


    private static void historialChofer(int i, Chofer unChofer) {
        new HacerTiempo(10);
        Viaje viaje = BaseDeDatos.viajesRealizados.get(i).getViaje();
        System.out.println(
                "Codigo unico del viaje: " + viaje.getCodigoViaje() + "\n" + "Cobro" + "\n" +
                viaje.getDateAndTime().getYear() + "/" + viaje.getDateAndTime().getMonthOfYear()
                + "/" + viaje.getDateAndTime().getDayOfMonth() + "\n" +
                viaje.getDateAndTime().getHourOfDay() + ":" + viaje.getDateAndTime().getMinuteOfHour() + "\n" +
                "Numero de tarjeta: disponible solo para cliente\n"  +
                "Cobro de viaje desde (" + viaje.getJornada().getCoordenadaInicial().getCoordenadaX() + "," +
                viaje.getJornada().getCoordenadaInicial().getCoordenadaY() + ") hasta (" +
                viaje.getJornada().getCoordenadaFinal().getCoordenadaX() + "," +
                + viaje.getJornada().getCoordenadaFinal().getCoordenadaY() + ")\n" +
                round((viaje.getJornada().getDistancia()/100)*0.9) + "$" + "\n");

    }
}
