package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.OldEra.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);

        return ResponseEntity.status(201).body(produtoSalvo);
    }

    @GetMapping("/buscarPorNome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorNome(@PathVariable String nome) {
        return produtoService.buscarProdutosPorNome(nome);
    }

    @GetMapping("/buscarPorPreco")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorPreco(@RequestParam Double minPreco, @RequestParam Double maxPreco) {
        return produtoService.buscarProdutosPorPreco(minPreco, maxPreco);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarTodosOsProdutos() {
        return produtoService.buscarTodosOsProdutos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
