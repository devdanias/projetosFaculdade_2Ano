package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fabrica {
	private String modelo;
	private String cor;
	private ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();

	public ArrayList<Carro> getListaDeCarros() {

		return listaDeCarros;
	}

	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;

	}

	public String geraInfoCarro() { //
		String informacoes = "";
		for (Carro carro : this.listaDeCarros) {
			String modelo = "";
			String cor = "";

			informacoes += "Modelo : " + carro.getModelo() + "\n";
			informacoes += "Cor : " + carro.getCor() + "\n";
		}
		return informacoes;

	}

	public void fabricarCarro(Carro carro) {
		listaDeCarros.add(carro);

	}

	public void venderCarro(String cor, String modelo) {
		for (int i = 0; i < listaDeCarros.size(); i++) {
			Carro carro = listaDeCarros.get(i);
			if (carro.getCor().equals(cor) && carro.getModelo().equals(modelo)) {
				listaDeCarros.remove(carro);
			} else {
				JOptionPane.showMessageDialog(null, "o carro não existe");
			}
		}
	}
}