package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Enquete;
import edu.ifes.ci.si.les.sgcgs.repositories.EnqueteRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class EnqueteService {
    @Autowired
    private EnqueteRepository repository;

    public Enquete findById(Integer id) {
        //return repository.findById(id).get();
        try{
            Enquete obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Enquete não encontrada! ID: " + id + ", Tipo: " + Enquete.class.getName());
        }
    }

    public List<Enquete> findAll() {
        return repository.findAll();
    }

    public Enquete insert(Enquete obj) {
        //return repository.save(obj);
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório não foi preenchido!");
        }
    }

    public Enquete update(Enquete obj) {
        findById(obj.getId());
        //return repository.save(obj);
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        findById(id);
        //repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma enquete aberta!");
        }
    }
}
