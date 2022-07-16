package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifes.ci.si.les.sgcgs.model.Voto;
import edu.ifes.ci.si.les.sgcgs.services.VotoService;

/** @author Hilda Biazatti */

@RestController
@RequestMapping(value = "/votos")
public class VotoController {
    @Autowired
    private VotoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Voto>> findAll() {
        Collection<Voto> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Voto> find(@PathVariable Integer id) {
        Voto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Voto> insert(@RequestBody Voto obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Voto> update(@RequestBody Voto obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/relatorio", method = RequestMethod.GET)
    public ResponseEntity<Integer[]> findVisual() {
        Integer x[] = service.findByVisual();
        return ResponseEntity.ok().body(x);
    }
}
