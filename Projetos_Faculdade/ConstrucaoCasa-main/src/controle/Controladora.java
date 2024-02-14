package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vizualizacao.EntradaSaida;
import modelo.*;

public class Controladora {

	private Casa casa = null; // criação do objeto

	public void exibeMenu() {
		int opcao;
		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				this.casa = new Casa(); // instaciação da classe casa
				JOptionPane.showMessageDialog(null, "Construir Casa");

				String descricao = EntradaSaida.solicitaDescricao("casa", 0);
				String cor = EntradaSaida.solictaCor();
				int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
				int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");

				ArrayList<Abertura> listaDePortas = new ArrayList<Abertura>(); // declaração do array do tipo ABERTURAS
				// que recebera cada uma das portas cadastradas
				for (int i = 0; i < qtdePortas; i++) { // pode ter mais de uma porta, por isso é necessario ser repetido
					Porta porta = new Porta(); // criação de um novo objeto tipo Porta
					porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1))); // repassando a valor para //
																							// seus atributos
					porta.setEstado(EntradaSaida.solicitaEstado("porta"));
					listaDePortas.add(porta); // objeto é adicionado ao ArraList
				}
				ArrayList<Abertura> listaDeJanelas = new ArrayList<Abertura>();
				for (int i = 0; i < qtdeJanelas; i++) {
					Janela janela = new Janela();
					janela.setDescricao(EntradaSaida.solicitaDescricao("Janela", (i + 1)));
					janela.setEstado(EntradaSaida.solicitaEstado("Janela"));
					listaDeJanelas.add(janela);
				}
				this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
				System.out.println("Descrição da casa: " + casa.getDescricao() + "\n");
				System.out.println("Cor da casa:" + casa.getCor() + "\n");

				for (Abertura porta : casa.getListaDePortas()) {
					System.out.println("Descrição da porta: " + porta.getDescricap() + "\n");
					System.out.println("Estado da porta:" + porta.getEstado() + "\n");
				}
				for (Abertura janela : casa.getListaDeJanelas()) { // for each, usado quando sabemos o que queremos
																	// procurar, não quantas vezes queremos rodar o //
																	// código
					System.out.println("Descrição da janela: " + janela.getDescricap() + "\n");
					System.out.println("Estado da janela: " + janela.getEstado() + "\n");
				}

				break;
			case 1:
				if (casa == null) {
					JOptionPane.showMessageDialog(null, "A casa deve ser construida!");
				} else {
					JOptionPane.showMessageDialog(null, "Movimentar portas ou janelas");
					String tipoAbertura = EntradaSaida.solicitaTipoAbertura(); // onde o usuario informará o que deseja
																				// movimentar
					ArrayList<Abertura> listaDeAberturas = new ArrayList<Abertura>();

					if (tipoAbertura.equals("porta")) {
						listaDeAberturas = this.casa.getListaDePortas();
					} else {
						listaDeAberturas = this.casa.getListaDeJanelas();
					}
					int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas); // exibe as descrições das
																						// janelas
																						// // ou portas
					int novoEstado = 0;

					if (posicao != -1) {
						novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
						Abertura abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
						this.casa.moverAbertura(abertura, novoEstado);
						System.out.println("Novo estado da " + tipoAbertura + ":" + abertura.getEstado());
					} else {
						EntradaSaida.exibeMsgAbertura();
					}
				}
				break;
			case 2:
				if (casa == null) {
					JOptionPane.showMessageDialog(null, "A casa não foi construida");
				} else {
					JOptionPane.showMessageDialog(null, "Ver informações da casa");
					String informacoes = this.casa.geraInfoCasa(); // CHAMADA DO METODO
					EntradaSaida.exibeInfoCasa(informacoes);
					break;
				}
			}
		} while (opcao != 3);

		EntradaSaida.exibeMsgEcenrraPrograma();

		System.exit(0);

	}
}
