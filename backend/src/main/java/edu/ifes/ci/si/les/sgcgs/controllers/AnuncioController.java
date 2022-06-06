package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.Anuncio;
import edu.ifes.ci.si.les.sgcgs.services.AnuncioService;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/Anuncios")
public class AnuncioController {
    @Autowired
    private AnuncioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> findAll() {
        Collection<Anuncio> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Anuncio> find(@PathVariable Integer id) {
        Anuncio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Anuncio> insert(@RequestBody Anuncio obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Anuncio> update(@RequestBody Anuncio obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
