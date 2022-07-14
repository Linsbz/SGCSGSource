package edu.ifes.ci.si.les.sgcgs.controllers;

import java.sql.Date;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifes.ci.si.les.sgcgs.model.Tema;
import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
import edu.ifes.ci.si.les.sgcgs.services.CompraTemaService;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

//By Gabriel


@RestController
@RequestMapping(value = "/compratema")
public class CompraTemaController {

    @Autowired
    private CompraTemaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CompraTema>> findAll() {
        Collection<CompraTema> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompraTema> find(@PathVariable Integer id) {
        CompraTema obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CompraTema> insert(@Valid @RequestBody CompraTema obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompraTema> update(@Valid @RequestBody CompraTema obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
    	obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
    
    @RequestMapping(value = "/relatorio/findTotal/{inicio}", method = RequestMethod.GET)
    public ResponseEntity<Float> findTotal(@PathVariable String inicio) {
        float x = service.findTotal(inicio);
        return ResponseEntity.ok().body(x);
    }
    
    
        
}
