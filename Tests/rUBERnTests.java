import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class rUBERnTests {


    @Test
    public void test001() {  //distanciaTest
        Coordenada coordenadaInicial = new Coordenada(10, 40);
        Coordenada coordenadaFinal = new Coordenada(20, 60);
        Jornada jornada = new Jornada(coordenadaInicial, coordenadaFinal);
        double distancia = jornada.distancia;

        assertEquals(22.36, distancia, 0.1);
    }




}
