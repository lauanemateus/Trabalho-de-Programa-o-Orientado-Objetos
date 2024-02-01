package lojavirtual;

import java.util.ArrayList;
import java.util.List;

// Componente
interface Componente {
    double calcularPreco();
    void printarProduto();
}

// Folha (produto simples)
class Produto implements Componente {
    private String nome;
    private double preco;
    private int codigoIdentificador;
    
    public Produto(String nome, double preco, int codigoIdentificador){
        this.nome = nome;
        this.preco = preco;
        this.codigoIdentificador = codigoIdentificador;
    }

    @Override
    public double calcularPreco() {
    	System.out.println("Produto: " + nome + ", Preço: " + preco);
    	return preco;
    }
    
    @Override
    public void printarProduto() {
    	System.out.println("Código do produto: " + codigoIdentificador + "\nProduto: "+ nome + "\nPreço: " + preco);
    }
    
    public int getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public void setCodigoIdentificador(int codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}

// Composto (categoria que pode conter produtos e/ou subcategorias)
class Categoria implements Componente {
    private String nome;
    private List<Componente> componentes = new ArrayList<>();
    
    public Categoria(String nome) {
    	this.nome = nome;
    }
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}
	
	public void limparComponentes() {
		componentes.clear();
		System.out.println("Carrinho sem nenhum produto!\n");
	}

    public Produto getProduto(int codigoIdentificador) {
    	for(int i=0; i<componentes.size(); i++) {
    		if( ((Produto)componentes.get(i)).getCodigoIdentificador() == codigoIdentificador) {
    			return (Produto)componentes.get(i);    			
    		}
    	}
    	return new Produto("Produto não encontrado", 0, -1);
    }

    public void adicionar(Componente componente) {
        componentes.add(componente);
    }

    public void remover(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public double calcularPreco() {
        System.out.println(nome);
        double precoTotal = 0;
        for (Componente componente : componentes) {
            precoTotal += componente.calcularPreco();
        }
        System.out.println("Preço Total: " + precoTotal + "\n");
        return precoTotal;
    }
    
    @Override
    public void printarProduto() {
    	System.out.println("----------------------------------------------------");
		System.out.println("Seção: " + nome);
		for(int i=0; i< componentes.size(); i++) {
			(componentes.get(i)).printarProduto();
			System.out.println();
		}
    }
    
    public boolean adicionarProdutoNoCarrinho(Categoria categoriaRoupas, int codigoIdentificador) {
    	
    	Produto produto;
    	Categoria categoriaAtual = new Categoria("categoriaAtual");
    	for(int i=0; i<categoriaRoupas.getComponentes().size(); i++) {
    		categoriaAtual = (Categoria) categoriaRoupas.getComponentes().get(i);
    		produto = categoriaAtual.getProduto(codigoIdentificador);
    		if(produto.getCodigoIdentificador() != -1) {
    			
				this.adicionar(produto);
				System.out.println("Produto adicionado!\n");
    			return true;
    		}
    	}
    	return false;
    }
}
