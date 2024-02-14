package vizualizacao;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Abertura;

public class EntradaSaida {

	public static int solicitaOpcao() {
 		String[] opcoes = { "Construir casa", "Movimentar portas ou janelas", "Ver informações da casa",
				"Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opcão desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEcenrraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}

	public static String solicitaDescricao(String descricao, int ordem) {
//esse metodo serve para tanto para retornar a descrição da casa como as das portas ou janelas
		if (ordem == 0) {
			return JOptionPane.showInputDialog("Informe a descrição da " + descricao);
		} else {
			return JOptionPane.showInputDialog("Informe a descrição da " + ordem + " " + descricao );
		}
	}

	public static String solictaCor() {
		return JOptionPane.showInputDialog("informe a cor da casa");
	}

	public static int solicitaQtdeAberturas(String texto) {
		int abertura = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de " + texto));
		while (abertura <= 0) {
			abertura = Integer.parseInt(JOptionPane.showInputDialog("Tente novamente!"));
		}
	return abertura;
	}

	public static int solicitaEstado(String tipoAbertura) {
		String[] opcoes = { "Fechada", "Aberta" };
		return JOptionPane.showOptionDialog(null, "Informe o estado da" + tipoAbertura, "Estado",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
	}

	public static String solicitaTipoAbertura() {
		String[] opcoes = { "Porta", "Janela" };
		int tipoAbertura = JOptionPane.showOptionDialog(null, "Informe qual o tipo de abertura deseja mover",
				"Mover Abertura", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		if (tipoAbertura == 0) {
			return "porta";
		} else {
			return "janela";
		}
	}

	public static int solicitaAberturaMover(ArrayList<Abertura> listaDeAberturas) {
		String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
		tipoAbertura = tipoAbertura.replaceAll("modelo", ""); // usado ara substituir "modelo" "por". Sobrando somente
																// Porta ou janela
		int qtdeAbertura = listaDeAberturas.size(); // descobrir o tamanho da lista
		String[] descricoesAberturas = new String[qtdeAbertura]; // criação do vetor de Stings

		for (int i = 0; i < qtdeAbertura; i++) { // repetirá qtAberturas e preencherá cada uma das posições do vetor
													// "descricoesAberturas"
			descricoesAberturas[i] = listaDeAberturas.get(i).getDescricap();
		}
		String msg = "Escolha a " + tipoAbertura + " a ser movimentada";
		JComboBox exibicaoAerturas = new JComboBox(descricoesAberturas); // recebe em seu metodo o vetor de Strings com
																			// as descrições das janelas e portas
		int comfirmacao = JOptionPane.showConfirmDialog(null, exibicaoAerturas, msg, JOptionPane.OK_CANCEL_OPTION); // receberá
																													// a
																													// comfirmação
																													// do
																													// "OK"
																													// ou
																													// "CANCELAR"

		if (comfirmacao == 0) {
			return exibicaoAerturas.getSelectedIndex();
		} else {
			return -1;
		}
	}

	public static void exibeMsgAbertura() {

		JOptionPane.showMessageDialog(null, "nenhuma abertura sera movimentada");
	}

	public static void exibeInfoCasa(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informações da casa", JOptionPane.INFORMATION_MESSAGE);
	}
}