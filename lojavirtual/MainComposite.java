package lojavirtual;

public class MainComposite {
	// Cliente (simula��o de um carrinho de compras)
    public static void main(String[] args) {
        // Criando produtos
        Componente produto1 = new Produto("Camiseta", 25.0);
        Componente produto2 = new Produto("Cal�a Jeans", 50.0);

        // Criando categorias
        Categoria eletronicos = new Categoria("Eletr�nicos");
        eletronicos.adicionar(new Produto("Smartphone", 500.0));
        eletronicos.adicionar(new Produto("Fones de Ouvido", 30.0));

        Categoria vestuario = new Categoria("Vestu�rio");
        vestuario.adicionar(new Produto("T�nis", 80.0));
        vestuario.adicionar(new Produto("Bon�", 15.0));

        // Criando o carrinho de compras e adicionando produtos/categorias
        Categoria carrinho = new Categoria("Carrinho de Compras");
        carrinho.adicionar(produto1);
        carrinho.adicionar(produto2);
        carrinho.adicionar(eletronicos);
        carrinho.adicionar(vestuario);

        // Calculando o pre�o total do carrinho de compras
        double precoTotal = carrinho.calcularPreco();
        System.out.println("Pre�o Total do Carrinho: " + precoTotal);
    }
}
