
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;


public class rUBERnTests {

    Tarjeta tarjetaDefault = new Tarjeta("default", 101010, 1000);
    Categoria categoriaDefault = new Categoria("default", 10);
    Auto autoDefault = new Auto("default" , 10, categoriaDefault);
    Chofer choferDefault = new Chofer("default", 0, 0, autoDefault, true);
    Cliente clienteDefault = new Cliente("default", 1, 1, tarjetaDefault);

    @Test
    public void test001() {  //distanciaTest
        Coordenada coordenadaInicial = new Coordenada(10, 40);
        Coordenada coordenadaFinal = new Coordenada(20, 60);
        Jornada jornada = new Jornada(coordenadaInicial, coordenadaFinal);
        double distancia = jornada.distancia;

        assertEquals(22.36, distancia, 0.1);
    }


    @Test
    public void test002() {         // ver randomStrings
        RandomString s = new RandomString(5);
        System.out.print(s.nextString());
    }


    @Test
    public void test003() {
        int[] ints = {1, 2, 1, 1, 3, 4};     //cliente default pide un viaje. Chofer esta activo durante el viaje? no
        long[] longs = {100, 100};
        String[] strings = {"si"};

        Scanner fakeScanner = new FakeScanner(strings,ints,longs);

        new MenuPrincipal(fakeScanner);

        Assert.assertFalse(BaseDeDatos.choferes.get(0).isEstado());

    }


    @Test
    public void test004() {
        int[] ints = {1, 2, 1, 1, 3, 2, 2, 1, 3, 4};     //cliente default pide un viaje. Chofer lo empieza y luego
        long[] longs = {100, 100};                       //lo termina. Esta activo? SI.
        String[] strings = {"si"};

        Scanner fakeScanner = new FakeScanner(strings,ints,longs);
        new MenuPrincipal(fakeScanner);

        Assert.assertTrue(BaseDeDatos.choferes.get(0).isEstado());
    }

    @Test
    public void test005() {                             //saldo se deposita correctamente en la cuenta del chofer
        int[] ints = {1, 2, 1, 3, 3, 4};
        long[] longs = {100, 100};
        String[] strings = {"si"};

        Scanner fakeScanner = new FakeScanner(strings,ints,longs);
        new MenuPrincipal(fakeScanner);

        double gananciaChofer = (BaseDeDatos.viajesRealizados.get(0).getViaje().getJornada().getDistancia()/100+15)*0.9;

        assertEquals(BaseDeDatos.choferes.get(0).getSaldo(), gananciaChofer, 1);


    }


}
