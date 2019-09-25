package br.edu.banco.conta;

import br.edu.banco.cliente.pessoa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import br.edu.banco.sistema.movimento;

/**
 *
 * @author Marcos Silveira
 */
public class contaComum {

    protected ArrayList<pessoa> pessoas;
    protected SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");

    protected Date dataAbertura;
    protected Date dataEncerramento;
    protected String senha;

    protected boolean situacao = true;
    protected long numero;
    protected double saldo = 0;

    protected ArrayList<movimento> movimentos = new ArrayList<>();

    public contaComum() {
    }

    public contaComum(long numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(ArrayList<movimento> movimentos) {
        this.movimentos = movimentos;
    }

//////////////////////////////////////////////////////////////////////////////////////
    
    public long abrirConta(long numero, String senha) {
        this.setNumero(numero);
        this.setSenha(senha);
        Date data = new Date();
        String dataAbertura = formatoBr.format(data);
        try {
            data = formatoBr.parse(dataAbertura);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setDataAbertura(data);
        return numero;
    }

    public boolean sacar(double quantia) {

        if (quantia <= this.saldo) {
            this.saldo -= quantia;
            movimento mov = new movimento();
            mov.registrarMov(0, quantia);
            this.movimentos.add(mov);
            return true;
        } else {
            return false;
        }

    }

    public boolean depositar(long numero, double quantia) {

        if (numero == this.numero) {
            this.saldo += quantia;
            movimento mov = new movimento();
            mov.registrarMov(1, quantia);
            this.movimentos.add(mov);
            return true;
        } else {
            return false;
        }
    }

    public boolean encerrarConta() {
        this.situacao = false;
        if (situacao == false) {
            this.setDataEncerramento(new Date());
            return true;
        } else {
            return false;
        }
    }

    public String extratoConta(String dataInicial, String dataFinal) throws ParseException {
        String retorno = "";
        if (this.situacao == true) {
            for (int i = 0; i < this.movimentos.size(); i++) {
                retorno += this.movimentos.get(i).consultarMov(dataInicial, dataFinal);
            }

        }
        return retorno;

    }

    @Override
    public String toString() {
        String Num ="\nNUMERO: " + this.getNumero();
        String DatAber = "\nDATA DE ABERTURA: " + this.getDataAbertura();
        String DatFech = "\nDATA DE ENCERRAMENTO: " + this.dataEncerramento ;
        String Sit = "\nSITUACAO: " + this.situacao;
        String Sald = "\nSALDO: " + this.saldo ;
        String mov = "\n-----------------------------------------------\n MOVIMENTOS: \t" + this.getMovimentos();
        
        String aux = Num + DatAber + DatFech+Sit+Sald+mov;
         
        return aux;
    }

}
