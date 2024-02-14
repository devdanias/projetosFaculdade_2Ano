package modelo;

import java.util.Date;

public class Cupom {

	private Date data;
	private int quantVendido;
	private double valorFinal;

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public int getQtdaVenda() {
		return quantVendido;
	}

	public void setQtdaVenda(int quantVendido) {
		this.quantVendido = quantVendido;

	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {

	this.valorFinal = valorFinal;
	}



}