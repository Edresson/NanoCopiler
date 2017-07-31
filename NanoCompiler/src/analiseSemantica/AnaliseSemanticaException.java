package analiseSemantica;

import parser.SimpleNode;

public class AnaliseSemanticaException extends Exception {

	private static final long serialVersionUID = 1L;

  	private SimpleNode node;
  	private String erro;
  	private int linha; 
  	private int coluna;
  
  	public AnaliseSemanticaException(SimpleNode node, String erro, int linha, int coluna) {
	    super();
	    this.node = node;
	    this.erro = erro;
	    this.linha = linha;
    	this.coluna = coluna;
  	}

  	public AnaliseSemanticaException(SimpleNode node, String erro) {
  		super();
  		this.node = node;
  		this.erro = erro;
  	}

  	public AnaliseSemanticaException() {
  		super();
  	}

	public SimpleNode getNode() {
		return node;
	}
	
	public void setNode(SimpleNode node) {
		this.node = node;
	}
	
	public String getErro() {
		return erro;
	}
	
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	  
}