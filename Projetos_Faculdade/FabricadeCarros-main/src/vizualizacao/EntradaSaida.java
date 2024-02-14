package vizualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Fabricar Carro", "Vender Carro", "Ver informa��es do carro", "Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opc�o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int solicitaQtdeCarros(String texto) {
		int qtdeCarros = Integer.parseInt(JOptionPane.showInputDialog(" Informe quantos carros ir� fabricar " + texto));
		while ((qtdeCarros < 0)) {

			qtdeCarros = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Tente novamente!", null, JOptionPane.ERROR_MESSAGE));
		}
		return qtdeCarros;
	}

	public static String solicitarModelo(String modelo, int ordem) {
		if (ordem == 0) {
			return JOptionPane.showInputDialog("Informe o modelo do carro" + modelo);
		} else {
			return JOptionPane.showInputDialog("Informe o " + modelo + " do " + ordem + "� carro");
		}
	}

	public static String solicitarCor() {

		return JOptionPane.showInputDialog("Informe a cor do carro");

	}

	public static String modelo(String modelo) {

		return JOptionPane.showInputDialog("Informe o modelo do carro" + modelo);
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa ser� encerrado");
	}

	public static void fabricaCarros() {
		JOptionPane.showMessageDialog(null, "Fabrique um carro antes!");
	}

	public static void exibeInfoCarro(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informa��es carro", JOptionPane.INFORMATION_MESSAGE);
	}
}
