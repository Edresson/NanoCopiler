package javaCC;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Compilador {

	private List<Tok> listaTokensLidos;
	private String console = "";
	private InputStream codigo;
	private Parser parser;
	
	public Compilador() {
		try {
			parser = new Parser(IOUtils.toInputStream("", "UTF-8"));
		} catch (IOException e) {
			console += "Erro ao converter codigo para InputStream.";
		}
	}
	
	public void compilar(String codigoStr) {
		if (codigoStr.length() < 1)
			return;
		
		try {
			InputStream codigo;
			codigo = IOUtils.toInputStream(codigoStr, "UTF-8");
			
			Parser.ReInit(codigo);
			
			parser.compilar();
		} catch (IOException e) {
			console += "Erro ao converter codigo para InputStream.";
		} catch (ParseException e) {
			console += e.getMessage();
		}
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

	public InputStream getCodigo() {
		return codigo;
	}

	public void setCodigo(InputStream codigo) {
		this.codigo = codigo;
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}
}
