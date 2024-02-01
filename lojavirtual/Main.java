package lojavirtual;

import java.util.Scanner;

public class Main {
	static Categoria vestido = new Categoria("Vestido");
	static Categoria blusa = new Categoria("Blusa");
	static Categoria calça = new Categoria("Calça");
	static Categoria saia = new Categoria("Saia");
	static Categoria categoriaRoupas = new Categoria("Tipos de roupas");
	static Categoria carrinho = new Categoria("Carrinho de compras");
	static int codigoIdentificador=1;
	
	private static void inicializar() {
	       // Criando categorias
	   
	       // Adicionando os produtos na categoria vestidos     
	       vestido.adicionar(new Produto("vestido longo vermelho", 250.0, codigoIdentificador++));
	       vestido.adicionar(new Produto("vestido longo azul", 250.0, codigoIdentificador++));
	       vestido.adicionar(new Produto("vestido médio rosa", 125.50, codigoIdentificador++));
	       vestido.adicionar(new Produto("vestido médio preto", 80.0, codigoIdentificador++));
	       vestido.adicionar(new Produto("vestido médio branco", 100.0, codigoIdentificador++));
	       
	       // Adicionando os produtos na categoria blusa     
	       blusa.adicionar(new Produto("blusa manga longa preta", 60.0, codigoIdentificador++));
	       blusa.adicionar(new Produto("blusa manga longa branca", 60.0, codigoIdentificador++));
	       blusa.adicionar(new Produto("blusa manga curta preta", 45.0, codigoIdentificador++));
	       blusa.adicionar(new Produto("blusa manga curta branca", 45.0, codigoIdentificador++));
	       blusa.adicionar(new Produto("blusa polo preta", 90, codigoIdentificador++));
	       blusa.adicionar(new Produto("blusa polo branca", 90, codigoIdentificador++));
	       
	       // Adicionando os produtos na categoria calça     
	       calça.adicionar(new Produto("calça masculina jeans", 70.0, codigoIdentificador++));
	       calça.adicionar(new Produto("calça masculina moletom", 65.0, codigoIdentificador++));
	       calça.adicionar(new Produto("calça feminina jeans", 70.0, codigoIdentificador++));
	       calça.adicionar(new Produto("calça feminia moletom", 65.0, codigoIdentificador++));
	       
	       // Adicionando os produtos na categoria saia     
	       saia.adicionar(new Produto("saia longa branca", 250.0, codigoIdentificador++));
	       saia.adicionar(new Produto("saia longa azul", 250.0, codigoIdentificador++));
	       saia.adicionar(new Produto("saia longa preto", 125.50, codigoIdentificador++));
	       saia.adicionar(new Produto("saia média preto", 80.0, codigoIdentificador++));
	       saia.adicionar(new Produto("saia média branca", 100.0, codigoIdentificador++));
	       
	       // Adicionando as categorias específicas das roupas numa categoria geral
	       categoriaRoupas.adicionar(vestido);
	       categoriaRoupas.adicionar(blusa);
	       categoriaRoupas.adicionar(calça);
	       categoriaRoupas.adicionar(saia);
	       
	}
	
