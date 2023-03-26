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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvar(cliente);

        return ResponseEntity.status(201).body(clienteSalvo);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscaPorNome(@PathVariable String nome) {
        List<Cliente> cliente = clienteService.buscarPorNome(nome);
        return cliente;
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Integer contaPorEmail(@PathVariable String email) {
        Integer quant = clienteService.contaClientesPorEmail(email);
        return quant;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { clienteService.excluir(id); }
}


