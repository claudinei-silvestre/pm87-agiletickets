package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

public interface Preco {
	public BigDecimal calcula(Integer totalIngressos, Integer ingressosReservados, Integer duracao);
}
