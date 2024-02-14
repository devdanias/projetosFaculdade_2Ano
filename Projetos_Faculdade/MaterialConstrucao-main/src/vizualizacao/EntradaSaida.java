package vizualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() { 
		String [] op = { "Cadastrar Produtos", "Produtos Cadastrados", "Entrada no Estoque ", "Exibir Estoque", "Vender Produto", "Exibir Cupons", "Sair" };
		JComboBox<String>menu = new JComboBox<String>(op);
		JOptionPane.showConfirmDialog(null, menu, "Selecione opção", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
				
	}
	public static String solicitarDescricao() { 
		String descricao = JOptionPane.showInputDialog(null, "Informe a descricao do produto:");
		return descricao;
	}
	public static double solicitarPreco() { 
	double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do produto"));
	return valor;
	}
	public static String solicitarCodigo() { 
		String cod = JOptionPane.showInputDialog(null, "Informe o código do produto");
		return cod;
	}
	
	public static void exibeCadastro(String info) { 
		JOptionPane.showMessageDialog(null, info);
		
	}
	
	public static String solicitaProdCod() { 
		String codig = JOptionPane.showInputDialog("Insira o código do produto");
		return codig;
	}
	
	public static int quantidadeProduto() { 
		int quant = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para estoque"));
		return quant;
	}
	
	public static void exibeEstoque(String infoEstoque) {
		JOptionPane.showMessageDialog(null, infoEstoque);
	}
	public static String codigoVenda() { 
		String	info = JOptionPane.showInputDialog("Código para venda:");
		return info;	
		}
	public static int quantidadeVenda() { 
		int venda = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade para venda"));
		return venda ; 
	}
	public static void exibeMsgEncerrar () { 
		JOptionPane.showMessageDialog(null, "Programa encerrado");
	}
	public static void exibeMsgErro() { 
		JOptionPane.showMessageDialog(null, "Código inválido", "Erro",  (JOptionPane.INFORMATION_MESSAGE));
	}
	public static String solicitaData() {
		String data = JOptionPane.showInputDialog(null, "Data de hoje");
		return data;
	}
	public static void exibeVenda(String ProdutoVendido) {
		JOptionPane.showMessageDialog(null, ProdutoVendido);
		
	}
	public static void exibeTotalCupom (double total) { 
		JOptionPane.showMessageDialog(null,"Total de vendas: R$ "+total);
	}
	
}