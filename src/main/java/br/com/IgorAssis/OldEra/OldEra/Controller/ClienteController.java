package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Cliente;
import br.com.IgorAssis.OldEra.OldEra.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping("/listar-todos")
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{nome}")
    public List<Cliente> buscaPorNome(@PathVariable String nome) {
        List<Cliente> cliente = clienteService.buscarPorNome(nome);
        return cliente;
    }

    @GetMapping("/{email}")
    public Integer contaPorEmail(@PathVariable String email) {
        Integer quant = clienteService.contaClientesPorEmail(email);
        return quant;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { clienteService.excluir(id); }
}


