package front;

import static org.apache.commons.io.IOUtils.toInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import parser.Parser;
import parser.SimpleNode;

public class Compilador {

	public static final Integer SUCESSO = 1;
	public static final Integer NAO_COMPILADO = 0;
	public static final Integer ERRO = -1;
	
	private String console = "";
	private InputStream codigo;
	private Parser parser;
	private SimpleNode arvoreSemantica;
	
	public Compilador() {
		try {
			parser = new Parser(IOUtils.toInputStream("", "UTF-8"));
		} catch (IOException e) {
			console += "Erro ao converter codigo para InputStream.";
		} catch (Error e) {
			
		}
	}
	
	public Integer compilar(String codigoStr) {
		if (codigoStr.length() < 1) {
			console = "Não há código para compilar.";
			return NAO_COMPILADO;
		}
		
		try {
			console = "";
			InputStream codigo;
			codigo = toInputStream(codigoStr, "UTF-8");
			
			Parser.ReInit(codigo);
			
			arvoreSemantica = parser.compilar();
			
			console = "Código compilado sem erros";
			return SUCESSO;
			
		} catch (IOException e) {
			console += "Erro ao converter codigo para InputStream.";
			return ERRO;
		} catch (Exception e) {
			console += e.getMessage();
			return ERRO;
		} catch (Error e) {
			console += e.getMessage();
			return ERRO;
		}
	}
	
	public String printAst() {
		try {
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		    PrintStream printer = new PrintStream(byteArray);
		    
		    System.out.flush();
		    System.setOut(printer);
		    
		    arvoreSemantica.dump("");
		    
//		    analiseSemantica(arvoreSemantica);
		    
			return byteArray.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			console = "Erro ao processar árvore semântica.";
			return e.getMessage();
		}
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

	public SimpleNode getArvoreSemantica() {
		return arvoreSemantica;
	}

	public void setArvoreSemantica(SimpleNode arvoreSemantica) {
		this.arvoreSemantica = arvoreSemantica;
	}
	
}
