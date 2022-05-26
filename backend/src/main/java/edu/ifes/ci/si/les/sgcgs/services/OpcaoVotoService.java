package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.OpcaoVoto;
import edu.ifes.ci.si.les.sgcgs.repositories.OpcaoVotoRepository;

@Service
public class OpcaoVotoService {
    @Autowired
    private OpcaoVotoRepository repository;

    public OpcaoVoto findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<OpcaoVoto> findAll() {
        return repository.findAll();
    }

    public OpcaoVoto insert(OpcaoVoto obj) {
        return repository.save(obj);
    }

    public OpcaoVoto update(OpcaoVoto obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
