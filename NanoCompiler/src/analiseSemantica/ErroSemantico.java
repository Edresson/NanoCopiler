package analiseSemantica;

public enum ErroSemantico {
	
	ERRO_IF("A expressão condicional do comando if deve resultar em um valor do tipo lógico."),
	ERRO_WHILE("A expressão condicional do comando while deve resultar em um valor do tipo lógico."),
	ERRO_FOR_1("As atribuições da inicialização e do passo devem ser analisadas como um comando de atribuição normal"),
	ERRO_FOR_2("A expressão condicional deve resultar em um valor do tipo lógico."),
	ERRO_BREAK("O comando break só pode aparecer dentro de um comando de repetição (while ou for)."),
	ERRO_RETURN_1("O comando return só pode aparecer dentro um subprograma."),
	ERRO_RETURN_2("Tipo de retorno inválido para a função."),
	ERRO_READ("A variável utilizada no comando read deve estar declarada e visível no escopo atual."),
	ERRO_PROC_1("O procedimento chamado deve estar declarado e visível no escopo atual."),
	ERRO_PROC_2("O número de argumentos fornecidos deve ser o mesmo da declaração do procedimento."),
	ERRO_PROC_3("Os argumentos fornecidos devem ter a mesma ordem de tipo utilizada na declaração do procedimento."),
	ERRO_ATRIBUICAO_1("O lado esquerdo da atribuição deve ser uma variável declarada e visível no escopo atual (simples ou acesso de array)"),
	ERRO_ATRIBUICAO_2("O lado direito deve ser uma expressão com tipo igual ao da variável do lado esquerdo da atribuição."),
	ERRO_ARITMETICA("O(s) operando(s) devem ser do tipo inteiro. O tipo resultante é inteiro"),
	ERRO_RELACIONAL("Os operandos devem ser do tipo inteiro. O tipo resultante é lógico."),
	ERRO_IGUALDADE("Os operandos devem ser do mesmo tipo. O tipo resultante é lógico."),
	ERRO_LOGICA("O(s) operando(s) devem ser do tipo lógico. O tipo resultante é lógico."),
	ERRO_TERNARIA_1("A expressão condicional deve resultar um valor do tipo lógico."),
	ERRO_TERNARIA_2("As expressões consequente e alternativa devem possuir o mesmo tipo."),
	ERRO_TERNARIA_3("O tipo resultante é o mesmo tipo da expressão consequente."),
	ERRO_VARIAVEL("A variável deve estar declarada e visível no escopo atual.");
	
	private final String descricao;

	private ErroSemantico(String descricao) {
		this.descricao = descricao;
	}

	public String descricao() {
		return this.descricao;
	}
}
