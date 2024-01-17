package lojavirtual;

// https://www.youtube.com/watch?v=WPdrnuSHAQs

// Interface que define o comportamento
interface Comportamento {
    void executar();
}

// Implementação do Comportamento A
class ComportamentoA implements Comportamento {
    @Override
    public void executar() {
        System.out.println("Executando Comportamento A");
    }
}

// Implementação do Comportamento B
class ComportamentoB implements Comportamento {
    @Override
    public void executar() {
        System.out.println("Executando Comportamento B");
    }
}

// Classe que utiliza o padrão Strategy
class Contexto {
    private Comportamento comportamento;

    // Construtor que permite definir o comportamento em tempo de execução
    public Contexto(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    // Método que executa o comportamento atual
    public void executarComportamento() {
        comportamento.executar();
    }

    // Método que permite alterar o comportamento em tempo de execução
    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
