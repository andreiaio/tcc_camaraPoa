package br.com.camaraPoa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.camaraPoa.repository.entity.DocumentoEntity;

public class DocumentoRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public DocumentoRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_cmpoa");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 * RETORNA TODAS OS DOCUMENTOS CADASTRADOS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<DocumentoEntity> TodosDocumentos(){
		
		return this.entityManager.createQuery("SELECT d FROM DocumentoEntity d ORDER BY d.codigo").getResultList();
	}
	
	/**
	 * CONSULTA UM DOCUMENTO CADASTRADO PELO CÓDIGO
	 * */
	public DocumentoEntity GetDocumento(Integer codigo){
		
		return this.entityManager.find(DocumentoEntity.class, codigo);
	}

}
