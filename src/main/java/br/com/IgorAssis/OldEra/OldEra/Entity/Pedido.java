package br.com.IgorAssis.OldEra.OldEra.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(optional = true)
    @JoinColumn(name = "vendedor", referencedColumnName = "id")
    private Vendedor vendedor;

    @ManyToOne(optional = true)
    @JoinColumn(name = "produto", referencedColumnName = "id")
    private Produto produto;

    private int quantidade;

    private double preco;

    private double valorTotal;


}