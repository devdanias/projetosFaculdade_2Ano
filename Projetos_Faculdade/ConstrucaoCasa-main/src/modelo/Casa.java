package modelo;

import java.util.ArrayList; //importação da Classe ArrayList

import javax.swing.JOptionPane;

public class Casa {

	private String descricao;
	private String cor;
	private ArrayList<Abertura> listaDePortas = new ArrayList<Abertura>(); // instancia do objeto ArrayList
	private ArrayList<Abertura> listaDeJanelas = new ArrayList<Abertura>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ArrayList<Abertura> getListaDePortas() {
		return listaDePortas;
	}

	public void setListaDePortas(ArrayList<Abertura> listaDePortas) {
		this.listaDePortas = listaDePortas;
	}

	public ArrayList<Abertura> getListaDeJanelas() {
		return listaDeJanelas;
	}

	public void setListaDeJanelas(ArrayList<Abertura> listaDeJanelas) {
		this.listaDeJanelas = listaDeJanelas;
	}

	public void constroiCasa(String descricao, String cor, ArrayList<Abertura> listaDePortas,
			ArrayList<Abertura> listaDeJanelas) {
		setDescricao(descricao);
		setCor(cor);
		setListaDePortas(listaDePortas);
		setListaDeJanelas(listaDeJanelas);
	}

	public Abertura retornaAbertura(int posicao, String tipoAbertura) {
		if (tipoAbertura.equals("porta")) {
			return this.listaDePortas.get(posicao);
		} else {
			return this.listaDeJanelas.get(posicao);
		}
	}

	public void moverAbertura(Abertura abertura, int novoEstado) { // Recebe a referencia do objeto a ser movimentado
		abertura.setEstado(novoEstado);
	}

	public String geraInfoCasa() { // metodo que acessa os atributos e gera String de forma organizada para exibir
		String informacoes = "Descição:" + this.descricao + "\nCor:"  + this.cor + "\nlista de portas:\n";
		String posicao = "";
		for (Abertura abertura : this.listaDePortas) {
			int estado = abertura.getEstado();
			if (estado == 0) {
				posicao = "Fechado";
			} else {
				posicao = "Aberto";
			}
			informacoes += abertura.getDescricap() + "Estado: " + posicao + " \n";

		}

		informacoes += "\nLista de janelas:\n";

		for (Abertura abertura : this.listaDeJanelas) {
			int estado = abertura.getEstado();
			if (estado == 0) {
				posicao = "Fechado";
			} else {
				posicao = "Aberto";
			}
			informacoes += abertura.getDescricap() + "Estado:" + posicao + " \n";
		}
		return informacoes;

	}
}