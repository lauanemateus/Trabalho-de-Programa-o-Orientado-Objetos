package lojavirtual;

import java.util.Scanner;

public class MainStrategy {
	static Categoria vestido = new Categoria("vestido");
	static Categoria blusa = new Categoria("blusa");
	static Categoria calça = new Categoria("calça");
	static Categoria saia = new Categoria("saia");
	static Categoria carrinho = new Categoria("carrinho de compras");
	static int codigoIdentificador=1;
	
	private static void inicializar() {
	       // Criando categorias
	   
	       // Adicionando os produtos na categoria vestidos     
	       vestido.adicionar(new Produto("vestido longo vermelho", 250.0, codigoIdentificador++, 20));
	       vestido.adicionar(new Produto("vestido longo azul", 250.0, codigoIdentificador++, 10));
	       vestido.adicionar(new Produto("vestido médio rosa", 125.50, codigoIdentificador++, 20));
	       vestido.adicionar(new Produto("vestido médio preto", 80.0, codigoIdentificador++, 10));
	       vestido.adicionar(new Produto("vestido médio branco", 100.0, codigoIdentificador++, 50));
	       
	       // Adicionando os produtos na categoria blusa     
	       blusa.adicionar(new Produto("blusa manga longa preta", 60.0, codigoIdentificador++, 40));
	       blusa.adicionar(new Produto("blusa manga longa branca", 60.0, codigoIdentificador++, 40));
	       blusa.adicionar(new Produto("blusa manga curta preta", 45.0, codigoIdentificador++, 80));
	       blusa.adicionar(new Produto("blusa manga curta branca", 45.0, codigoIdentificador++,85));
	       blusa.adicionar(new Produto("blusa polo preta", 90, codigoIdentificador++, 20));
	       blusa.adicionar(new Produto("blusa polo branca", 90, codigoIdentificador++, 20));
	       
	       // Adicionando os produtos na categoria calça     
	       calça.adicionar(new Produto("calça masculina jeans", 70.0, codigoIdentificador++, 20));
	       calça.adicionar(new Produto("calça masculina moletom", 65.0, codigoIdentificador++, 15));
	       calça.adicionar(new Produto("calça feminina jeans", 70.0, codigoIdentificador++, 40));
	       calça.adicionar(new Produto("calça feminia moletom", 65.0, codigoIdentificador++, 30));
	       
	       // Adicionando os produtos na categoria saia     
	       saia.adicionar(new Produto("saia longa branca", 250.0, codigoIdentificador++, 20));
	       saia.adicionar(new Produto("saia longa azul", 250.0, codigoIdentificador++, 10));
	       saia.adicionar(new Produto("saia longa preto", 125.50, codigoIdentificador++, 20));
	       saia.adicionar(new Produto("vestido médio preto", 80.0, codigoIdentificador++, 10));
	       saia.adicionar(new Produto("vestido médio branca", 100.0, codigoIdentificador++, 50));
	       
//	       Produto teste = vestido.getProduto(1);
//	       System.out.println("Nome do produto: " + teste.getNome());

	       // Criando o carrinho de compras e adicionando produtos/categorias
	       carrinho.adicionar(vestido);
	}
	
	private static boolean menu(Scanner input){
		int digitoDigitado;
		
		System.out.println("Digite: \n");
		System.out.println(" 1 - Para ver o carrinho de compras");
		System.out.println(" 2 - Para ver todos produtos disponíveis");
		System.out.println(" 3 - Para ver produtos de uma categoria específica");
		System.out.println(" 4 - Para fechar programa");
		
		digitoDigitado = input.nextInt();
		
		if(digitoDigitado == 1) {
			
		}
		else if(digitoDigitado == 2) {
			
		}
		else if(digitoDigitado == 3) {
			
		}
		else if(digitoDigitado == 4) {
			System.out.println("Programa encerrado!");
			return false; // programa terminou
		}
		else {
			System.out.println("Opção inválida!\n");
			return MainStrategy.menu(input);
		}
			
		return true;  // programa não terminou
	}
	
    public static void main(String[] args) {	
    	// é aberto só uma vez, na main
    	Scanner input = new Scanner(System.in);
    	

    	//    	Nós já vamos deixar os produtos pré-adicionados aqui, ou seja, não vai ter interface para administrador da loja virtual
    	//        Criando produtos
    	MainStrategy.inicializar();

    	// Fazendo menu
    	while(MainStrategy.menu(input) == true);
    	
    	
       // Calculando o preço total do carrinho de compras
//       double precoTotal = carrinho.calcularPreco();
//       System.out.println("Preço Total do Carrinho: " + precoTotal);
    	
    	// fechando a instância de Scanner
       input.close();
    }
}
