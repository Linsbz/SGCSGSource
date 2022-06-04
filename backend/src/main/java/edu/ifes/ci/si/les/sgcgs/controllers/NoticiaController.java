package edu.ifes.ci.si.les.sgcgs.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.ifes.ci.si.les.sgcgs.model.Noticia;
import edu.ifes.ci.si.les.sgcgs.services.NoticiaService;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaController {
    @Autowired
    private NoticiaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Noticia>> findAll() {
        Collection<Noticia> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Noticia> find(@PathVariable Integer id) {
        Noticia obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
 
    // @RequestMapping(method = RequestMethod.POST)
    // public ResponseEntity<Noticia> insert(@RequestBody Noticia obj) {
    //     obj = service.insert(obj);
    //     return ResponseEntity.ok().body(obj);
    // }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Noticia> insert(@Valid @RequestBody Noticia obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Noticia> update(@RequestBody Noticia obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
