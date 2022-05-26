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
        return repository.findById(id).get();
    }

    public List<CompraTema> findAll() {
        return repository.findAll();
    }

    public CompraTema insert(CompraTema obj) {
        return repository.save(obj);
    }

    public CompraTema update(CompraTema obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
