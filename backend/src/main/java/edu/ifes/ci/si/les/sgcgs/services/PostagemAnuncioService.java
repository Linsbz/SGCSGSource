package edu.ifes.ci.si.les.sgcgs.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.AreaAnuncio;
import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;
import edu.ifes.ci.si.les.sgcgs.model.Anuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.AreaAnuncioRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemAnuncioRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.AnuncioRepository;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class PostagemAnuncioService {

	@Autowired
	private PostagemAnuncioRepository postagemAnuncioRepository;
	@Autowired
	private AnuncioRepository AnuncioRepository;
	@Autowired
	private AreaAnuncioRepository AreaAnuncioRepository;

	public PostagemAnuncio findById(Integer id) {
		try {
        	PostagemAnuncio obj = postagemAnuncioRepository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + PostagemAnuncio.class.getName());
        }
	}

	public Collection<PostagemAnuncio> findAll() {
		return postagemAnuncioRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
	public PostagemAnuncio insert(PostagemAnuncio obj) {
		try {
			if (verificarRegrasDeNegocio(obj)) {
				obj.setId(null);
				return postagemAnuncioRepository.save(obj);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Postagem Anuncio não foi(foram) preenchido(s): AreaAnuncio ou Anuncio");
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
	public PostagemAnuncio update(PostagemAnuncio obj) {
		try {
			findById(obj.getId());
			return postagemAnuncioRepository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Postagem Anuncio não foi(foram) preenchido(s): AreaAnuncio ou Anuncio");
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) //Todas as operações de persistência no BD serão realizadas em uma única transação (se tudo der certo commit, senão rollback em tudo).
	public void delete(Integer id) {
		findById(id);
		try {
			postagemAnuncioRepository.deleteById(id);
			postagemAnuncioRepository.flush();  // Forçando a sincronização da(s) alteração(ões) e remoção neste momento (assim, diante de qualquer problema, o catch conseguirá capturar a exceção nesta camada de serviço) 
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Postagem Anuncio!");
		} 
	}

	public boolean verificarRegrasDeNegocio(PostagemAnuncio obj) {

		boolean Result = true;
		// Regra de Negócio 1: Um anúncio por área de anúncio
		boolean R1 = false;
			// Verificando se existem reservas em aberto para a fita
		Collection <PostagemAnuncio> Col = postagemAnuncioRepository.findByAreaEstado(obj.getAreaAnuncio().getId());
		if (Col.size() > 0) {
			R1 = true;
			Result = false;
		}
		
		if (R1) {
			throw new BusinessRuleException("Anuncio em area ja publicada!");
		}

		// Regra de Negócio 2: O anuncio só pode estar em uma área de anúncio
		Integer aux = 0;
		// Verificando se existem reservas em aberto para a fita
		Collection <PostagemAnuncio> Col2 = postagemAnuncioRepository.findByAnuncio(obj.getAnuncio().getId());
		if (Col2.size() > 0) {
			Result = false;
			throw new BusinessRuleException("Anuncio ja postado em outra area de anuncio!");
		}

		return Result;

	}

	public Integer[] findByVisual() {
		return postagemAnuncioRepository.findByVisual();
	}

 }