package analiseSemantica;

public enum ErroSemantico {
	
	ERRO_IF("A express�o condicional do comando if deve resultar em um valor do tipo l�gico."),
	ERRO_WHILE("A express�o condicional do comando while deve resultar em um valor do tipo l�gico."),
	ERRO_FOR_1("As atribui��es da inicializa��o e do passo devem ser analisadas como um comando de atribui��o normal"),
	ERRO_FOR_2("A express�o condicional deve resultar em um valor do tipo l�gico."),
	ERRO_BREAK("O comando break s� pode aparecer dentro de um comando de repeti��o (while ou for)."),
	ERRO_RETURN_1("O comando return s� pode aparecer dentro um subprograma."),
	ERRO_RETURN_2("Tipo de retorno inv�lido para a fun��o."),
	ERRO_READ("A vari�vel utilizada no comando read deve estar declarada e vis�vel no escopo atual."),
	ERRO_PROC_1("O procedimento chamado deve estar declarado e vis�vel no escopo atual."),
	ERRO_PROC_2("O n�mero de argumentos fornecidos deve ser o mesmo da declara��o do procedimento."),
	ERRO_PROC_3("Os argumentos fornecidos devem ter a mesma ordem de tipo utilizada na declara��o do procedimento."),
	ERRO_ATRIBUICAO_1("O lado esquerdo da atribui��o deve ser uma vari�vel declarada e vis�vel no escopo atual (simples ou acesso de array)"),
	ERRO_ATRIBUICAO_2("O lado direito deve ser uma express�o com tipo igual ao da vari�vel do lado esquerdo da atribui��o."),
	ERRO_ARITMETICA("O(s) operando(s) devem ser do tipo inteiro. O tipo resultante � inteiro"),
	ERRO_RELACIONAL("Os operandos devem ser do tipo inteiro. O tipo resultante � l�gico."),
	ERRO_IGUALDADE("Os operandos devem ser do mesmo tipo. O tipo resultante � l�gico."),
	ERRO_LOGICA("O(s) operando(s) devem ser do tipo l�gico. O tipo resultante � l�gico."),
	ERRO_TERNARIA_1("A express�o condicional deve resultar um valor do tipo l�gico."),
	ERRO_TERNARIA_2("As express�es consequente e alternativa devem possuir o mesmo tipo."),
	ERRO_TERNARIA_3("O tipo resultante � o mesmo tipo da express�o consequente."),
	ERRO_VARIAVEL("A vari�vel deve estar declarada e vis�vel no escopo atual.");
	
	private final String descricao;

	private ErroSemantico(String descricao) {
		this.descricao = descricao;
	}

	public String descricao() {
		return this.descricao;
	}
}
