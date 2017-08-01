package analiseSemantica;

import parser.SimpleNode;
import parser.Token;

public class Simbolo {
	
	private SimpleNode node;
	private Object value;
	private Token token;
	private int type;
	
	public SimpleNode getNode() {
		return node;
	}
	public void setNode(SimpleNode node) {
		this.node = node;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
