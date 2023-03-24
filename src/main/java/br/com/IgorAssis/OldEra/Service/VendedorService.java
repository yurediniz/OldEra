package br.com.IgorAssis.OldEra.Service;

import br.com.IgorAssis.OldEra.Entity.Vendedor;
import br.com.IgorAssis.OldEra.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    VendedorRepository repository;

    public Vendedor create(Vendedor vendedor) { return repository.save(vendedor); }

    public List<Vendedor> findAll() { return repository.findAll(); }

    public Optional<Vendedor> findById(Long id) { return repository.findById(id); }

    public void delete(Long id) { repository.deleteById(id); }
}