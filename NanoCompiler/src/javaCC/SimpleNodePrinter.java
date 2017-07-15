package javaCC;

public class SimpleNodePrinter extends SimpleNode{
	
	public SimpleNodePrinter(Parser p, int i) {
		super(p, i);
	}

	public String printAST(String prefix) {
		String ast = toString(prefix);
	    
		if (children != null) {
	    	for (Node node : children) {
				SimpleNodePrinter simpleNode = (SimpleNodePrinter) node;
				if (simpleNode != null) {
					ast += simpleNode.printAST(prefix + " ");
				}
	    	}
	    }

	    return ast;
	}
}
