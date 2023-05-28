package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.OldEra.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);

        return ResponseEntity.status(201).body(produtoSalvo);
    }

    @GetMapping("/buscarPorNome/{nome}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorNome(@PathVariable String nome) {
        return produtoService.buscarProdutosPorNome(nome);
    }

    @GetMapping("/buscarPorPreco")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorPreco(@RequestParam Double minPreco, @RequestParam Double maxPreco) {
        return produtoService.buscarProdutosPorPreco(minPreco, maxPreco);
    }

    @GetMapping("/listar-todos")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarTodosOsProdutos() {
        return produtoService.buscarTodosOsProdutos();
    }

    @GetMapping("/quantidade-produtos")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @ResponseStatus(HttpStatus.OK)
    public long contarQuantidade() {return produtoService.contarQuantidade(); }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
