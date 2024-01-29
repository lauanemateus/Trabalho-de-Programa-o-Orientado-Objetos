package lojavirtual;

import java.util.Random;
import java.util.Scanner;

// https://www.youtube.com/watch?v=WPdrnuSHAQs

// Interface que define o comportamento
interface Comportamento {
    void executar(Scanner input);
}

// Implementação do Comportamento PagamentoCartao
class PagamentoCartao implements Comportamento {
	String numeroCartao;
	String nomeTitular;
	String dataVencimento;
	String codigoSegurançaTresDigitos;
	
    @Override
    public void executar(Scanner input) {
    	
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
			if(Character.isDigit(numeroCartao.charAt(i))==false) {
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
				if(Character.isDigit(numeroCartao.charAt(i))==false) {
					somenteNumeros = false;
				}
			}
		}
		
    	boolean somenteLetras; // variável que guarda true caso o nome só possui letras,
    	// falso caso contrário
    	
    	// leitura do nome
    	System.out.println("Digite o nome do titular:\n");
    	
    	//lê a quebra de linha    	
		nomeTitular = input.nextLine(); 
		// lê uma linha inteira		
		nomeTitular = input.nextLine();
		
		somenteLetras = true;
		// verificamos se cada caracter do nome é letra
		for(int i=0; i<nomeTitular.length(); i++) {
			if(nomeTitular.charAt(i)==' ') continue;
			if(Character.isLetter(nomeTitular.charAt(i))==false) {
				somenteLetras = false;
			}
		}
    	
		while(somenteLetras==false) {	
			System.out.println("Nome inválido! Digite o nome do titular exatamente como escrito no cartão");
			System.out.println("Digite o nome do titular:\n");
			
			// lê uma linha inteira		
			nomeTitular = input.nextLine();
			
			somenteLetras = true;
			
			// verificamos se cada caracter do numero do cartao é letra
			for(int i=0; i<nomeTitular.length(); i++) {
				if(nomeTitular.charAt(i)==' ') continue;
				if(Character.isLetter(nomeTitular.charAt(i))==false) {
					somenteLetras = false;
				}
			}
		}
		
		
    	boolean dataCorreta = true; // variável que verifica se a string lida é coerente com um data no formato "dd/mm/aaaa"
    	
    	// leitura do data
    	System.out.println("Digite a data de vencimento no formato \"dd/mm/aaaa\" :\n");
		dataVencimento = input.next();
		quantidadeDigitos = dataVencimento.length();  
	
		if(quantidadeDigitos!=10) {
			dataCorreta = false;
		}
    	for(int i=0; i<quantidadeDigitos; i++) {
    		if(i==2 || i==5) {
    			if(dataVencimento.charAt(i)!='/') {
    				dataCorreta = false;
    			}
    		}
    		else if(Character.isDigit( dataVencimento.charAt(i) ) == false) {
    			dataCorreta = false;
    		}
    	}
		
		while(quantidadeDigitos!=10 || dataCorreta==false) {	
			System.out.println("Data inválida!");
			System.out.println("Digite a data de vencimento no formato \"dd/mm/aaaa\" :\n");
			
			dataVencimento = input.next();
			quantidadeDigitos = dataVencimento.length();  
			dataCorreta = true;
			
			if(quantidadeDigitos!=10) {
				dataCorreta = false;
			}
	    	for(int i=0; i<quantidadeDigitos; i++) {
	    		if(i==2 || i==5) {
	    			if(dataVencimento.charAt(i)!='/') {
	    				dataCorreta = false;
	    			}
	    		}
	    		else if(Character.isDigit( dataVencimento.charAt(i) ) == false) {
	    			dataCorreta = false;
	    		}
	    	}
		}
		
		// leitura do código de segurança
    	System.out.println("Digite o código de segurança:\n");
    	codigoSegurançaTresDigitos = input.next();
    	boolean codigoSegurançaCorreto = true;
		if(codigoSegurançaTresDigitos.length() != 3 || Character.isDigit(codigoSegurançaTresDigitos.charAt(0))==false 
				|| Character.isDigit(codigoSegurançaTresDigitos.charAt(1))==false || Character.isDigit(codigoSegurançaTresDigitos.charAt(2))==false) {
			codigoSegurançaCorreto = false;
		}
				
		while(codigoSegurançaCorreto == false) {
			System.out.println("Código de segurança incorreto!");
			System.out.println("Digite o código de segurança:\n");
	    	codigoSegurançaTresDigitos = input.next();
	    	codigoSegurançaCorreto = true;
			if(codigoSegurançaTresDigitos.length() != 3 || Character.isDigit(codigoSegurançaTresDigitos.charAt(0))==false 
					|| Character.isDigit(codigoSegurançaTresDigitos.charAt(1))==false || Character.isDigit(codigoSegurançaTresDigitos.charAt(2))==false) {
				codigoSegurançaCorreto = false;
			}
		}
		
		System.out.println("Pagamento efetuado!");
		System.out.println("Dados do Titular:\n" + "Nome: " + nomeTitular + "\nNumero do cartão: " + numeroCartao + "\nData de vencimento: " + dataVencimento);
    }
}

// Implementação do Comportamento B
class PagamentoPix implements Comportamento {
    @Override
    public void executar(Scanner input) {
    	Random codigoPix = new Random();
        System.out.println("Código pix para efetuar pagamento: " + codigoPix.nextInt(1000000000) + codigoPix.nextInt(1000000000) + codigoPix.nextInt(1000000000));
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
    public void executarComportamento(Scanner input) {
        comportamento.executar(input);
    }

    // Método que permite alterar o comportamento em tempo de execução
    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
