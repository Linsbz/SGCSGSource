package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.AreaAnuncio;
import edu.ifes.ci.si.les.sgcgs.services.AreaAnuncioService;

@RestController
@RequestMapping(value = "/AreaAnuncios")
public class AreaAnuncioController {
    @Autowired
    private AreaAnuncioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<AreaAnuncio>> findAll() {
        Collection<AreaAnuncio> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AreaAnuncio> find(@PathVariable Integer id) {
        AreaAnuncio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AreaAnuncio> insert(@RequestBody AreaAnuncio obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AreaAnuncio> update(@RequestBody AreaAnuncio obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
