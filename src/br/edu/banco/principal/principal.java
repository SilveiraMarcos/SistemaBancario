package br.edu.banco.principal;

import br.edu.banco.conta.contaComum;
import br.edu.banco.conta.contaPoupanca;
import br.edu.banco.cliente.pessoa;
import br.edu.banco.cliente.pessoaFisica;
import br.edu.banco.cliente.pessoaJuridica;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import br.edu.banco.sistema.banco;

/**
 *
 * @author Marcos Silveira
 */
public class principal {

    private static Scanner s;

    public static void main(String[] args) throws ParseException {
        banco BD = new banco();

        // Cliente 1
        pessoa cliente = new pessoaFisica("Thiago Torres", "Av QuinzaDeAbril, Novo Horizonte",
                68500000, "94910000", 1000, 000001, 6341001);

        contaComum conta = new contaComum();
        contaPoupanca conta2 = new contaPoupanca();
        conta.abrirConta(120, "si123d");
        conta2.abrirConta(240, "dasdsa");
        cliente.setContas(conta);
        cliente.setContas(conta2);
        BD.adiconarPessoasBd(cliente);

        // Cliente 2
        pessoa cliente2 = new pessoaFisica("Thiago Monteiro", "Rua 01",
                68500000, "94910000", 2000, 000002, 6341002);
        
        contaComum conta3 = new contaComum();
        contaPoupanca conta4 = new contaPoupanca();
        conta3.abrirConta(422, "dewdaw");
        conta4.abrirConta(123, "adm221");
        cliente2.setContas(conta3);
        cliente2.setContas(conta4);
        BD.adiconarPessoasBd(cliente2);
        
        // Cliente 3
        pessoa cliente3 = new pessoaFisica("Marcos Antonio", "Rua 02",
                68500000, "94910000", 1000, 000003, 6341003);
        
        contaComum conta5 = new contaComum();
        contaPoupanca conta6 = new contaPoupanca();
        conta5.abrirConta(455, "4324dc");
        conta6.abrirConta(678, "akiue1");
        cliente3.setContas(conta5);
        cliente3.setContas(conta6);
        BD.adiconarPessoasBd(cliente3);

        // Cliente 4
        pessoa cliente4 = new pessoaFisica("Bruna Laura", "Rua 03",
                68500000, "94910000", 1000, 000004, 6341004);
        
        contaComum conta7 = new contaComum();
        contaPoupanca conta8 = new contaPoupanca();
        conta7.abrirConta(333, "efssda");
        conta8.abrirConta(666, "d34244");
        cliente4.setContas(conta7);
        cliente4.setContas(conta8);
        BD.adiconarPessoasBd(cliente4);
        // Cliente 5
        pessoa cliente5 = new pessoaFisica("Jonas Rocha", "Rua 04",
                68500000, "94910000", 1000, 000005, 6341005);
        
        contaComum conta9 = new contaComum();
        contaPoupanca conta10 = new contaPoupanca();
        conta9.abrirConta(555, "qidb12");
        conta10.abrirConta(456, "73bhsa");
        cliente5.setContas(conta9);
        cliente5.setContas(conta10);
        BD.adiconarPessoasBd(cliente5);

        // Cliente 6
        pessoa cliente6 = new pessoaFisica("Joao Lucas", "Rua 05",
                68500000, "94910000", 1000, 000006, 6341006);
        
        contaComum conta11 = new contaComum();
        contaPoupanca conta12 = new contaPoupanca();
        conta11.abrirConta(198, "qfeaf2");
        conta12.abrirConta(156, "twg2rf");
        cliente6.setContas(conta11);
        cliente6.setContas(conta12);
        BD.adiconarPessoasBd(cliente6);
        // Cliente 7
        pessoa cliente7 = new pessoaFisica("Kayo Dias", "Rua 06",
                68500000, "94910000", 5000, 000007, 6341007);
        
        contaComum conta13 = new contaComum();
        contaPoupanca conta14 = new contaPoupanca();
        conta13.abrirConta(987, "sldasn");
        conta14.abrirConta(156, "fggr15");
        cliente7.setContas(conta13);
        cliente7.setContas(conta14);
        BD.adiconarPessoasBd(cliente7);

        // Cliente 8
        pessoa cliente8 = new pessoaFisica("Leandro Seixas", "Rua 07",
                68500000, "94910000", 8000, 0002, 6341008);

        contaPoupanca conta15 = new contaPoupanca();
        contaComum conta16 = new contaComum();
        conta15.abrirConta(212, "31sdsd");
        conta16.abrirConta(136, "dsadsf");
        cliente8.setContas(conta16);
        cliente8.setContas(conta15);
        BD.adiconarPessoasBd(cliente8);

        // Cliente 9
        pessoa cliente9 = new pessoaJuridica("Yago Moussalem", "Rua 08", 
                68500000, "94910000", 10000, true, 312321);
        
        contaPoupanca conta17 = new contaPoupanca();
        contaComum conta18 = new contaComum();
        conta17.abrirConta(340, "shhfe5");
        conta18.abrirConta(126, "f1015f");
        cliente9.setContas(conta18);
        cliente9.setContas(conta17);
        BD.adiconarPessoasBd(cliente9);
        
        // Cliente 10
        pessoa cliente10 = new pessoaJuridica("Luis Felipe", "Rua 09", 
                68500000, "94910000", 134550, true, 04432);
        
        contaComum conta19 = new contaComum();
        contaPoupanca conta20 = new contaPoupanca();
        conta19.abrirConta(320, "vdfvas");
        conta20.abrirConta(171, "kvhd01");
        cliente10.setContas(conta19);
        cliente10.setContas(conta20);
        BD.adiconarPessoasBd(cliente10);

        // A seguir faremos saque e deposito automatico na conta dos clientes
        Random sacar = new Random();
        Random depositar = new Random();
        for (pessoa pessoa : BD.getPessoas()) {
            long numeroDaConta = pessoa.getContas().get(BD.getIdContaComum()).getNumero();
            pessoa.getContas().get(BD.getIdContaComum()).depositar(numeroDaConta,
                    depositar.nextDouble() * 3000);
            pessoa.getContas().get(BD.getIdContaComum()).sacar(sacar.nextDouble() * 1500);

            long numeroDaContaP = pessoa.getContas().get(BD.getIdContaPoupanca()).getNumero();
            pessoa.getContas().get(BD.getIdContaPoupanca()).depositar(numeroDaContaP,
                    depositar.nextDouble() * 3000);
            pessoa.getContas().get(BD.getIdContaPoupanca()).sacar(sacar.nextDouble() * 1500);
            for (contaComum contaPessoa : pessoa.getContas()) {
                if (contaPessoa instanceof contaPoupanca) {
                    ((contaPoupanca) contaPessoa).fazNiver("23/05/2019", 10);
                }
            }
        }
        
        // Menu principal
        s = new Scanner(System.in);
        int op;
        do {

            System.out.println("BANCO DO BRASIL S.A");

            System.out.println("1- Visualizar Clientes Cadastrados");
            System.out.println("2- Pesquisar (Pessoa Fisica)");
            System.out.println("3- Pesquisar (Pessoa Juridica)");
            System.out.println("4- Sair");

            System.out.print("Digite um numero correspondente a opcao desejada:");
            op = Integer.parseInt(s.nextLine());

            switch (op) {
                case 1:
                    BD.imprimir();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Digite o CPF: ");
                    long cpf = Long.parseLong(s.nextLine());
                    BD.retornaCPF(cpf);
                    break;
                case 3:
                    System.out.print("Digite o CNPJ: ");
                    long cnpj = Long.parseLong(s.nextLine());
                    BD.retornaCNPJ(cnpj);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
