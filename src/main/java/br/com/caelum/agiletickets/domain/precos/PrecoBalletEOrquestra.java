package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

public class PrecoBalletEOrquestra {
	public  BigDecimal calculaPrecoBalletEOrquestra(Integer totalIngressos, Integer ingressosReservados, Integer duracao) {
		BigDecimal preco = null;
		if((totalIngressos - ingressosReservados) / totalIngressos.doubleValue() <= 0.50) { 
			preco = preco.add(preco.multiply(BigDecimal.valueOf(0.20)));
		} 
		
		if(duracao > 60){
			preco = preco.add(preco.multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}
