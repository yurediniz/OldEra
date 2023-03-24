package br.com.IgorAssis.OldEra.Service;

import br.com.IgorAssis.OldEra.Entity.Cliente;
import br.com.IgorAssis.OldEra.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) { repository.deleteById(id); }
}