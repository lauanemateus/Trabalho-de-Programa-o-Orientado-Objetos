package lojavirtual;

public class MainStrategy {
    public static void main(String[] args) {
        // Criando instâncias dos comportamentos
        Comportamento comportamentoA = new ComportamentoA();
        Comportamento comportamentoB = new ComportamentoB();

        // Criando uma instância do contexto com o comportamento A
        Contexto contexto = new Contexto(comportamentoA);

        // Executando o comportamento A
        contexto.executarComportamento();

        // Alterando o comportamento para B em tempo de execução
        contexto.setComportamento(comportamentoB);

        // Executando o novo comportamento B
        contexto.executarComportamento();
    }
}
