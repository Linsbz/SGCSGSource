package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.OpcaoVoto;
import edu.ifes.ci.si.les.sgcgs.repositories.OpcaoVotoRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class OpcaoVotoService {
    @Autowired
    private OpcaoVotoRepository repository;

    public OpcaoVoto findById(Integer id) {
        // return repository.findById(id).get();
        try{
            OpcaoVoto obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("OpcaoVoto não encontrada! ID: " + id + ", Tipo: " + OpcaoVoto.class.getName());
        }
    }

    public List<OpcaoVoto> findAll() {
        return repository.findAll();
    }

    public OpcaoVoto insert(OpcaoVoto obj) {
        // return repository.save(obj);
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório não foi preenchido!");
        }
    }

    public OpcaoVoto update(OpcaoVoto obj) {
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
        // repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma OpcaoVoto que esteja em alguma Enquete aberta!");
        }
    }
}
