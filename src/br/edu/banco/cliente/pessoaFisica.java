package br.edu.banco.cliente;

import java.util.ArrayList;
import br.edu.banco.sistema.banco;

/**
 *
 * @author Marcos Silveira
 */
public class pessoaFisica extends pessoa {

    private long cpf;
    private long rg;

    ArrayList<pessoa> pessoas;

    private banco banco = new banco();

    public pessoaFisica() {
    }

    public pessoaFisica(String nome, String endereco, long cep, 
            String telefone, double renda, long cpf, long rg) {
        super(nome, endereco, cep, telefone, renda);
        this.cpf = cpf;
        this.rg = rg;

    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }
    
    public banco getBanco() {
        return banco;
    }
   //////////////////////////////////////////////////////////////////////////// 
    
    //Faz consulta por cpf
    public String consultarPorCPF(long cpf) {
        if (this.getCpf() == cpf) {
            return toString();
        } else {
            return null;
        }
    }
    // Registra pessoa fisica ao banco
    public boolean registrarPes() {
        pessoa aux = new pessoaFisica(nome, endereco, cep, telefone, renda, cpf, rg);
        if (this.situacao == true) {
            pessoas.add(aux);
            getBanco().setPessoas(pessoas);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        String cpf = "\nCPF: " + this.getCpf();
        String rg = "\nRG: " + this.getRg();
        
        String aux = super.toString() + cpf + rg;
        
        return aux;
        
    }

}
