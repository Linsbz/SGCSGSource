package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
import edu.ifes.ci.si.les.sgcgs.repositories.CompraTemaRepository;

@Service
public class CompraTemaService {
    @Autowired
    private CompraTemaRepository repository;

    public CompraTema findById(Integer id) {
        try{
            CompraTema obj  repository.findById(id).get();
            return obj;
        }catch{
            throw new ObjectNotFoundException("Compra do tema não encontrada! ID: " + id + ", Tipo: " + CompraTema.class.getName());
        }
    }

    public List<CompraTema> findAll() {
        return repository.findAll();
    }

    public CompraTema insert(CompraTema obj) {
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public CompraTema update(CompraTema obj) {
        findById(obj.getId());
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Compra de tema já faturada!");
        }
    }
}
