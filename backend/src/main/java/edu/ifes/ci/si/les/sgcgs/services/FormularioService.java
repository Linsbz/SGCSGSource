package edu.ifes.ci.si.les.sgcgs.services;

/** @author Felipe Gaspar */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Formulario;
//import edu.ifes.ci.si.les.sgcgs.model.RespostaFormulario;
//import edu.ifes.ci.si.les.sgcgs.model.RespostaCampo;
import edu.ifes.ci.si.les.sgcgs.model.CampoDeFormulario;
import edu.ifes.ci.si.les.sgcgs.repositories.CampoDeFormularioRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.FormularioRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import java.util.NoSuchElementException;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormularioService {
    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private CampoDeFormularioRepository campoDeFormluarioRepository;

	//@Autowired
    //private RespostaCampoRepository respostaCampoRepository;

    public Formulario findById(Integer id) {
		try {
        	Formulario obj = formularioRepository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Formulario.class.getName());
        }
	}

    public Collection<Formulario> findAll() {
		return formularioRepository.findAll();
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public Formulario insert(Formulario obj) {
		try {
            obj.setId(null);
            for (CampoDeFormulario item : obj.getItens()) {
                item.setFormulario(obj);
                campoDeFormluarioRepository.save(item);
            }
            return formularioRepository.save(obj);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Formulário não foi(foram) preenchido(s)");
		}
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public Formulario update(Formulario obj) {
		try {
			findById(obj.getId());
			for (CampoDeFormulario item : obj.getItens()) {
				item.setFormulario(obj);
				campoDeFormluarioRepository.save(item);
			}
			return formularioRepository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Formulário não foi(foram) preenchido(s).");
		}
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public void delete(Integer id) {
		findById(id);
		try {
			formularioRepository.deleteById(id);
			formularioRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Formulário!");
		} 
	}

	//public Collection<?>findRespostas(Integer id, String data_fim, String data_inicio){
    //    Collection<RespotaFormulario> respostas =  formularioRepository.findRespostas(id, data_fim, data_inicio);
	//	for (RespotaFormulario resposta : respostas) {
	//		resposta.setRespostasCampos(respostaCampoRepository.findRespostas(resposta.getId()));
	//	}
	//	return respostas
    //}
}