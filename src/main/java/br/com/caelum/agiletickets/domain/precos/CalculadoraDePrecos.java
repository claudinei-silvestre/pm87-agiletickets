package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		Espetaculo espetaculo = sessao.getEspetaculo();
		
		preco = calculaPreco(sessao, espetaculo); 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaPreco(Sessao sessao, Espetaculo espetaculo) {
		return sessao.getPreco();
	}

}