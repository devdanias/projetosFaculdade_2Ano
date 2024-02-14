package controle;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Cupom;
import modelo.Loja;
import modelo.Produtos;
import vizualizacao.EntradaSaida;

public class Controladora {
	private Cupom cupom = null;
	private Loja loja = new Loja();
	private Produtos produto = null;
	
	String codigoVenda = "";
	String data = "";
	String codigoEstoque;
	int quantProd;
	int quantidadeVenda = 0;
	
	Date date  ;
 
	public void exibeMenu() {
		int opcao = 0;
		String descricao = "";
		String codigo = "";
		double preco = 0;
		
		do {
			opcao = EntradaSaida.solicitaOpcao();
			
			switch (opcao) {
			
			case 0: //cadastro de produtos
				
				this.produto = new Produtos();
				descricao = EntradaSaida.solicitarDescricao();
				preco = EntradaSaida.solicitarPreco();
				codigo = EntradaSaida.solicitarCodigo();
				produto.setDescricao(descricao);
				produto.setPreco(preco);
				produto.setCodigo(codigo);
				loja.cadastroProdutos(produto);
				System.out.println(descricao);
				System.out.println(codigo);
				System.out.println(preco);
				break;

			case 1: //exibe produtos cadastrados

				String infoCadastro = loja.geraCadastro();
				EntradaSaida.exibeCadastro(infoCadastro);
				break;

			case 2: //dando entrada no estoque

				codigoEstoque = EntradaSaida.solicitarCodigo();
				boolean valid = loja.validaEstoque(codigoEstoque, codigoVenda);
				if (valid == true) {
					int produtoQta = EntradaSaida.quantidadeProduto();
					while (quantProd < 0) {
						quantProd = Integer.parseInt(
								JOptionPane.showInputDialog("Informe uma quantidade válida!"));
					}
					loja.addEsotque(codigoEstoque, produtoQta);

				} else {

					EntradaSaida.exibeMsgErro();

				}

				break;
			case 3: //exibindo estoque
				String infoEstoque = loja.gerarInfoEstoque();
				if (infoEstoque == "") { //verificando se há algo dentro do estoque
					JOptionPane.showMessageDialog(null, "Estoque vazio!");
				}else { 
				EntradaSaida.exibeEstoque(infoEstoque);
				}
				
				break;
			case 4: //vendendo produto e gerando o cupom da venda
			date = loja.geraData();
			codigoVenda = EntradaSaida.codigoVenda();
				boolean verificador = loja.validaProduto(codigoVenda, codigoVenda);
				if (verificador == true) { //verificando o produto
					quantidadeVenda = EntradaSaida.quantidadeVenda();
					boolean validaQuantEstoque = loja.validaEstoque(quantidadeVenda, codigoVenda);
					if (validaQuantEstoque) {
						JOptionPane.showMessageDialog(null, "Não há produtos desta categoria no estoque.");
					} else {

						loja.venderProduto(quantidadeVenda, codigoVenda);
						Cupom cupom = new Cupom();
						cupom.setData(date);
						cupom.setQtdaVenda(quantidadeVenda);
						double valorFinal = loja.calculaValor(preco, quantidadeVenda,codigoVenda);
						cupom.setValorFinal(valorFinal); 
						loja.criarCupom(cupom);
						String ProdVendido = loja.produtosVendidos(quantidadeVenda, codigoVenda, date,cupom);
						EntradaSaida.exibeVenda(ProdVendido);
					}
					// }
				} else {
					EntradaSaida.exibeMsgErro();

				}

				break;
			case 5: //cupom total
				String ProdVendido = loja.vendeProduto(quantidadeVenda, codigoVenda);
				if (ProdVendido == "" ) {
					JOptionPane.showMessageDialog(null, "Não há vendas");
				}else {
				EntradaSaida.exibeVenda(ProdVendido);
			double total=	loja.calculaValorTotal();
			EntradaSaida.exibeTotalCupom(total);
				}
				break;
			case 6: //tchau tchau
				EntradaSaida.exibeMsgEncerrar();
				System.exit(0);
			}
			

		} while (opcao != 6);
	 

	}
}