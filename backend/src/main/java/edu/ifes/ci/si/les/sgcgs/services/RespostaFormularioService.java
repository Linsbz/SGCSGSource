package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.RespostaFormulario;
import edu.ifes.ci.si.les.sgcgs.repositories.RespostaFormularioRepository;

@Service
public class RespostaFormularioService {
    @Autowired
    private RespostaFormularioRepository repository;

    public RespostaFormulario findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<RespostaFormulario> findAll() {
        return repository.findAll();
    }

    public RespostaFormulario insert(RespostaFormulario obj) {
        return repository.save(obj);
    }

    public RespostaFormulario update(RespostaFormulario obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
