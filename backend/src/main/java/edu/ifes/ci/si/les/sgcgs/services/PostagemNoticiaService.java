package edu.ifes.ci.si.les.sgcgs.services;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemNoticiaRepository;


import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
import java.util.NoSuchElementException;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** @author Júlia de Souza Borges */

@Service
public class PostagemNoticiaService {
    @Autowired
    private PostagemNoticiaRepository repository;

    public PostagemNoticia findById(Integer id) {
        // return repository.findById(id).get();
        try{
            PostagemNoticia obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Notícia não encontrada! ID: " + id + ", Tipo: " + PostagemNoticia.class.getName());
        }
    }

    public List<PostagemNoticia> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) 
    public PostagemNoticia insert(PostagemNoticia obj) {
        // return repository.save(obj);
        // obj.setId(null);
        try{
            if(NoticiaDestaque(obj) != true){
                obj.setId(null);
                // obj.setNoticia(obj.getNoticia());
                obj.setDestaque(false);
                repository.save(obj);
                throw new BusinessRuleException("Limite máximo de notícias em destaque atingido!");
            }
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public PostagemNoticia update(PostagemNoticia obj) {
        findById(obj.getId());
        // return repository.save(obj);
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("2-Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        // findById(id);
        // repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma notícia de um outro autor!");
        }
    }

    // Regra 2: validar a quantidade máxima de 3 notícias destaque
    public boolean NoticiaDestaque(PostagemNoticia obj) {
        if(repository.findNoticiaDestaque() != true){
            //throw new BusinessRuleException("Limite máximo de notícias em destaque atingido!");
            return false;
        }else{
           return true;
        }
    }
}