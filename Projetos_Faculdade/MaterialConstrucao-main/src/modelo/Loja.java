package modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Loja {
	private ArrayList<Produtos> listaDeProdutos = new ArrayList<Produtos>();
	private ArrayList<Cupom> listaDeCupom = new ArrayList<Cupom>();

	public void criarCupom(Cupom cupom) {
		listaDeCupom.add(cupom);
	}

	public void cadastroProdutos(Produtos produto) {
		listaDeProdutos.add(produto);
	}

	public String geraCadastro() { // exibindo os produtos cadastrados
		String info = "";
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);

			info += "\nProduto: " + produto.getDescricao() + "\nPreço: R$" + +produto.getPreco() + "\nCódigo:" 
					 + produto.getCodigo();

		}
		return info;
	}

	public boolean validaEstoque(String codigo, String codigoEstoque) { // validando o codigo para estoque
		String info = "";
		int quant = 0;
		boolean valid = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if ((produto.getCodigo().equals(codigo)) || (produto.getCodigo().equals(codigoEstoque))) {
				valid = true;
			}
		}
		return valid;
	}

	public boolean validaProduto(String codigo, String codigoProduto) { // validando codigo para venda
		String info = "";
		int quant = 0;
		boolean valid = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (produto.getCodigo().equals(codigoProduto)) {
				valid = true;
			}
		}
		return valid;
	}

	public void addEsotque(String codigo, int quantidadeProduto) { // adicionando produto ao estoque
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (produto.getCodigo().equals(codigo)) {
				produto.setQuantidadeProduto(produto.getQuantidadeProduto() + quantidadeProduto);
			}
		}
	}

	public String gerarInfoEstoque() { // gerando info estoque
		String info = "";
		for (Produtos produto : this.listaDeProdutos) {
			info += "\nQuantidade:" + produto.getQuantidadeProduto() + "\nProduto: " + produto.getDescricao() + "\n Preço R$:" 
					 + produto.getPreco() + "\nCódigo: " + produto.getCodigo();
		}
		return info;
	}

	public boolean validaQuantida(int quantidadeEstoque) { //validando a quantidade de produtos em estoque
		boolean validaQuantidade = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);

			if (quantidadeEstoque > produto.getQuantidadeProduto()) {
				validaQuantidade = true;
			}

		}
		return validaQuantidade;
	}

	public boolean validaEstoque(int quantidadeVenda, String codigoVenda) { // validando quantidade no estoque
																					// para venda
		boolean veficadorEstoque = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			int tot = quantidadeVenda - produto.getQuantidadeProduto();
			if ((tot > 0) && (produto.getCodigo().equals(codigoVenda))) {

				veficadorEstoque = true;
			}
		}
		return veficadorEstoque;
	}

	public void venderProduto(int quantidadeVendida, String codigoVenda) { //retiando a quantidade vendidida da quantidade do estoque

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (codigoVenda.equals(produto.getCodigo())) {
				produto.setQuantidadeProduto(produto.getQuantidadeProduto() - quantidadeVendida);

			}
		}

	}

	public double calculaValor(double valor, int quantidadeVenda, String codigoVenda) { 
		double valorFinal = 0;
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if ((produto.getCodigo().equals(codigoVenda))) {
				valorFinal = produto.getPreco() * quantidadeVenda;
			}
		}
		return valorFinal;
	}
	public String produtosVendidos(int quantidadeVenda, String codigoVenda, Date date, Cupom cupom) { //exibindo produtos vendidos
		String info = "";

		for (Produtos produto : this.listaDeProdutos) {
			if (codigoVenda.equals(produto.getCodigo())) {

				info = ("\nQuantidade: " + quantidadeVenda + "\nProduto: " + produto.getDescricao() + "\n Preço R$: "
						+ cupom.getValorFinal() + "\nCódigo: " + produto.getCodigo() + "\nData " + date);

			}
		}
		return info;
	}
	public String vendeProduto(int quantidadeVendida, String codigoVenda) { 
		String info = "";
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			int total = quantidadeVendida - produto.getQuantidadeProduto();
			if (produto.getCodigo().equals(codigoVenda)) {
				for (Cupom cupom : this.listaDeCupom) {
					info += "\nQuantidade: " + cupom.getQtdaVenda() + "\nPreço R$: " + cupom.getValorFinal()
							+ "\nData " + cupom.getData() + "\n ";

				}

			}

		}

		return info;
	}

	public double calculaValorTotal() {
		double totValor = 0;
		for (Cupom cupom : this.listaDeCupom) {
			totValor += cupom.getValorFinal();
		}
		return totValor;
	}

	public Date geraData() {
		Date data = new Date();
		System.out.println("Data Agora: " + data);
		return data;
	}
}
