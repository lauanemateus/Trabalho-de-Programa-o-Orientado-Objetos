package lojavirtual;

import java.util.Scanner;

// https://www.youtube.com/watch?v=WPdrnuSHAQs

// Interface que define o comportamento
interface Comportamento {
    void executar();
}

// Implementação do Comportamento PagamentoCartao
class PagamentoCartao implements Comportamento {
	Scanner input = new Scanner(System.in);
	String numeroCartao;
	String nomeTitular;
	String dataVencimento;
	String codigoSegurançaTresDigitos;
	
    @Override
    public void executar() {
    	
    	// variaveis para verificar se o numero do cartao é valido
    	int quantidadeDigitos; // variável que quarta a quantidade de digitos que o usuário escreveu
    	boolean somenteNumeros; // variável que guarda true caso o numero do cartao tem só numeros,
    	// falso caso contrário
    	
    	// leitura do numero
    	System.out.println("Digite o número do cartão de crédito (16 dígitos):\n");
		numeroCartao = input.next();
		quantidadeDigitos = numeroCartao.length();  
		somenteNumeros = true;
		// verificamos se cada caracter do numero do cartao é numero
		for(int i=0; i<quantidadeDigitos; i++) {
			if(numeroCartao.charAt(i)>='0' && numeroCartao.charAt(i)<='9') {
				somenteNumeros = false;
			}
		}
    	
		while(quantidadeDigitos!=16 || somenteNumeros==false) {	
			System.out.println("Número inválido!");
			System.out.println("Digite o número do cartão de crédito (16 dígitos):\n");
			numeroCartao = input.next();
			quantidadeDigitos = numeroCartao.length();
			somenteNumeros = true;
			
			// verificamos se cada caracter do numero do cartao é numero
			for(int i=0; i<quantidadeDigitos; i++) {
				if(numeroCartao.charAt(i)>='0' && numeroCartao.charAt(i)<='9') {
					somenteNumeros = false;
				}
			}
		}
		
    	boolean somenteLetras; // variável que guarda true caso o nome só possui letras,
    	// falso caso contrário
    	
    	// leitura do nome
    	System.out.println("Digite o nome do titular:\n");
		nomeTitular = input.next(); 
		somenteLetras = true;
		// verificamos se cada caracter do nome é letra
		for(int i=0; i<quantidadeDigitos; i++) {
			if((numeroCartao.charAt(i)>='a' && numeroCartao.charAt(i)<='z') || (numeroCartao.charAt(i)>='A' && numeroCartao.charAt(i)<='Z')) {
				somenteLetras = false;
			}
		}
    	
		while(somenteLetras==false) {	
			System.out.println("Nome inválido! Digite o nome do titular exatamente como escrito no cartão");
			System.out.println("Digite o nome do titular:\n");
			nomeTitular = input.next(); 
			somenteNumeros = true;
			
			// verificamos se cada caracter do numero do cartao é numero
			for(int i=0; i<quantidadeDigitos; i++) {
				if((numeroCartao.charAt(i)>='a' && numeroCartao.charAt(i)<='z') || (numeroCartao.charAt(i)>='A' && numeroCartao.charAt(i)<='Z')) {
					somenteLetras = false;
				}
			}
		}
		
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
