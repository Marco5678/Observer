package climaobserver;

import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscrever(EstacaoMeteorologica estacao) {
        estacao.addObserver(this);
    }

    @Override
    public void update(Observable estacao, Object arg1) {
        this.ultimaNotificacao = this.nome + ", alerta emitido pela " + estacao.toString();
    }
}
