package lojavirtual;

public class Tamanho {
	private int quantidadeUnidades = 0;

	// construtor vazio
	public Tamanho() {
	}
	
	// construtor
	public Tamanho(int quantidadeUnidades) {
		this.quantidadeUnidades = quantidadeUnidades;
	}
	
	// get e set
	public int getQuantidadeUnidades() {
		return quantidadeUnidades;
	}
	public void setQuantidadeUnidades(int quantidadeUnidades) {
		this.quantidadeUnidades = quantidadeUnidades;
	}
	
	// incrementar quantidade no estoque desse tamanho
	public void somarQuantidade(int quantidadeParaSomar) {
		this.quantidadeUnidades += quantidadeParaSomar;
	}
	
	// decrementar quantidade no estoque desse tamanho
	public void subtrairQuantidade(int quantidadeParaSubtrair) {
		this.quantidadeUnidades -= quantidadeParaSubtrair;
	}
}
