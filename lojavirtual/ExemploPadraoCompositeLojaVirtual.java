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
    private String codigoIdentificador;

    public Produto(String nome, double preco, String codigoIdentificador) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double calcularPreco() {
    	System.out.println("Produto: " + nome + ", Preço: " + preco);
    	return preco;
    }
    
    public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public void setCodigoIdentificador(String codigoIdentificador) {
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
        return precoTotal;
    }
}
