package br.edu.banco.cliente;

import br.edu.banco.conta.contaComum;
import java.util.ArrayList;

/**
 *
 * @author Marcos Silveira
 */
public abstract class pessoa {

    protected String nome;
    protected String endereco;
    protected String telefone;
    protected long cep;
    protected double renda;
    protected boolean situacao = true;

    protected ArrayList<contaComum> contas = new ArrayList<contaComum>();

    public pessoa() {
    }

    public pessoa(String nome, String endereco, long cep, String telefone, double renda) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public ArrayList<contaComum> getContas() {
        return contas;
    }

    public void setContas(contaComum conta) {
        this.contas.add(conta);
    }
///////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {

        String Nom = "------------------------DADOS PESSOAIS--------------------\nNome: " + this.getNome();
        String End = "\nEndereco: " + this.getEndereco();
        String Cep = "\nCEP: " + this.getCep();
        String Tel = "\nTelefone: " + this.getTelefone();
        String Rend = "\nRenda: " + this.getRenda();
        String Sit = "\nSituacao: " + this.isSituacao();
        
        
        String aux = Nom + End + Cep + Tel + Rend + Sit;

        return aux;

    }

}
