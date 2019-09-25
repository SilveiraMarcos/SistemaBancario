package br.edu.banco.cliente;

import java.util.ArrayList;

import br.edu.banco.sistema.banco;

/**
 *
 * @author Marcos Silveira
 */
public class pessoaJuridica extends pessoa {

    protected ArrayList<pessoa> pessoas;
    private long cnpj;
    banco banco;

    public pessoaJuridica() {

    }

    public pessoaJuridica(String nome, String endereco, long cep, String telefone, 
        double renda, boolean situacao, long cnpj) {
        
        super(nome, endereco, cep, telefone, renda);
        
        this.cnpj = cnpj;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
    //////////////////////////////////////////////////////////////////////////////
    
    //Faz pesquisa da empresa via Cnpj
    public String consultarPorCNPJ(long cnpj) {
        if (this.getCnpj() == cnpj) {
            return toString();
        } else {
            return null;
        }
    }

    //Registra a pessoa juridica ao banco
    public boolean registrarPes() {
        if (this.situacao == true) {
            pessoas.add(this);
            banco.setPessoas(pessoas);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        String Cnpj = "\nCNPJ: " + this.getCnpj();
        String aux = super.toString() + Cnpj;
        return aux;
    }
}
