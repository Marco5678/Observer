package climaobserver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void deveNotificarUmaPessoa() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Estação Centro", "Cidade A");
        Pessoa pessoa = new Pessoa("João");
        pessoa.inscrever(estacao);
        estacao.emitirAlerta();
        assertEquals("João, alerta emitido pela ClimaObserver.EstacaoMeteorologica{nome='Estação Centro', localizacao='Cidade A'}", pessoa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariasPessoas() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Estação Centro", "Cidade A");
        Pessoa pessoa1 = new Pessoa("João");
        Pessoa pessoa2 = new Pessoa("Maria");
        pessoa1.inscrever(estacao);
        pessoa2.inscrever(estacao);
        estacao.emitirAlerta();
        assertEquals("João, alerta emitido pela ClimaObserver.EstacaoMeteorologica{nome='Estação Centro', localizacao='Cidade A'}", pessoa1.getUltimaNotificacao());
        assertEquals("Maria, alerta emitido pela ClimaObserver.EstacaoMeteorologica{nome='Estação Centro', localizacao='Cidade A'}", pessoa2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarPessoaNaoInscrita() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Estação Centro", "Cidade A");
        Pessoa pessoa = new Pessoa("João");
        estacao.emitirAlerta();
        assertNull(pessoa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasEstacaoCorreta() {
        EstacaoMeteorologica estacaoCentro = new EstacaoMeteorologica("Estação Centro", "Cidade A");
        EstacaoMeteorologica estacaoZonaSul = new EstacaoMeteorologica("Estação Zona Sul", "Cidade B");
        Pessoa pessoa1 = new Pessoa("João");
        Pessoa pessoa2 = new Pessoa("Maria");
        pessoa1.inscrever(estacaoCentro);
        pessoa2.inscrever(estacaoZonaSul);
        estacaoCentro.emitirAlerta();
        assertEquals("João, alerta emitido pela ClimaObserver.EstacaoMeteorologica{nome='Estação Centro', localizacao='Cidade A'}", pessoa1.getUltimaNotificacao());
        assertNull(pessoa2.getUltimaNotificacao());
    }
}
