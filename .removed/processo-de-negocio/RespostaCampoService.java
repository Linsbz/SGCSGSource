package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.RespostaCampo;
import edu.ifes.ci.si.les.sgcgs.repositories.RespostaCampoRepository;

@Service
public class RespostaCampoService {
    @Autowired
    private RespostaCampoRepository repository;

    public RespostaCampo findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<RespostaCampo> findAll() {
        return repository.findAll();
    }

    public RespostaCampo insert(RespostaCampo obj) {
        return repository.save(obj);
    }

    public RespostaCampo update(RespostaCampo obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
