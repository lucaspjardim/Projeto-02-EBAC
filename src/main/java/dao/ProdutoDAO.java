package dao;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lucas Jardim
 */
public class ProdutoDAO {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscarPorNome(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}
