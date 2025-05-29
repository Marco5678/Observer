package ClimaObserver;

import java.util.Observable;

public class EstacaoMeteorologica extends Observable {

    private String nome;
    private String localizacao;

    public EstacaoMeteorologica(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public void emitirAlerta() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "ClimaObserver.EstacaoMeteorologica{" +
                "nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
