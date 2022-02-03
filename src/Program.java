public class Program {
    public static void main(String[] args) {
        Cliente client1 = new Cliente();
        client1.setNome("Jean");

        Conta cc = new ContaCorrente(client1);
        cc.depositar(100);
        Conta pp = new ContaPoupanca(client1);

        Cliente client2 = new Cliente();
        client2.setNome("Caio");
        Conta pp2 = new ContaPoupanca(client2);

        cc.transferir(pp, 40);
        cc.imprimirExtrato();
        pp.imprimirExtrato();
        pp2.imprimirExtrato();

        Conta.imprimirTodasContas();
        Conta.imprimirClientes();
    }
}
