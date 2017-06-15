package javaCC;

public enum Tok {
	
	APARENT(1, "APARENT"),
	FPARENT(2, "FPARENT"),
	ACOLCH(3, "ACOLCH"),
	FCOLCH(4, "FCOLCH"),
	ACHAVE(5,"ACHAVE"),
	FCHAVE(6,"FCHAVE"),
	VIRGULA(7,"VIRGULA"),
	PTOVIRGULA(8,"PTOVIRGULA"),
	SOMA(9,"SOMA"),
	SUB(10,"SUB"),
	MUL(11,"MUL"),
	DIV(12,"DIV"),
	IGUAL(13,"IGUAL"),
	DIFERENTE(14,"DIFERENTE"),
	MAIOR(15,"MAIOR"),
	MAIORIGUAL(16,"MAIORIGUAL"),
	MENOR(17,"MENOR"),
	MENORIGUAL(18,"MENORIGUAL"),
	OR(19,"OR"),
	AND(20,"AND"),
	NOT(21,"NOT"),
	ATRIBUICAO(22,"ATRIBUICAO"),
	ATRIBUICAO_SOMA(23,"ATRIBUICAO_SOMA"),
	ATRIBUICAO_SUB(24,"ATRIBUICAO_SUB"),
	ATRIBUICAO_MUL(25,"ATRIBUICAO_MUL"),
	ATRIBUICAO_DIV(26,"ATRIBUICAO_DIV"),
	MOD(27,"MOD"),
	TERN_ENTAO(28,"TERN_ENTAO"),
	TERN_SENAO(29,"TERN_SENAO"),
	STRING(30,"STRING"),
	INT(31,"INT"),
	BOOL(32,"BOOL"),
	TRUE(33,"TRUE"),
	FALSE(34,"FALSE"),
	BREAK(35,"BREAK"),
	FOR(36,"FOR"),
	WHILE(37,"WHILE"),
	RETURN(38,"RETURN"),
	IF(39,"IF"),
	ELSE(40, "ELSE"),
	IDENTIFICADOR(41, "IDENTIFICADOR"),
	NUMERO(42, "NUMERO"),
	RESTO(43, "RESTO"),
	READ(44, "READ"),
	WRITE(45, "WRITE");
	
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
