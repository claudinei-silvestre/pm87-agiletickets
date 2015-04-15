package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;


public class PrecoCinemaEShow {
	
	public BigDecimal calculaPrecoCinemaEShow(Integer totalIngressos, Integer ingressosReservados) {
		BigDecimal preco = null;
		//quando estiver acabando os ingressos... 
		if((totalIngressos - ingressosReservados) / totalIngressos.doubleValue() <= 0.05) { 
			preco = preco.add(preco.multiply(BigDecimal.valueOf(0.10)));
		} 
		return preco;
	}

}
