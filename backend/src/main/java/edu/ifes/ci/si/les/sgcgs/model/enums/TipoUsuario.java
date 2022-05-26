package edu.ifes.ci.si.les.sgcgs.model.enums;


public enum TipoUsuario {

    COMUM(0, "Usuário comum"),
	REDATOR(1, "Usuário administrador"),
	ADMINISTRADOR(2, "Usuário administrador");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoUsuario x : TipoUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
