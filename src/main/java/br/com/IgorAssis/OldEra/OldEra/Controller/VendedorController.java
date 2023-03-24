package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Vendedor;
import br.com.IgorAssis.OldEra.OldEra.Service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public Vendedor criarVendedor(@RequestBody Vendedor vendedor) {
        Vendedor vendedorCriado = vendedorService.salvar(vendedor);
        return vendedorCriado;
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<Vendedor> buscarPorId(@PathVariable Long id) {
        Optional<Vendedor> vendedor = vendedorService.buscarPorId(id);

        if (vendedor.isPresent()) {
            return ResponseEntity.ok(vendedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar-todos")
    public List<Vendedor> listar() { return vendedorService.listar(); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { vendedorService.excluir(id); }


}
