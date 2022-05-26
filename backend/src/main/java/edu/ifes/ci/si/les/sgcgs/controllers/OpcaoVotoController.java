package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.OpcaoVoto;
import edu.ifes.ci.si.les.sgcgs.services.OpcaoVotoService;

@RestController
@RequestMapping(value = "/opcao-votos")
public class OpcaoVotoController {
    @Autowired
    private OpcaoVotoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<OpcaoVoto>> findAll() {
        Collection<OpcaoVoto> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OpcaoVoto> find(@PathVariable Integer id) {
        OpcaoVoto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OpcaoVoto> insert(@RequestBody OpcaoVoto obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OpcaoVoto> update(@RequestBody OpcaoVoto obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
