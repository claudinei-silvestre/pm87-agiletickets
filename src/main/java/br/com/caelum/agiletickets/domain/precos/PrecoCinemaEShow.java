package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;


public class PrecoCinemaEShow implements Preco{
	
	public BigDecimal calcula(Integer totalIngressos, Integer ingressosReservados) {
		
		return calcula(totalIngressos,ingressosReservados,null);
	}

	@Override
	public BigDecimal calcula(Integer totalIngressos,
			Integer ingressosReservados, Integer duracao) {
		BigDecimal preco = null;
		//quando estiver acabando os ingressos... 
		if((totalIngressos - ingressosReservados) / totalIngressos.doubleValue() <= 0.05) { 
			preco = preco.add(preco.multiply(BigDecimal.valueOf(0.10)));
		} 
		return preco;
	}

}
