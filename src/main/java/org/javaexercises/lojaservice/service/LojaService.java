package org.javaexercises.lojaservice.service;

import org.javaexercises.lojaservice.model.Loja;

import java.util.List;
import java.util.Optional;

public interface LojaService {

    public List<Loja> getAll();

    public Optional<Loja> getById(Long id);

    public Loja update(Long id, Loja loja);

    public Loja save(Loja loja);

    public void delete(Long id);
}
