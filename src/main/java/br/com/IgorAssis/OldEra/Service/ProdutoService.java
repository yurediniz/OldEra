package br.com.IgorAssis.OldEra.Service;

import br.com.IgorAssis.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto create(Produto produto) { return repository.save(produto); }

    public List<Produto> findAll() { return repository.findAll(); }

    public Optional<Produto> findById(Long id) { return repository.findById(id); }

    public void delete(Long id) { repository.deleteById(id); }
}
