package lojavirtual;

import java.util.ArrayList;
import java.util.List;

// Componente
interface Componente {
    double calcularPreco();
}

// Folha (produto simples)
class Produto implements Componente {
    private String nome;
    private double preco;
    private int codigoIdentificador;
    protected Estoque estoque = new Estoque();
    
    public Produto(String nome, double preco, int codigoIdentificador, int quantidadeUnidades){
        this.nome = nome;
        this.preco = preco;
        this.codigoIdentificador = codigoIdentificador;
        this.estoque.setTodosTamanhos(quantidadeUnidades);
    }

    @Override
    public double calcularPreco() {
    	System.out.println("Produto: " + nome + ", Preço: " + preco);
    	return preco;
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
	
	public void printarProduto() {
		System.out.println("Código do produto: " + codigoIdentificador + "\nProduto: "+ nome + "\nPreço: " + preco);
	}
	
}

// Composto (categoria que pode conter produtos e/ou subcategorias)
class Categoria implements Componente {
    private String nome;
    private List<Componente> componentes = new ArrayList<>();

    public Produto getProduto(int codigoIdentificador) {
    	for(int i=0; i<componentes.size(); i++) {
    		if( ((Produto)componentes.get(i)).getCodigoIdentificador() == codigoIdentificador) {
    			return (Produto)componentes.get(i);
    		}
    	}
    	return new Produto("Produto não encontrado", 0, -1, 0);
    }
    
    public Categoria(String nome) {
        this.nome = nome;
    }

    public void adicionar(Componente componente) {
        componentes.add(componente);
    }

    public void remover(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public double calcularPreco() {
        System.out.println("Categoria: " + nome);
        double precoTotal = 0;
        for (Componente componente : componentes) {
            precoTotal += componente.calcularPreco();
        }
        System.out.print("\n");
        return precoTotal;
    }
}
