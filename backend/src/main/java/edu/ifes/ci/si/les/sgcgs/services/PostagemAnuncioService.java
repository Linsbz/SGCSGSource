// package edu.ifes.ci.si.les.scv.services;

// import java.util.Collection;
// import java.util.NoSuchElementException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;

// import edu.ifes.ci.si.les.scv.model.AreaAnuncio;
// import edu.ifes.ci.si.les.scv.model.PostagemAnuncio;
// import edu.ifes.ci.si.les.scv.model.Anuncio;
// import edu.ifes.ci.si.les.scv.repositories.AreaAnuncioRepository;
// import edu.ifes.ci.si.les.scv.repositories.PostagemAnuncioRepository;
// import edu.ifes.ci.si.les.scv.repositories.AnuncioRepository;
// import edu.ifes.ci.si.les.scv.services.exceptions.BusinessRuleException;
// import edu.ifes.ci.si.les.scv.services.exceptions.DataIntegrityException;
// import edu.ifes.ci.si.les.scv.services.exceptions.ObjectNotFoundException;

// @Service
// public class PostagemAnuncioService {

// 	@Autowired
// 	private PostagemAnuncioRepository postagemAnuncioRepository;
// 	@Autowired
// 	private AnuncioRepository AnuncioRepository;
// 	@Autowired
// 	private AreaAnuncioRepository AreaAnuncioRepository;

// 	public PostagemAnuncio findById(Integer id) {
// 		try {
//         	PostagemAnuncio obj = postagemAnuncioRepository.findById(id).get();
//         	return obj;
//         } catch (NoSuchElementException e) {
//         	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + PostagemAnuncio.class.getName());
//         }
// 	}

// 	public Collection<PostagemAnuncio> findAll() {
// 		return postagemAnuncioRepository.findAll();
// 	}

// 	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
// 	public PostagemAnuncio insert(PostagemAnuncio obj) {
// 		try {
// 			if (verificarRegrasDeNegocio(obj)) {
// 				obj.setId(null);
// 				obj.setAnuncio(obj.Anuncio);
// 				obj.setAreaAnuncio(obj.AreaAnuncio);
//                 obj.setdataI(obj.dataI);
//                 obj.setdataF(obj.dataF);
// 				return postagemAnuncioRepository.save(obj);
// 			}
// 		} catch (DataIntegrityViolationException e) {
// 			throw new DataIntegrityException("Campo(s) obrigatório(s) do Postagem Anuncio não foi(foram) preenchido(s): AreaAnuncio ou Anuncio");
// 		}
// 		return null;
// 	}

// 	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
// 	public PostagemAnuncio update(PostagemAnuncio obj) {
// 		try {
// 			findById(obj.getId());
// 			return postagemAnuncioRepository.save(obj);
// 		} catch (DataIntegrityViolationException e) {
// 			throw new DataIntegrityException("Campo(s) obrigatório(s) do Postagem Anuncio não foi(foram) preenchido(s): AreaAnuncio ou Anuncio");
// 		}
// 	}

// 	@Transactional(propagation = Propagation.REQUIRES_NEW) //Todas as operações de persistência no BD serão realizadas em uma única transação (se tudo der certo commit, senão rollback em tudo).
// 	public void delete(Integer id) {
// 		findById(id);
// 		try {
// 			postagemAnuncioRepository.deleteById(id);
// 			postagemAnuncioRepository.flush();  // Forçando a sincronização da(s) alteração(ões) e remoção neste momento (assim, diante de qualquer problema, o catch conseguirá capturar a exceção nesta camada de serviço) 
// 		} catch (DataIntegrityViolationException e) {
// 			throw new DataIntegrityException("Não é possível excluir este Postagem Anuncio!");
// 		} 
// 	}

// 	public boolean verificarRegrasDeNegocio(PostagemAnuncio obj) {

// 		// Regra de Negócio 1: Um anúncio por área de anúncio
// 		boolean R1 = false;
// 			// Verificando se existem reservas em aberto para a fita
// 		Collection <PostagemAnuncio> Col = postagemAnuncioRepository.findByAreaEstado(obj.getId().getAnuncio().getAreaAnuncio());
// 		if (col.size > 0) {
// 			R1 = true;
// 		}
		
// 		if (R1) {
// 			throw new BusinessRuleException("Anuncio em area ja publicada!");
// 		}

// 		// Regra de Negócio 2: O anuncio só pode estar em uma área de anúncio
// 		Integer aux = 0;
// 		// Verificando se existem reservas em aberto para a fita
// 		Collection <PostagemAnuncio> Col = postagemAnuncioRepository.findByAnuncio(obj.getId().getAnuncio());
// 		if (col.size>0) {
// 			throw new BusinessRuleException("Anuncio ja postado em outra area de anuncio!");
// 		}
// 	}

//  }