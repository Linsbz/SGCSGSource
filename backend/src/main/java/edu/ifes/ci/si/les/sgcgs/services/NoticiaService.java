package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Noticia;
import edu.ifes.ci.si.les.sgcgs.repositories.NoticiaRepository;

// import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

/** @author Júlia de Souza Borges */

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository repository;

    public Noticia findById(Integer id) {
        // return repository.findById(id).get();
        try{
            Noticia obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Notícia não encontrada! ID: " + id + ", Tipo: " + Noticia.class.getName());
        }
    }

    public List<Noticia> findAll() {
        return repository.findAll();
    }

    public Noticia insert(Noticia obj) {
        //return repository.save(obj);
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public Noticia update(Noticia obj) {
        findById(obj.getId());
        // return repository.save(obj);
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        findById(id);
        // repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma notícia de um outro autor!");
        }
    }
}
