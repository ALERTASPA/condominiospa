package mx.org.dao.db.enums;

public enum ETokensSentencias {
	LLAVEIZQ    ("{"),
	D           ("{"),
	LLAVEDER    ("}"),
	E           ("}"),
	CORCHETEIZQ ("["),
	C           ("["),
	CORCHETEDER ("]"),
	B           ("]"),
	SIMPLE      ("\'\'"),
	F           ("\'\'"),
	DOBLE       ("\""),
	A           ("\""),
	GATITO      ("#"),
	IGUAL       ("=");
	
	private String caracter;
	
	private ETokensSentencias(String caracter) {
		this.caracter= caracter;
	}

	public String toCaracter() {
		return caracter;
	}	
}