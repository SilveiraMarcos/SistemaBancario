package br.edu.banco.conta;

import java.util.Date;
import br.edu.banco.sistema.movimento;

/**
 *
 * @author Marcos Silveira
 */
public class contaEspecial extends contaComum {

    private double limite;

    public contaEspecial() {
    }

    public contaEspecial(long numero, String senha, double limite) {
        super(numero, senha);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public long abrirConta(long numero, String senha, double limite) {
        this.setNumero(numero);
        this.setSenha(senha);
        this.setLimite(limite);
        this.setDataAbertura(new Date());
        return numero;
    }

    @Override
    public boolean sacar(double quantia) {
        
        this.saldo += this.limite;
        
        if (quantia <= (this.saldo)) {
            this.saldo -= quantia;
            movimento movimento = new movimento();
            movimento.registrarMov(0, quantia);
            this.movimentos.add(movimento);
            return true;
        } else {
            return false;
        }
    }

}
