package lojavirtual;

// https://www.youtube.com/watch?v=WPdrnuSHAQs

// Interface que define o comportamento
interface Comportamento {
    void executar();
}

// Implementa��o do Comportamento A
class ComportamentoA implements Comportamento {
    @Override
    public void executar() {
        System.out.println("Executando Comportamento A");
    }
}

// Implementa��o do Comportamento B
class ComportamentoB implements Comportamento {
    @Override
    public void executar() {
        System.out.println("Executando Comportamento B");
    }
}

// Classe que utiliza o padr�o Strategy
class Contexto {
    private Comportamento comportamento;

    // Construtor que permite definir o comportamento em tempo de execu��o
    public Contexto(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    // M�todo que executa o comportamento atual
    public void executarComportamento() {
        comportamento.executar();
    }

    // M�todo que permite alterar o comportamento em tempo de execu��o
    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
