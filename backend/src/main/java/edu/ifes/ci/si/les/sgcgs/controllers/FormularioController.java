package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.Formulario;
import edu.ifes.ci.si.les.sgcgs.services.FormularioService;

@RestController
@RequestMapping(value = "/formularios")
public class FormularioController {
    @Autowired
    private FormularioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Formulario>> findAll() {
        Collection<Formulario> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Formulario> find(@PathVariable Integer id) {
        Formulario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Formulario> insert(@RequestBody Formulario obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formulario> update(@RequestBody Formulario obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
