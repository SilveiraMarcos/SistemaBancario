package br.edu.banco.conta;

import br.edu.banco.cliente.pessoa;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marcos Silveira
 */
public class contaPoupanca extends contaComum {

    ArrayList<pessoa> pessoas;
    private Date dataAniversario;

    public contaPoupanca() {
    }

    public contaPoupanca(long numero, String senha, Date dataAniversario) {
        super(numero, senha);
        this.dataAniversario = dataAniversario;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }
///////////////////////////////////////////////
    public double fazNiver(String dataAtual, double juros) {
        String dataAniversario = formatoBr.format(this.dataAbertura);
        Date dataAt = null;
        try {
            dataAt = formatoBr.parse(dataAtual);
            this.dataAniversario = formatoBr.parse(dataAniversario);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//
        if (this.dataAniversario.equals(dataAt)) {
            return this.saldo += this.saldo * (juros / 100);
        } else {
            return 0;
        }

    }

}
