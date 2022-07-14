package edu.ifes.ci.si.les.sgcgs.services;

import java.sql.Date;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
import edu.ifes.ci.si.les.sgcgs.model.Tema;
import edu.ifes.ci.si.les.sgcgs.repositories.UsuarioRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.CompraTemaRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.TemaRepository;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class CompraTemaService {

	@Autowired
	private CompraTemaRepository compraTemaRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public CompraTema findById(Integer id) {
		try {
        	CompraTema obj = compraTemaRepository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + CompraTema.class.getName());
        }
	}

	public Collection<CompraTema> findAll() {
		return compraTemaRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
	public CompraTema insert(CompraTema obj) {
		try {
			if (verificarRegrasDeNegocio(obj)) {
				return compraTemaRepository.save(obj);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Compra tema não foi(foram) preenchido(s): Usuario ou tema");
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
	public CompraTema update(CompraTema obj) {
		try {
			findById(obj.getId());
			return compraTemaRepository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Compra Tema não foi(foram) preenchido(s): Usuario ou tema");
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) //Todas as operações de persistência no BD serão realizadas em uma única transação (se tudo der certo commit, senão rollback em tudo).
	public void delete(Integer id) {
		findById(id);
		try {
			compraTemaRepository.deleteById(id);
			compraTemaRepository.flush();  // Forçando a sincronização da(s) alteração(ões) e remoção neste momento (assim, diante de qualquer problema, o catch conseguirá capturar a exceção nesta camada de serviço) 
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Compra Tema!");
		} 
	}

	public boolean verificarRegrasDeNegocio(CompraTema obj) {

		boolean real = true;
		// Regra de Negócio 1: Uma compr por tema
		boolean R1 = false;
			// Verificando se existem reservas em aberto para a fita
		Collection <CompraTema> Col = compraTemaRepository.findBytemaID(obj.getTema().getId());
		if (Col.size() > 0) {
			R1 = true;
		}
		
		if (R1) {
			real = false;
			throw new BusinessRuleException("Tema ja comprado!");
		}

		// Regra de Negócio 2: Duas compra mes
		Integer aux = 0;
		// Verificando se existem reservas em aberto para a fita
		Collection <CompraTema> Col2 = compraTemaRepository.findByData(obj.getTempo());
		if (Col2.size()>1) {
			real = false;
			throw new BusinessRuleException("2 compras por mes!");
		}

		return real;
	}

	public float findTotal(String inicio) {
		return compraTemaRepository.findTotal(inicio);
	}

 }