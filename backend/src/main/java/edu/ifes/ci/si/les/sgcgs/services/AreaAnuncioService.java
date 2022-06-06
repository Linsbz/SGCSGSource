package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.AreaAnuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.AreaAnuncioRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class AreaAnuncioService {
    @Autowired
    private AreaAnuncioRepository repository;

    public AreaAnuncio findById(Integer id) {
        try{
            AreaAnuncio obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e){
            throw new ObjectNotFoundException("Area de Anuncio não encontrada! ID: " + id + ", Tipo: " + AreaAnuncio.class.getName());
        }
    }

    public List<AreaAnuncio> findAll() {
        return repository.findAll();
    }

    public AreaAnuncio insert(AreaAnuncio obj) {
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public AreaAnuncio update(AreaAnuncio obj) {
        findById(obj.getId());
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir a Area de Anuncio ativa!");
        }
    }
}