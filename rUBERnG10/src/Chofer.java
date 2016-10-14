import java.util.ArrayList;

public class Chofer implements Persona{

    String nombre;
    Auto auto;
    Coordenada coordenada;
    boolean estado;

    public static ArrayList<Chofer> choferes = new ArrayList<>();

    public static ArrayList<Chofer> getList(){
        return choferes;
    }

    ArrayList<Historial> historialCliente = new ArrayList<>();


    public Chofer(Auto unAuto){
        System.out.print("\n***************Chofer***************\n");
        nombre = Scanner.getString("Ingrese nombre chofer:\t");
        auto = unAuto;
        long ubicacionX = Scanner.getLong("Ubicacion X del chofer: \t");
        long ubicacionY = Scanner.getLong("Ubicacion Y del chofer: \t");
        coordenada = new Coordenada(ubicacionX, ubicacionY);
        estado = Interpreter.interpreter(Scanner.getString("Ingrese 'si' si está activo, o 'no' si no lo está: \t"));
        choferes.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void agregarAHistorial(double cantidad){
        Historial historial = new Historial(cantidad);
        historialCliente.add(historial);
    }



    public Auto getAuto() {
        return auto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }



    public String recibirPropuesta(){
        return Scanner.getString("Ingrese 'si' si acepta el viaje" + "\n" + "Ingrese 'no' si no acepta el viaje:\t");
    }
}
