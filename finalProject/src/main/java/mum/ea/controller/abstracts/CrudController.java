package mum.ea.controller.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mum.ea.domain.abstracts.BaseDomain;
import mum.ea.service.abstracts.EaCrudService;

import java.util.List;

public abstract class CrudController<TDomain extends BaseDomain, TService extends EaCrudService<TDomain>>
        extends EaController {

    @Autowired
    private TService service;

    @PostMapping
    public void save(TDomain t) {
        service.save(t);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.delete(id);
    }

    @PutMapping
    public void update(@RequestBody TDomain t) {
        service.update(t);
    }

    @GetMapping(value = "/{id}" , produces = "application/json")
    public TDomain findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = "application/json")
    public List<TDomain> findAll() {
        return service.findAll();
    }

}
