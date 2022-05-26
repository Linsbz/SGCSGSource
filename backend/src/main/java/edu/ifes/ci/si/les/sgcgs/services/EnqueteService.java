package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Enquete;
import edu.ifes.ci.si.les.sgcgs.repositories.EnqueteRepository;

@Service
public class EnqueteService {
    @Autowired
    private EnqueteRepository repository;

    public Enquete findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Enquete> findAll() {
        return repository.findAll();
    }

    public Enquete insert(Enquete obj) {
        return repository.save(obj);
    }

    public Enquete update(Enquete obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
