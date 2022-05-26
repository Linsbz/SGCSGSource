package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.CampoDeFormulario;
import edu.ifes.ci.si.les.sgcgs.services.CampoDeFormularioService;

@RestController
@RequestMapping(value = "/campo-de-formularios")
public class CampoDeFormularioController {
    @Autowired
    private CampoDeFormularioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CampoDeFormulario>> findAll() {
        Collection<CampoDeFormulario> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CampoDeFormulario> find(@PathVariable Integer id) {
        CampoDeFormulario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CampoDeFormulario> insert(@RequestBody CampoDeFormulario obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CampoDeFormulario> update(@RequestBody CampoDeFormulario obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
