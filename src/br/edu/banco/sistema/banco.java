package br.edu.banco.sistema;

import java.text.ParseException;
import java.util.ArrayList;

import br.edu.banco.cliente.pessoa;
import br.edu.banco.cliente.pessoaFisica;
import br.edu.banco.cliente.pessoaJuridica;

/**
 *
 * @author Marcos Silveira
 */
public class banco {

    private final int CONTA_POUPANCA = 1;
    private final int CONTA_COMUM = 0;

    private ArrayList<pessoa> pessoas = new ArrayList<>();

    public int getIdContaPoupanca() {
        return CONTA_POUPANCA;
    }

    public int getIdContaComum() {
        return CONTA_COMUM;
    }

    public banco() {
    }

    public banco(ArrayList<pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public ArrayList<pessoa> getPessoas() {
        return pessoas;
    }

    public void adiconarPessoasBd(pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void setPessoas(ArrayList<pessoa> pessoas) {
        this.pessoas = pessoas;
    }
///////////////////////////////////////////////////////////////////////////////////
  
    public void retornaCPF(long cpf) throws ParseException {
        int contador = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof pessoaFisica) {
                pessoaFisica aux = (pessoaFisica) pessoas.get(i);
                if (aux.consultarPorCPF(cpf) != null) {
                    System.out.print(aux.consultarPorCPF(cpf));
                    System.out.println(aux.getContas().get(0).extratoConta("01/06/2019", "01/07/2019"));
                } else {
                    contador++;
                }
            }

        }

        System.out.println();
       
        if (contador == 8) {
            System.out.println("Pessoa nao encontrada ! ");

        }
    }

    public void retornaCNPJ(long cnpj) throws ParseException {
        int cont = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof pessoaJuridica) {
                pessoaJuridica aux = (pessoaJuridica) pessoas.get(i);
                if (aux.consultarPorCNPJ(cnpj) != null) {
                    System.out.print(aux.consultarPorCNPJ(cnpj));
                    System.out.println(aux.getContas().get(0).extratoConta("01/06/2019", "01/07/2019"));

                } else {
                    cont++;
                }
            }
        }

        System.out.println();
        if (cont == 2) {
            System.out.println("Pessoa nao encontrada !");

        }

    }
    
     public void imprimir() {
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).toString());
            System.out.println(pessoas.get(i).getContas().get(0).toString());
            System.out.println(pessoas.get(i).getContas().get(1).toString());
            System.out.println(
                    "=======================================================================");
        }
    }

}
