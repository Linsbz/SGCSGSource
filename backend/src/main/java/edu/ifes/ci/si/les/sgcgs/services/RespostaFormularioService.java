package edu.ifes.ci.si.les.sgcgs.services;

/** @author Felipe Gaspar */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.sgcgs.model.RespostaCampo;
import edu.ifes.ci.si.les.sgcgs.model.RespostaFormulario;
import edu.ifes.ci.si.les.sgcgs.repositories.RespostaCampoRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.RespostaFormularioRepository;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import java.util.NoSuchElementException;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespostaFormularioService {
    @Autowired
    private RespostaFormularioRepository repository;

    @Autowired
    private RespostaCampoRepository respostaCampoRepository;

    public RespostaFormulario findById(Integer id) {
        try {
        	RespostaFormulario obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + RespostaFormulario.class.getName());
        }
    }

    public List<RespostaFormulario> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public RespostaFormulario insert(RespostaFormulario obj) {
        try {
            obj.setId(null);
            for (RespostaCampo item : obj.getRespostaCampos()) {
                item.setRespostaFormulario(obj);
                respostaCampoRepository.save(item);
            }
            return repository.save(obj);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Formulário não foi(foram) respondido(s)");
		}
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public RespostaFormulario update(RespostaFormulario obj) {
        try {
            findById(obj.getId());
            for (RespostaCampo item : obj.getRespostaCampos()) {
                item.setRespostaFormulario(obj);
                respostaCampoRepository.save(item);
            }
            return repository.save(obj);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Formulário não foi(foram) respondido(s)");
		}
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
        try {
			repository.deleteById(id);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esta Resposta!");
		}
    }

    public boolean validaRegrasDeNegocio(Integer formularioId, Integer usuarioId) {
        if(!repository.formularioEstaAberto(formularioId))
            throw new BusinessRuleException("Não é possível responder formulários fechados");
        if(!repository.usuarioPodeResponder(usuarioId, formularioId))
            throw new BusinessRuleException("O usuário não pode responder o formulário no momento");
        return true;
    }
}