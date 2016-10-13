
public class Jornada {

    Coordenada coordenadaInicial;
    Coordenada coordenadaFinal;
    double distancia;

    public Jornada(Coordenada unaCoordenadaInicial, Coordenada unaCoordenadaFinal){
        coordenadaFinal = unaCoordenadaFinal;
        coordenadaInicial = unaCoordenadaInicial;
        distancia = Calculadora.dist2Coord(unaCoordenadaInicial, unaCoordenadaFinal);
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
