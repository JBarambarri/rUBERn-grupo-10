
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
        for(int i=0; i<25; i++){
            System.out.println();
        }
    }
}
