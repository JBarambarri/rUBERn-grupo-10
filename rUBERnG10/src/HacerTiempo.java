
public class HacerTiempo {

    public HacerTiempo(int tiempoEnSegundos) {
        try {
            Thread.sleep(tiempoEnSegundos*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
