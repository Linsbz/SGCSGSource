package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Tema;
import edu.ifes.ci.si.les.sgcgs.repositories.TemaRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class TemaService {
    @Autowired
    private TemaRepository repository;

    public Tema findById(Integer id) {
        try{
            Tema obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e){
            throw new ObjectNotFoundException("Tema não encontrado! ID: " + id + ", Tipo: " + Tema.class.getName());
        }    
    }

    public List<Tema> findAll() {
        return repository.findAll();
    }

    public Tema insert(Tema obj) {
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }    
    }

    public Tema update(Tema obj) {
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
            throw new DataIntegrityException("Não é possível excluir um tema ativo!");
        }
    }
}
