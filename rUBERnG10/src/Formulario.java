
public abstract class Formulario {

    public void show() {
        blanquearPantalla();
        mostrarTitulo();
        System.out.println();
        mostrarContenido();
    }

    abstract void mostrarTitulo();

    abstract void mostrarContenido();


    private void blanquearPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
