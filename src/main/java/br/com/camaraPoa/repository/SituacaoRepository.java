package br.com.camaraPoa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.camaraPoa.repository.entity.SituacaoEntity;

public class SituacaoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public SituacaoRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_cmpoa");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 * RETORNA TODAS AS SITUAÇÕES CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<SituacaoEntity> TodasSituacoes(){
		
		return this.entityManager.createQuery("SELECT s FROM SituacaoEntity s ORDER BY s.codigo").getResultList();
	}
	
	/**
	 * CONSULTA UMA SITUAÇÃO CADASTRA PELO CÓDIGO
	 * */
	public SituacaoEntity GetSituacao(Integer codigo){
		
		return this.entityManager.find(SituacaoEntity.class, codigo);
	}
	

}
