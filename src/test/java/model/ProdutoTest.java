package dao;

import model.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Lucas Jardim
 */
public class ProdutoTest {

    @Test
    public void testCriacaoProduto() {
        Produto produto = new Produto("Produto 1", 100.0, "Descrição do Produto 1");

        assertEquals("O nome do produto deve ser Produto 1", "Produto 1", produto.getNome());
        assertEquals("O preço do produto deve ser 100.0", 100.0, produto.getPreco(), 0.01);
        assertEquals("A descrição do produto deve ser Descrição do Produto 1", "Descrição do Produto 1", produto.getDescricao());

        System.out.println("Teste de criação de produto passou com sucesso!");
    }
}
