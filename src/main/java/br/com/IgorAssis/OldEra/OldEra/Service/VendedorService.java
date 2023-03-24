package br.com.IgorAssis.OldEra.OldEra.Service;

import br.com.IgorAssis.OldEra.OldEra.Entity.Vendedor;
import br.com.IgorAssis.OldEra.OldEra.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> buscarPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    public void excluir(Long id) {
        vendedorRepository.deleteById(id);
    }
}
