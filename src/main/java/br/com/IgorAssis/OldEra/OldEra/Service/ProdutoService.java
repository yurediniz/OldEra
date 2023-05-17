package br.com.IgorAssis.OldEra.OldEra.Service;
import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.OldEra.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutosPorNome(String nome) {
        return produtoRepository.buscarProdutosPorNome(nome);
    }

    public List<Produto> buscarProdutosPorPreco(Double minPreco, Double maxPreco) {
        return produtoRepository.buscarProdutosPorPreco(minPreco, maxPreco);
    }

    public List<Produto> buscarTodosOsProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }}
