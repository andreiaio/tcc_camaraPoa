package br.com.camaraPoa.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.camaraPoa.http.Documento;
import br.com.camaraPoa.http.Situacao;
import br.com.camaraPoa.repository.DocumentoRepository;
import br.com.camaraPoa.repository.SituacaoRepository;
import br.com.camaraPoa.repository.entity.DocumentoEntity;
import br.com.camaraPoa.repository.entity.SituacaoEntity;


/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
		
	private final SituacaoRepository situacao = new SituacaoRepository();
	private final DocumentoRepository documento = new DocumentoRepository();
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	
	/**
	 * Esse método lista todas situações cadastradas na base
	 * */
//-----------------------------------SITUAÇÃO-------------------------------------------------
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasSituacoes")
	public List<Situacao> TodasSituacoes(){
		
		List<Situacao> situacoes =  new ArrayList<Situacao>();
		
		List<SituacaoEntity> listaEntitySituacoes = situacao.TodasSituacoes();
		
		for (SituacaoEntity situacao : listaEntitySituacoes) {
			
			situacoes.add(new Situacao(situacao.getCodigo(), situacao.getDescricao()));
			
		}
		
		return situacoes;
	}
	
	/**
	 * Esse método busca uma situacao cadastrada pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getSituacao/{codigo}")
	public Situacao GetSitucao(@PathParam("codigo") Integer codigo){
		
		SituacaoEntity entity = situacao.GetSituacao(codigo);
		
		if(entity != null)
			return new Situacao(entity.getCodigo(), entity.getDescricao());
		
		return null;
	}
		
//-----------------------------------DOCUMENTO-------------------------------------------------
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todosDocumentos")
	public List<Documento> TodosDocumentos(){
		
		List<Documento> documentos =  new ArrayList<Documento>();
		
		List<DocumentoEntity> listaEntityDocumentos = documento.TodosDocumentos();
		
		for (DocumentoEntity documento : listaEntityDocumentos) {
			
			documentos.add(new Documento(documento.getCodigo(), documento.getAno(),documento.getData(),
					documento.getNumero_doc(),documento.getPrincipal(), documento.getCodigo_site(),
					documento.getLink_site(), documento.getAssunto(),documento.getDoc_situa()));
			
			
		}
		
		return documentos;
	}
	
	/**
	 * Esse método busca uma situacao cadastrada pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getDocumento/{codigo}")
	public Documento GetDocumento(@PathParam("codigo") Integer codigo){
		
		DocumentoEntity entity = documento.GetDocumento(codigo);
		
		if(entity != null)
			return new Documento(entity.getCodigo(), entity.getAno(),entity.getData(),
					entity.getNumero_doc(),entity.getPrincipal(), entity.getCodigo_site(),
					entity.getLink_site(), entity.getAssunto(), entity.getDoc_situa());
		
		return null;
	}

}
