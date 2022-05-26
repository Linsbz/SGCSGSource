package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Tema;
import edu.ifes.ci.si.les.sgcgs.repositories.TemaRepository;

@Service
public class TemaService {
    @Autowired
    private TemaRepository repository;

    public Tema findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Tema> findAll() {
        return repository.findAll();
    }

    public Tema insert(Tema obj) {
        return repository.save(obj);
    }

    public Tema update(Tema obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
