package modelo;

public class Produtos {
private double preco; 
private String descricao;
private String codigo;
private int quantProd; 


public double getPreco() {
	return  preco;
}

public void setPreco(double preco) {
	this.preco = preco ; 	
}

public String getDescricao() { 
	return descricao; 
}

public void setDescricao(String descricao) { 
	this.descricao = descricao;
}
public String getCodigo() { 
	return codigo;
}
public void setCodigo(String codigo)  {
	this.codigo = codigo;
}

public int getQuantidadeProduto() { 
	return quantProd; 
}
public void setQuantidadeProduto(int quantProd) { 
	this.quantProd = quantProd;
}

}