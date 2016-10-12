
public class Jornada {

    Coordenada coordenadaInicial;
    Coordenada coordenadaFinal;
    double distancia;

    public Jornada(Coordenada unaCoordenadaInicial, Coordenada unaCoordenadaFinal){
        coordenadaFinal = unaCoordenadaFinal;
        coordenadaInicial = unaCoordenadaInicial;
        distancia = Math.sqrt((Math.pow(coordenadaInicial.getCoordenadaX()-coordenadaFinal.getCoordenadaX(), 2)) +
        (Math.pow(coordenadaInicial.getCoordenadaY()-coordenadaFinal.getCoordenadaY(), 2)));
    }

    public Coordenada getCoordenadaInicial() {
        return coordenadaInicial;
    }

    public Coordenada getCoordenadaFinal() {
        return coordenadaFinal;
    }

    public double getDistancia() {
        return distancia;
    }
}
