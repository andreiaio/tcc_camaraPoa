package br.com.camaraPoa.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class DocumentoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	@Column(name="ano")
	private int ano;
	@Column(name="data")
	private String data;
	@Column(name="numero_doc")
	private int numero_doc;
	@Column(name="principal")
	private char principal;
	@Column(name="codigo_site")
	private int codigo_site;
	@Column(name="link_site")
	private String link_site;
	@Column(name="assunto")
	private String assunto;
	

	@JoinColumn(name="doc_situa")
	private int doc_situa;


	public DocumentoEntity(int codigo, int ano, String data, int numero_doc, char principal, int codigo_site,
			String link_site, String assunto, int doc_situa) {
		super();
		this.codigo = codigo;
		this.ano = ano;
		this.data = data;
		this.numero_doc = numero_doc;
		this.principal = principal;
		this.codigo_site = codigo_site;
		this.link_site = link_site;
		this.assunto = assunto;
		this.doc_situa = doc_situa;
	}


	public DocumentoEntity() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public int getNumero_doc() {
		return numero_doc;
	}


	public void setNumero_doc(int numero_doc) {
		this.numero_doc = numero_doc;
	}


	public char getPrincipal() {
		return principal;
	}


	public void setPrincipal(char principal) {
		this.principal = principal;
	}


	public int getCodigo_site() {
		return codigo_site;
	}


	public void setCodigo_site(int codigo_site) {
		this.codigo_site = codigo_site;
	}


	public String getLink_site() {
		return link_site;
	}


	public void setLink_site(String link_site) {
		this.link_site = link_site;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public int getDoc_situa() {
		return doc_situa;
	}


	public void setDoc_situa(int doc_situa) {
		this.doc_situa = doc_situa;
	}
	
	
		
}
