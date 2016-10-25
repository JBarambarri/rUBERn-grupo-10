
public class Tarjeta {

    String banco;
    int numeroCuenta;
    double saldo;

    public Tarjeta(String unBanco, int unNumeroDeCuenta, double unSaldo){
        banco = unBanco;
        numeroCuenta = unNumeroDeCuenta;
        saldo = unSaldo;
    }

    public String getBanco() {
        return banco;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo -= saldo;
    }
}
