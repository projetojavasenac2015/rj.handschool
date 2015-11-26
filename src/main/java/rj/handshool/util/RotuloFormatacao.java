package rj.handshool.util;

public enum RotuloFormatacao {
	Matricula("MAT"), Turma("TUR");
	
	public String  valor;
	
	RotuloFormatacao(final String valor){
		this.valor = valor;
	}
	
	public String getRotuloFormatacao(){
		return this.valor;
	}
}
