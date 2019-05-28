package br.com.camaraPoa.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Situacao {
	
	private int codigo;
	private String descricao;
	
	
	//construtor cheio
	public Situacao(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//construtor vazio
	public Situacao() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
