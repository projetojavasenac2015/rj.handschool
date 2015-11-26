package rj.handshool.util;

public enum Situacao {
	Ativo('1'), Inativo('0');
	
	public char valor;
	
	Situacao(final char valor){
		this.valor = valor;
	}
	
	public char getSituacao(){
		return this.valor;
	}
}
