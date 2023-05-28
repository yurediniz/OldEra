package br.com.IgorAssis.OldEra.OldEra.Service;

import br.com.IgorAssis.OldEra.OldEra.Entity.Pedido;
import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import br.com.IgorAssis.OldEra.OldEra.Repository.PedidoRepository;
import br.com.IgorAssis.OldEra.OldEra.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) {

        double preco = produtoRepository.getReferenceById(pedido.getProduto().getId()).getPreco();
        pedido.setPreco(preco);

        pedido.setValorTotal(preco * pedido.getQuantidade());

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void excluir(Long id) {
        pedidoRepository.deleteById(id);
    }
}

