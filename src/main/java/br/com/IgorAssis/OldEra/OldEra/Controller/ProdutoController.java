package br.com.IgorAssis.OldEra.OldEra.Controller;

import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.OldEra.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/buscarPorNome/{nome}")
    public List<Produto> buscarProdutosPorNome(@PathVariable String nome) {
        return produtoService.buscarProdutosPorNome(nome);
    }

    @GetMapping("/buscarPorPreco")
    public List<Produto> buscarProdutosPorPreco(@RequestParam Double minPreco, @RequestParam Double maxPreco) {
        return produtoService.buscarProdutosPorPreco(minPreco, maxPreco);
    }

    @GetMapping("/listar-todos")
    public List<Produto> buscarTodosOsProdutos() {
        return produtoService.buscarTodosOsProdutos();
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return produtoSalvo;
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
