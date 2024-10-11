package model.builder;

import model.Cliente;
import model.NotaFiscal;
import model.Produto;

import java.util.List;

/**
 * Author: Lucas Jardim
 */
public class NotaFiscalBuilder {
    private Cliente cliente;
    private List<Produto> produtos;

    public NotaFiscalBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public NotaFiscalBuilder setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public NotaFiscal build() {
        return new NotaFiscal(cliente, produtos);
    }
}
