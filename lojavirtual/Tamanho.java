package lojavirtual;

public class Estoque {
	Tamanho tamanhoPP = new Tamanho();
	Tamanho tamanhoP = new Tamanho();
	Tamanho tamanhoM = new Tamanho();
	Tamanho tamanhoG = new Tamanho();
	Tamanho tamanhoGG = new Tamanho();
	Tamanho tamanhoXG = new Tamanho();
	
	// set uma quantidade geral para todos tamanhos
	public void setTodosTamanhos(int quantidadeUnidades) {
		tamanhoPP.setQuantidadeUnidades(quantidadeUnidades);
		tamanhoP.setQuantidadeUnidades(quantidadeUnidades);
		tamanhoM.setQuantidadeUnidades(quantidadeUnidades);
		tamanhoG.setQuantidadeUnidades(quantidadeUnidades);
		tamanhoGG.setQuantidadeUnidades(quantidadeUnidades);
		tamanhoXG.setQuantidadeUnidades(quantidadeUnidades);
	}
	
	// getters e setters
	public Tamanho getTamanhoPP() {
		return tamanhoPP;
	}
	public void setTamanhoPP(Tamanho tamanhoPP) {
		this.tamanhoPP = tamanhoPP;
	}
	public Tamanho getTamanhoP() {
		return tamanhoP;
	}
	public void setTamanhoP(Tamanho tamanhoP) {
		this.tamanhoP = tamanhoP;
	}
	public Tamanho getTamanhoM() {
		return tamanhoM;
	}
	public void setTamanhoM(Tamanho tamanhoM) {
		this.tamanhoM = tamanhoM;
	}
	public Tamanho getTamanhoG() {
		return tamanhoG;
	}
	public void setTamanhoG(Tamanho tamanhoG) {
		this.tamanhoG = tamanhoG;
	}
	public Tamanho getTamanhoGG() {
		return tamanhoGG;
	}
	public void setTamanhoGG(Tamanho tamanhoGG) {
		this.tamanhoGG = tamanhoGG;
	}
	public Tamanho getTamanhoXG() {
		return tamanhoXG;
	}
	public void setTamanhoXG(Tamanho tamanhoXG) {
		this.tamanhoXG = tamanhoXG;
	}
}
