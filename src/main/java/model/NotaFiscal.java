package model;

import java.util.List;

/**
 * Author: Lucas Jardim
 */
public class NotaFiscal {
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public NotaFiscal(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }

    public double getTotal() { return total; }
}
