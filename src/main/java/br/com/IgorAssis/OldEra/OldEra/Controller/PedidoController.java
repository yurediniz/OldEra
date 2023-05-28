package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Cliente;
import br.com.IgorAssis.OldEra.OldEra.Entity.Pedido;
import br.com.IgorAssis.OldEra.OldEra.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvar(pedido);

        return ResponseEntity.status(201).body(pedidoSalvo);
    }
}
