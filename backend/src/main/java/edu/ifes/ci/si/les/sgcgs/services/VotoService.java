package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Voto;
import edu.ifes.ci.si.les.sgcgs.repositories.VotoRepository;

@Service
public class VotoService {
    @Autowired
    private VotoRepository repository;

    public Voto findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Voto> findAll() {
        return repository.findAll();
    }

    public Voto insert(Voto obj) {
        return repository.save(obj);
    }

    public Voto update(Voto obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
