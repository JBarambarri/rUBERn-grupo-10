import org.junit.Assert;
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


    @Test //chequear que funcione el size la static list
    public void test002(){

        Chofer chofer = new Chofer(null, null, null, true);
        int size = Chofer.choferes.size();
        assertEquals(1, size);
    }

    @Test
    public void test003() {
        Coordenada coordenadaInicialGonza = new Coordenada(1, 1);
        Coordenada coordenadaFinalGonza = new Coordenada(10, 10);
        Coordenada coordenadaInicialCarlos = new Coordenada(2, 2);

        Cliente yo = new Cliente("Gonza", coordenadaInicialGonza);

        Categoria categoriaElite = new Categoria("Elite", 10);

        Auto superAuto = new Auto("BMW", 3, categoriaElite);

        new Chofer("Carlos", superAuto, coordenadaInicialCarlos, true);

        yo.pedirViaje(coordenadaFinalGonza, 2);


    }




}
