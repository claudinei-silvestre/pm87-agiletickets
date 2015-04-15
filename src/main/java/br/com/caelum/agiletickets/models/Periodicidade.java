package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	
	DIARIA(1), SEMANAL(7);
	private int offset;
	
	private Periodicidade(int offset) {
		this.offset = offset;
	}
	public int getOffset(){
		return offset;
	}
	
}