	public static boolean menu(Scanner input){
		int digitoDigitado;
		
		System.out.println("----------------------------------------------------");
		System.out.println("Digite: \n");
		System.out.println(" 1 - Para ver o carrinho de compras");
		System.out.println(" 2 - Para ver todos produtos disponíveis");
		System.out.println(" 3 - Para ver produtos de uma categoria específica");
		System.out.println(" 4 - Para adicionar um produto no carrinho de compras");
		System.out.println(" 5 - Para efetuar pagamento");
		System.out.println(" 6 - Para fechar programa");
		
		
		if(input.hasNextInt() == false) {
			System.out.println("Opção inválida!\n");
			String entradaInvalida = input.next(); 
			return Main.menu(input);
		}
		
		digitoDigitado = input.nextInt();
		if(digitoDigitado == 1) {
			
			if(carrinho.getComponentes().size()!=0) {
				System.out.println("----------------------------------------------------");
				carrinho.calcularPreco();
			}
			else {
				System.out.println("Carrinho de compras vazio!\n");
			}
			
		}
		else if(digitoDigitado == 2) {
			
			for(int i=0; i<categoriaRoupas.getComponentes().size(); i++) {
				categoriaRoupas.getComponentes().get(i).printarProduto();
			}
			
		}
		else if(digitoDigitado == 3) {
			System.out.println("Digite a categoria que desejada: \n");
			
			for(int i=1; i<=categoriaRoupas.getComponentes().size(); i++) {
				System.out.println(" " + i + "- " + ((Categoria)categoriaRoupas.getComponentes().get(i-1)).getNome() );
			}
			
			if(input.hasNextInt() == false) {
				System.out.println("Opção inválida!\n");
				String entradaInvalida = input.next(); 
				return Main.menu(input);
			}
			int categoriaDigitada = input.nextInt();
			boolean encontrouCategoria = false;
			
			for(int i=0; i<categoriaRoupas.getComponentes().size(); i++) {
				if(i+1 == categoriaDigitada) {					
					categoriaRoupas.getComponentes().get(i).printarProduto();
					encontrouCategoria = true;
				}
			}
			
			if(encontrouCategoria == false) {				
				System.out.println("Categoria inexistente!\n");
			}
				
		}
		else if(digitoDigitado == 4) {
			System.out.println(" Digite o código do produto: ");
			
			if(input.hasNextInt() == false) {
				System.out.println("Opção inválida!\n");
				String entradaInvalida = input.next(); 
				return Main.menu(input);
			}
			int codigoIdentificador = input.nextInt();
			
			boolean achouProduto = carrinho.adicionarProdutoNoCarrinho(categoriaRoupas, codigoIdentificador);
			
			if(achouProduto == false) {
				System.out.println("Código do produto digitado não existe!");
			}
			System.out.println();
		}
		else if(digitoDigitado == 5) {
			
			if(carrinho.getComponentes().size()!=0) {
				System.out.println("----------------------------------------------------");
				carrinho.calcularPreco();
				
				System.out.println("Digite a forma de pagamento desejada: ");
				System.out.println(" 1 - Cartão");
				System.out.println(" 2 - Pix");
				
				if(input.hasNextInt() == false) {
					System.out.println("Opção inválida!\n");
					String entradaInvalida = input.next(); 
					return Main.menu(input);
				}
				int formaPagamento = input.nextInt();
				
				if(formaPagamento == 1) {
					Contexto cartao = new Contexto(new PagamentoCartao());
					cartao.executarComportamento(input);
					carrinho.limparComponentes();
				}
				else if(formaPagamento == 2) {
					Contexto pix = new Contexto(new PagamentoPix());
					pix.executarComportamento(input);
					carrinho.limparComponentes();
				}
				else {
					System.out.println("Forma de pagamento inválida!");
				}
			}
			else {
				System.out.println("Carrinho de compras vazio!\n");
			}
			
		}
		else if(digitoDigitado == 6) {
			System.out.println("Programa encerrado!");
			return false; // programa terminou
			
		}
		else {
			System.out.println("Opção inválida!\n");
			return Main.menu(input);
		}
			
		return true;  // programa não terminou
	}
	
    public static void main(String[] args) {	
    	
    	// é aberto só uma vez, aqui na main
    	Scanner input = new Scanner(System.in);

    	//    	Nós já vamos deixar os produtos pré-adicionados aqui, 
    	//		ou seja, não vai ter interface para administrador da loja virtual criar produtos
    	Main.inicializar();

    	// Mostrando menu para o usário até que ele deseje encerrar o programa
    	while(Main.menu(input) == true);
    	
    	
    	// fechando a instância de Scanner
       input.close();
    }
}
