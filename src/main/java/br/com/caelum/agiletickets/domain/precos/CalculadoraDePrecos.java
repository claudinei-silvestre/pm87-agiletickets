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
		BigDecimal preco;
		if(espetaculo.getTipo().equals(TipoDeEspetaculo.CINEMA) || espetaculo.getTipo().equals(TipoDeEspetaculo.SHOW)) {
			preco = calculaPrecoCinemaEShow(sessao);
		} else if(espetaculo.getTipo().equals(TipoDeEspetaculo.BALLET) || espetaculo.getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			preco = calculaPrecoBalletEOrquestra(sessao);
		}  else {
			//nao aplica aumento para teatro (quem vai é pobretão)
			preco = sessao.getPreco();
		}
		return preco;
	}

	private static BigDecimal calculaPrecoBalletEOrquestra(Sessao sessao) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
		} else {
			preco = sessao.getPreco();
		}
		
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

	private static BigDecimal calculaPrecoCinemaEShow(Sessao sessao) {
		BigDecimal preco;
		//quando estiver acabando os ingressos... 
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

}