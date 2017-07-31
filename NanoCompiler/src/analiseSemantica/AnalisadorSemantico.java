package analiseSemantica;

import static parser.ParserTreeConstants.JJTATRIBUICAO;
import static parser.ParserTreeConstants.JJTCHAMADABREAK;
import static parser.ParserTreeConstants.JJTCHAMADAFOR;
import static parser.ParserTreeConstants.JJTCHAMADAIF;
import static parser.ParserTreeConstants.JJTCHAMADARETURN;
import static parser.ParserTreeConstants.JJTCHAMADAWHILE;
import static parser.ParserTreeConstants.JJTEXP;

import java.util.List;

import parser.Node;
import parser.ParserTreeConstants;
import parser.SimpleNode;

public class AnalisadorSemantico {
	
	private static final int BOOL = 1;
	private static final int INT = 2;
	private static final int STRING = 3;
	
	private List<SimpleNode> tabelaDeSimbolos;
	
	public static boolean isTipoPrimitivo(SimpleNode node) {
		return node.jjtGetValue() != null;
	}
	
	public static void analiseSemantica(SimpleNode node) {
		System.out.println(ParserTreeConstants.jjtNodeName[node.getId()] + " ");
		
		if (node == null || node.jjtGetNumChildren() < 1)
			return;
		
		for (Node childNode : node.getChildren()) {
			SimpleNode simpleChildNode = (SimpleNode) childNode;
			analiseSemantica(simpleChildNode);
		}
		
		// TODO faltando implementar procedimento, expressao e variavel
		if (JJTCHAMADAIF == node.getId()) {
			
		} else if (JJTCHAMADAWHILE == node.getId()) {
		
		} else if (JJTCHAMADAFOR == node.getId()) {
		
		} else if (JJTCHAMADABREAK == node.getId()) {
			
		} else if (JJTCHAMADARETURN == node.getId()) {
			
		} else if (JJTATRIBUICAO == node.getId()) {
			
		} else if (JJTEXP == node.getId()) {
			//TODO
		}
 		
	}
	
}
