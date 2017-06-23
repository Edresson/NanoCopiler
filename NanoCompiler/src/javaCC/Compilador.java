package javaCC;

import java.util.List;

public class Compilador {

	private List<Tok> listaTokensLidos;
	private String console;
	private String codigo;
	
	public Compilador(String codigo) {
		if (codigo.length() > 0) {
			this.codigo = codigo;
			compilarCodigo();
		}
	}

	private void compilarCodigo() {
		//TODO
	}
	
	public List<Tok> getListaTokensLidos() {
		return listaTokensLidos;
	}
	
	public void setListaTokensLidos(List<Tok> listaTokensLidos) {
		this.listaTokensLidos = listaTokensLidos;
	}
	
	public String getConsole() {
		return console;
	}
	
	public void setConsole(String console) {
		this.console = console;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
