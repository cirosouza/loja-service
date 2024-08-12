package org.javaexercises.lojaservice.service.implementation;

import org.javaexercises.lojaservice.model.Loja;
import org.javaexercises.lojaservice.repository.LojaRepository;
import org.javaexercises.lojaservice.service.LojaService;
import org.javaexercises.lojaservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaServiceImplementation implements LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public List<Loja> getAll() {
        return lojaRepository.findAll();
    }

    @Override
    public Optional<Loja> getById(Long id) {
        Optional<Loja> loja = lojaRepository.findById(id);

        if (loja.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrada a loja com id: " + id);
        }
        return loja;
    }

    @Override
    public Loja update(Long id, Loja loja) {
        Optional<Loja> lojaOptional = getById(id);

        if (lojaOptional.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrada loja com id " + id);
        }

        Loja existingLoja = lojaOptional.get();
        existingLoja.setNome(loja.getNome());
        existingLoja.setEndereco(loja.getEndereco());
        existingLoja.setTelefone(loja.getTelefone());

        return lojaRepository.save(existingLoja);
    }

    @Override
    public Loja save(Loja loja) {
        return lojaRepository.save(loja);
    }

    @Override
    public void delete(Long id) {
        Optional<Loja> cliente = getById(id);

        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrada loja com id " + id);
        }

        lojaRepository.delete(cliente.get());
    }
}
