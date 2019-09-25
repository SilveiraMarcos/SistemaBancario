package br.edu.banco.sistema;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import br.edu.banco.conta.contaComum;

/**
 *
 * @author Marcos Silveira
 */
public class movimento {

    GregorianCalendar gcalendar = new GregorianCalendar();
    ArrayList<contaComum> contas;
    ArrayList<movimento> movimentos;
    SimpleDateFormat formatoBr = new SimpleDateFormat("HH:MM:SS");
    
    private int tipo;
    private Date data;
    private Time hora;
    private double valor;

    public movimento() {
    }

    public movimento(int tipo, Date data, Time hora, double valor) {
        this.tipo = tipo;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo == 0 ? "Saque" : "Deposito";
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @SuppressWarnings("deprecation")
    public String getHora() {
        return hora.getHours() + ":" + hora.getMinutes() + ":" + hora.getSeconds();
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean registrarMov(int tipo, double valor) {
        this.setTipo(tipo);
        this.setValor(valor);
        this.setData(data = new Date());
        this.setHora(new Time(System.currentTimeMillis()));
        return true;
    }

    public String consultarMov(String dataInicial, String dataFinal) throws ParseException {
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        Date dataI = formatoBr.parse(dataInicial);
        Date dataF = formatoBr.parse(dataFinal);

        String retorno = "";
        if (hoje.after(dataI) && hoje.before(dataF)) {
            retorno += this.toString();
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "\nMovimento - TIPO: "
                + this.getTipo() + "\n DATA: "
                + this.getData() + "\n HORA: "
                + this.getHora() + "\n VALOR: "
                + this.getValor();
    }

}
