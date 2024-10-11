package dao;

import model.Produto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Author: Lucas Jardim
 */
public class ProdutoDAOTest {

    private ProdutoDAO produtoDAO;

    @Before
    public void setUp() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void testAdicionarEListarProduto() {
        Produto produto = new Produto("Produto 1", 100.0, "Descrição do Produto 1");
        produtoDAO.adicionar(produto);

        assertEquals("Deve haver 1 produto na lista", 1, produtoDAO.listar().size());
        assertEquals("O nome do produto deve ser Produto 1", "Produto 1", produtoDAO.listar().get(0).getNome());

        System.out.println("Teste de adicionar e listar produto passou com sucesso!");
    }

    @Test
    public void testBuscarPorNome() {
        Produto produto = new Produto("Produto 1", 100.0, "Descrição do Produto 1");
        produtoDAO.adicionar(produto);

        Produto produtoEncontrado = produtoDAO.buscarPorNome("Produto 1");

        assertNotNull("O produto deve ser encontrado", produtoEncontrado);
        assertEquals("O nome do produto deve ser Produto 1", "Produto 1", produtoEncontrado.getNome());

        System.out.println("Teste de buscar produto por nome passou com sucesso!");
    }
}
