package javaCC;

public enum Tok {
	
	APARENT(1, ""),
	FPARENT(2, ""),
	ACOLCH(3, ""),
	FCOLCH(4, ""),
	ACHAVE(5,""),
	FCHAVE(6,""),
	VIRGULA(7,""),
	PTOVIRGULA(8,""),
	SOMA(9,"soma"),
	SUB(10,"sub"),
	MUL(11,"mul"),
	DIV(12,"div"),
	IGUAL(13,"igual"),
	DIFERENTE(14,""),
	MAIOR(15,""),
	MAIORIGUAL(16,""),
	MENOR(17,""),
	MENORIGUAL(18,""),
	OR(19,""),
	AND(20,""),
	NOT(21,""),
	ATRIBUICAO(22,""),
	ATRIBUICAO_SOMA(23,""),
	ATRIBUICAO_SUB(24,""),
	ATRIBUICAO_MUL(25,""),
	ATRIBUICAO_DIV(26,""),
	MOD(27,""),
	TERN_ENTAO(28,""),
	TERN_SENAO(29,""),
	STRING(30,"string"),
	INT(31,""),
	BOOL(32,""),
	TRUE(33,""),
	FALSE(34,""),
	BREAK(35,""),
	FOR(36,""),
	WHILE(37,""),
	RETURN(38,""),
	IF(39,""),
	ELSE(40, "");
	
	private final int id;
	private final String descricao;

	private Tok(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String descricao() {
		return this.descricao;
	}
}
