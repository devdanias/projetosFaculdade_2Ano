package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import vizualizacao.EntradaSaida;
import modelo.Carro;
import modelo.Fabrica;

public class Controladora {

	private Fabrica fabrica = null;

	public void exibeMenu() {
		int opcao;

		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {

			case 0:
				this.fabrica = new Fabrica();
				int qtdeCarros = EntradaSaida.solicitaQtdeCarros("carro");

				for (int i = 0; i < qtdeCarros; i++) {
					Carro carro = new Carro();
					carro.setModelo(EntradaSaida.solicitarModelo("modelo", (i + 1)));
					carro.setCor(EntradaSaida.solicitarCor());
					this.fabrica.fabricarCarro(carro);

				}

				JOptionPane.showMessageDialog(null, "carros fabricados");
				break;
			case 1:
				if (fabrica == null) {
					EntradaSaida.fabricaCarros();
				} else {
					String cor = EntradaSaida.modelo("");
					String modelo = EntradaSaida.solicitarCor();
					fabrica.venderCarro(modelo, cor);
					JOptionPane.showMessageDialog(null, "carros vendidos");
				}
				break;
			case 2:
				if (fabrica == null) {
					EntradaSaida.fabricaCarros();
				} else {
					String informacoes = this.fabrica.geraInfoCarro();
					EntradaSaida.exibeInfoCarro(informacoes);
					JOptionPane.showMessageDialog(null, "Ver informações do carro");
					break;
				}
			case 3:
				EntradaSaida.exibeMsgEncerraPrograma();
				System.exit(0);
				break;
			}

		} while (opcao != 4);

	}
}
