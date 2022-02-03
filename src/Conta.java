import java.util.LinkedList;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    public static LinkedList<Conta> listaDeContas = new LinkedList<Conta>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        listaDeContas.add(this);
    }

    public int getAgencia() {
        return agencia;
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %S", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public static void imprimirTodasContas(){
        System.out.println("//// Lista de contas ////");
        for (int i = 0; i < listaDeContas.size(); i++){
            System.out.printf("Conta nº: %d, agência: %d.%n",
                    listaDeContas.get(i).numero, listaDeContas.get(i).agencia);
        }
    }

    public static void imprimirClientes() {
        System.out.println("##### Clientes #####");
        for (Conta listaDeConta : listaDeContas) {
            System.out.printf("Nome: %s.%n",
                    listaDeConta.cliente.getNome());
        }
    }


    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
